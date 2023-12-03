package Controllers;

import Beans.UsuarioServiceLocal;
import GestaoProcessos.Usuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Luis Guisso <luis dot guisso at ifnmg dot edu dot br>
 */
@Named
@RequestScoped
public class NewUserController {
    
    @Inject
    UsuarioServiceLocal dataService;
    
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
        dataService.salvar(user);
        
        System.out.println(">> "+ user.toString());
        
        return "/app/index?faces-redirect=true";
    }
    
}
