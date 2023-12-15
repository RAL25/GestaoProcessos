/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import beans.ArquivoServiceLocal;
import beans.ProvaSessionServiceLocal;
import gestaoProcessos.Arquivo;
import gestaoProcessos.Prova;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author yodem
 */
@Named(value = "newProvaController")
@RequestScoped
public class NewProvaController {

    private Prova prova;
    private String pathProva;
    private String pathGabarito;
    
    @Inject
    private ArquivoServiceLocal arquivoService;
    
    @Inject
    private ProvaSessionServiceLocal provaService;

    public NewProvaController() {
        prova = new Prova();
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public String getPathProva() {
        return pathProva;
    }

    public void setPathProva(String pathProva) {
        this.pathProva = pathProva;
    }

    public String getPathGabarito() {
        return pathGabarito;
    }

    public void setPathGabarito(String pathGabarito) {
        this.pathGabarito = pathGabarito;
    }
    
    

    public String cadastrarProva() {

        Arquivo arquivoGabartiro = arquivoService.buscarPorPath(this.getPathGabarito());
        Arquivo arquivoProva = arquivoService.buscarPorPath(this.getPathProva());
        
        if (arquivoGabartiro != null) {
            this.prova.setArquivoGabarito(arquivoGabartiro);

        }
        
        if (arquivoProva != null) {
            this.prova.setArquivoprova(arquivoProva);
        }

        provaService.salvar(prova);

        return "/app/editor/prova/index?faces-redirect=true?faces-redirect=true";
    }

}
