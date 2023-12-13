/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import gestaoProcessos.Usuario;
import util.Util;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.MessagingException;
import util.MailServiceLocal;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.security.enterprise.SecurityContext;

/**
 *
 * @author Gabriel Sizilio <gabriel.sizilio>
 */
@Named(value = "userService")
@RequestScoped
public class UserService implements Serializable {

    @Inject
    UsuarioServiceLocal usuarioBean;

    @Inject
    MailServiceLocal mailService;

    @Inject
    SecurityContext securityContext;

    @Inject
    FacesContext facesContext;

    @Inject
    UsuarioServiceLocal dataService;

    private String email;
    private String senha;
    private Boolean autenticado;

    private Usuario usuario;

    @PostConstruct
    public void initialize() {
        email = securityContext.getCallerPrincipal().getName();
        this.usuario = dataService.buscarPorEmail(email);
    }

    public UserService() {
        usuario = new Usuario();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //</editor-fold>
    public boolean permiteCadastrarUsuario() {
        return securityContext.isCallerInRole("0");
    }
    
    public boolean permiteCadastrarNoticias() {
        return securityContext.isCallerInRole("1");
    }

    public String userRegistration() {
        usuario.setKey(UUID.randomUUID());
        usuario.setAtivo(false);
        System.out.println(">>" + usuario.getTipo());

        usuarioBean.salvar(usuario);

        System.out.println(">> User registration: "
                + usuarioBean.buscarPorEmail(
                        usuario.getEmail()));

        String link = "http://127.0.0.1:8080"
                + "/gestaoprocessos"
                + "/Activation?email=" + usuario.getEmail()
                + "&activationKey=" + usuario.getKey();
        System.out.println(">> " + link);

        try {
            mailService.sendEmail(usuario.getNome(),
                    usuario.getEmail(), link);

        } catch (MessagingException ex) {
            Logger.getLogger(UserService.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        // Reset
        senha = null;
        autenticado = null;
        usuario = new Usuario();

        // Reload login page
        return "checkemail?faces-redirect=true";
    }

    public String logout() {
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .invalidateSession();
        return "/index?faces-redirect=true";
    }

    public void recuperaSenha() {
        String link = "http://127.0.0.1:8080"
                + "/gestaoprocessos"
                + "/Recuperar-senha?email=" + usuario.getEmail()
                + "&activationKey=" + usuario.getKey();
        System.out.println(">> " + link);

        try {

            mailService.recoveryPass(usuario.getNome(),
                    usuario.getEmail(), link);

            FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Um link para recuperação foi enviada para seu email!", null));

        } catch (MessagingException ex) {
            Logger.getLogger(UserService.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
