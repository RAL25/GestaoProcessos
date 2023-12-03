package Controllers;

import Beans.UserService;
import Beans.UsuarioServiceLocal;
import GestaoProcessos.Usuario;
import Util.MailServiceLocal;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mail.MessagingException;

/**
 *
 * @author Luis Guisso <luis dot guisso at ifnmg dot edu dot br>
 */
@Named
@RequestScoped
public class NewUserController {
    
    @Inject
    UsuarioServiceLocal dataService;
    
    @Inject
    MailServiceLocal mailService;
    
    private Usuario user;

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


    //</editor-fold>
    
    public String save() {
        user.setKey(UUID.randomUUID());
        user.setAtivo(false);
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
        
        System.out.println(">> "+ user.toString());

        return "/app/index?faces-redirect=true";
    }
    
}
