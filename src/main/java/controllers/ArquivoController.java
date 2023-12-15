/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import beans.ArquivoServiceLocal;
import gestaoProcessos.Arquivo;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.model.file.UploadedFileWrapper;

/**
 *
 * @author yodem
 */
@Named
@RequestScoped
public class ArquivoController implements Serializable {

    @Inject
    ArquivoServiceLocal dataService;
    
    private Arquivo arquivo;

    private UploadedFileWrapper file;

    public ArquivoController() {
        arquivo = new Arquivo();
    }

    public UploadedFileWrapper getFile() {
        return file;
    }

    public void setFile(UploadedFileWrapper file) {
        this.file = file;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public String cadastrarArquivo() {
        if (file != null) {
            try {
                String nomeArquivo = getNomeArquivo();

                if (nomeArquivo != null) {
                    String identificadorUnico = UUID.randomUUID().toString();
                    String nomeArquivoUnico = identificadorUnico + "_" + nomeArquivo;
                    arquivo.setNome(nomeArquivo);

                    String destino = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/uploads/");

                    Path caminhoCompleto = Paths.get(destino, nomeArquivoUnico);

                    Files.createDirectories(caminhoCompleto.getParent());

                    arquivo.setPath(caminhoCompleto.toString());

                    try (InputStream inputStream = file.getInputStream()) {
                        Files.copy(inputStream, caminhoCompleto, StandardCopyOption.REPLACE_EXISTING);
                        dataService.salvar(arquivo);
                        return "/app/editor/arquivos/index?faces-redirect=true";
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("O nome do arquivo é nulo.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O arquivo é nulo.");
        }
        return null;
    }

    private String getNomeArquivo() {
        if (file != null && file.getFileName() != null) {
            String nomeArquivo = file.getFileName();
            return nomeArquivo.replaceAll("\\s", "_");
        } else {
            System.out.println("O arquivo ou o nome do arquivo é nulo.");
            return null;
        }
    }

    // Método auxiliar para obter o nome do arquivo original
//    private String getNomeArquivo(Part part) {
//        for (String content : part.getHeader("content-disposition").split(";")) {
//            if (content.trim().startsWith("filename")) {
//                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
//            }
//        }
//        return "arquivo_desconhecido";
//    }
}
