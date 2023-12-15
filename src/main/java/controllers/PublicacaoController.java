/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import beans.PublicacaoServiceLocal;
import gestaoProcessos.Categoria;
import gestaoProcessos.Publicacao;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author yodem
 */
@Named
@RequestScoped
public class PublicacaoController implements Serializable {

    @Inject
    PublicacaoServiceLocal dataService;

    List<Publicacao> publicacoes;

    List<Publicacao> publicacoesNoticias;

    List<Publicacao> publicacoesEditais;

    List<Publicacao> publicacoesProvas;
    
    List<Publicacao> publicacoesOrientacoes;

    @PostConstruct
    public void init() {
        publicacoes = this.getPublicacoes();
    }

    public PublicacaoController() {
        publicacoes = new ArrayList<>();
    }

    public List<Publicacao> getPublicacoes() {
        this.publicacoes = dataService.buscarTodos();
        System.out.println(">> " + publicacoes);
        return publicacoes;
    }

    public List<Publicacao> getPublicacoesNoticia() {
        return dataService.buscarTodosTipado(Categoria.NOTICIA);
    }

    public List<Publicacao> getPublicacoesNoticias() {
        this.publicacoesNoticias = dataService.buscarTodosTipado(Categoria.NOTICIA);
        System.out.println(">> " + publicacoesNoticias);
        return publicacoesNoticias;
    }

    public void setPublicacoesNoticias(List<Publicacao> publicacoesNoticias) {
        this.publicacoesNoticias = publicacoesNoticias;
    }

    public List<Publicacao> getPublicacoesEditais() {
        this.publicacoesNoticias = dataService.buscarTodosTipado(Categoria.EDITAL);
        System.out.println(">> " + publicacoesNoticias);
        return publicacoesNoticias;
    }
    
    public void setPublicacoesEditais(List<Publicacao> publicacoesEditais) {
        this.publicacoesEditais = publicacoesEditais;
    }
    
    public List<Publicacao> getPublicacoesProvas() {
        this.publicacoesNoticias = dataService.buscarTodosTipado(Categoria.PROVA_GABARITO);
        System.out.println(">> " + publicacoesNoticias);
        return publicacoesNoticias;
    }

    public void setPublicacoesProvas(List<Publicacao> publicacoesProvas) {
        this.publicacoesProvas = publicacoesProvas;
    }

    public List<Publicacao> getPublicacoesOrientacoes() {
        this.publicacoesNoticias = dataService.buscarTodosTipado(Categoria.ORIENTACAO);
        System.out.println(">> " + publicacoesNoticias);
        return publicacoesNoticias;
    }

    public void setPublicacoesOrientacoes(List<Publicacao> publicacoesOrientacoes) {
        this.publicacoesOrientacoes = publicacoesOrientacoes;
    }

    public String formatarDataHora(LocalDateTime dataHora) {
        if (dataHora != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return dataHora.format(formatter);
        }
        return "";
    }

}
