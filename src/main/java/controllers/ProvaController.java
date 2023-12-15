/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import beans.ArquivoServiceLocal;
import gestaoProcessos.Arquivo;
import gestaoProcessos.TipoArquivo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author yodem
 */
@Named(value = "provaController")
@ViewScoped
public class ProvaController implements Serializable {
    @Inject
    ArquivoServiceLocal dataService;
    
    private List<Arquivo> arquivosProva;
    private List<Arquivo> arquivosGabarito;

    @PostConstruct
    public void init() {
        arquivosProva = dataService.buscarArquivosPorTipo(TipoArquivo.PROVA);
        arquivosGabarito = dataService.buscarArquivosPorTipo(TipoArquivo.GABARITO);
    }

    public List<Arquivo> getArquivosProva() {
        return arquivosProva;
    }

    public void setArquivosProva(List<Arquivo> arquivosProva) {
        this.arquivosProva = arquivosProva;
    }

    public List<Arquivo> getArquivosGabarito() {
        return arquivosGabarito;
    }

    public void setArquivosGabarito(List<Arquivo> arquivosGabarito) {
        this.arquivosGabarito = arquivosGabarito;
    }
}
