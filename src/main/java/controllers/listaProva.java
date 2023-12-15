/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import beans.ProvaSessionServiceLocal;
import gestaoProcessos.Prova;
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
@Named(value = "listaProva")
@ViewScoped
public class listaProva implements Serializable{
    @Inject
    ProvaSessionServiceLocal dataService;
    
    private List<Prova> provas;

    @PostConstruct
    public void init() {
        provas = dataService.buscarTodas();
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

    public listaProva() {
    }
    
}
