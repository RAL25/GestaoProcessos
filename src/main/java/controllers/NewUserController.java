package controllers;

import beans.UserService;
import beans.UsuarioServiceLocal;
import gestaoProcessos.Usuario;
import util.MailServiceLocal;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.validation.constraints.Email;

/**
 *
 * @author Luis Guisso <luis dot guisso at ifnmg dot edu dot br>
 */
@Named
@RequestScoped
public class NewUserController implements Serializable {

    @Inject
    UsuarioServiceLocal dataService;

    @Inject
    MailServiceLocal mailService;

    private Usuario user;

    private String email;

    /**
     * Creates a new instance of NewUserController
     */
    public NewUserController() {
        user = new Usuario();
    }

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

    //</editor-fold>
    public String save() throws InterruptedException {
        user.setKey(UUID.randomUUID());
        user.setAtivo(false);
        this.removeMask();
        dataService.salvar(user);

        String link = "http://127.0.0.1:8080"
                + "/gestaoprocessos"
                + "/Activation?email=" + user.getEmail()
                + "&activationKey=" + user.getKey();
        System.out.println(">> " + link);

        try {
            mailService.sendEmail(user.getNome(),
                    user.getEmail(), link);

        } catch (MessagingException ex) {
            Logger.getLogger(UserService.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        System.out.println(">> " + user.toString());

        return "/checkemail?faces-redirect=true";
    }

    public void removeMask() {
        String cpf = user.getCpf();
        if (cpf != null) {
            user.setCpf(cpf.replaceAll("[^0-9]", ""));
        }
    }
}
