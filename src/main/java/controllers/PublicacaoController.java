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

    public String formatarDataHora(LocalDateTime dataHora) {
        if (dataHora != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return dataHora.format(formatter);
        }
        return "";
    }

}
