/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import beans.ProvaSessionServiceLocal;
import beans.PublicacaoServiceLocal;
import gestaoProcessos.Prova;
import gestaoProcessos.Publicacao;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author yodem
 */
@Named(value = "newPublicacaoController")
@RequestScoped
public class NewPublicacaoController {
    @Inject ProvaSessionServiceLocal provaService;
    @Inject PublicacaoServiceLocal publicacaoService;
    
    Publicacao publicacao;
    
    String id;
    public NewPublicacaoController() {
        publicacao = new Publicacao();
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    public String cadastrarPublicacao() {
       Prova prova = provaService.buscarPorId(Long.valueOf(id));
       
       publicacao.setProva(prova);
       
       publicacaoService.salvar(publicacao);
       
       return "/provas?faces-redirect=true";
    }
    
}
