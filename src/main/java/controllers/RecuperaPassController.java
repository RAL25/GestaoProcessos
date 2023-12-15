package controllers;

import beans.UsuarioServiceLocal;
import gestaoProcessos.Usuario;
import util.MailServiceLocal;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Gabriel Sizilio <gabriel.sizilio>
 */
@Named
@SessionScoped
public class RecuperaPassController implements Serializable {

    @Inject
    UsuarioServiceLocal dataService;

    private Usuario user;

    private String email;
    
    private String novaSenha;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
    
    //</editor-fold>
    
    @PostConstruct
    public void init() {
        this.user = new Usuario();
        System.out.println(" entrou!");
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        this.email = externalContext.getRequestParameterMap().get("email");

        System.out.println(">> email: " + email);

        if (email != null) {
            this.user = dataService.buscarPorEmail(email);

            if (user != null) {
                System.out.println(">> user: " + user.toString());
            } else {
                System.out.println(">> Usuário não encontrado para o email: " + email);
            }
        } else {
            System.out.println(">> Email não encontrado na URL");
        }
    }

    public String atualiza() throws InterruptedException {

        if (user == null) {
            return "/index?faces-redirect=true";

        } else {
            user.setSenha(novaSenha);
            
            dataService.editar(user);
            System.out.println(">> Editado com sucesso!");

            return "/login?faces-redirect=true";
        }
    }
}
