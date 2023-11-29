/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import GestaoProcessos.Usuario;
import Util.Util;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.MessagingException;
import Util.MailServiceLocal;

/**
 *
 * @author Gabriel Sizilio <gabriel.sizilio>
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @Inject
    UsuarioBeanLocal usuarioBean;
    
    @Inject
    MailServiceLocal mailService;
    
    private String email;
    private String senha;
    private Boolean autenticado;

    private Usuario usuario;

    public UserBean() {
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

    public String processPassword() {
        
        // Recupera usuário do banco de dados
        Usuario registeredUser = usuarioBean.buscarPorEmail(email);


        if (registeredUser == null) {
            usuario = new Usuario();
            usuario.setEmail(email);
            System.out.println(">> " + usuario.getEmail());
            return "registration?faces-redirect=true";

        } else {
            // Se o usuário está cadastrado, valida acesso
            if (Util.isAuthentic(senha, registeredUser)) {
                if (registeredUser.getAtivo()) {
                    autenticado = true;
                    return "/admin/index?faces-redirect=true";
                } else {
                    // ou informa que a validação do email é requerida
                    return "checkemail?faces-redirect=true";
                }

            } else {
                // ou informa falha no acesso
                autenticado = false;
                return null;
            }
        }
    }

    public String userRegistration() {
        usuario.setKey(UUID.randomUUID());
        usuario.setAtivo(false);
        usuarioBean.salvar(usuario);

        System.out.println(">> User registration: "
                + usuarioBean.buscarPorEmail(
                        usuario.getEmail()));

        String link = "http://127.0.0.1:8080"
                + "/WebAcctivationKeyByMail"
                + "/Activation?email=" + usuario.getEmail()
                + "&activationKey=" + usuario.getKey();
        System.out.println(">> " + link);

        //
        // Send mail
        // 
        try {
            mailService.sendEmail(usuario.getNome(),
                    usuario.getEmail(), link);
            
        } catch (MessagingException ex) {
            Logger.getLogger(UserBean.class.getName())
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

}
