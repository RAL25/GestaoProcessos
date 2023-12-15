/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import beans.ArquivoServiceLocal;
import gestaoProcessos.Arquivo;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author yodem
 */
@Named(value = "listaArquivo")
@ViewScoped
public class ListaArquivo implements Serializable {

    @Inject
    ArquivoServiceLocal dataService;

    private List<Arquivo> listaArquivos;
    private Arquivo arquivoSelecionado;

    @PostConstruct
    public void init() {
        listaArquivos = new ArrayList<>();
        listaArquivos = dataService.buscarTodos();
    }

    public List<Arquivo> getListaArquivos() {
        return listaArquivos;
    }

    public void setListaArquivos(List<Arquivo> listaArquivos) {
        this.listaArquivos = listaArquivos;
    }

    public Arquivo getArquivoSelecionado() {
        return arquivoSelecionado;
    }

    public void setArquivoSelecionado(Arquivo arquivoSelecionado) {
        this.arquivoSelecionado = arquivoSelecionado;
    }

    public void atualizarArquivo(RowEditEvent event) {
        Arquivo arquivoEditado = (Arquivo) event.getObject();

        listaArquivos.remove(arquivoEditado);

        arquivoEditado.setTipo(arquivoSelecionado.getTipo());

        listaArquivos.add(arquivoEditado);
        dataService.editar(arquivoEditado);

    }

    public void excluirArquivo() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
        String path = params.get("idArquivo");

        if (path != null) {
            dataService.deletarPorPath(path);

            listaArquivos = dataService.buscarTodos();

            try {
                Path arquivoPath = Paths.get(path);
                Files.delete(arquivoPath);
            } catch (IOException e) {
                // Lidar com exceções, se necessário
                e.printStackTrace();
            }

        }
    }

    public ListaArquivo() {
        arquivoSelecionado = new Arquivo();
    }

}
