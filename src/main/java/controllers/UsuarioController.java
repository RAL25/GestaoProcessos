package controllers;

import beans.UsuarioService;
import beans.UsuarioServiceLocal;
import gestaoProcessos.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;

@Named
@RequestScoped
public class UsuarioController implements Serializable {

    private String email;

    private String senha;
    
    private List<Usuario> usuarios;
    
    private List<Usuario> selectedUsuarios;
    
    private Usuario selectedUsuario;

    @Inject
    FacesContext facesContext;

    @Inject
    SecurityContext securityContext;

    @Inject
    UsuarioServiceLocal dataService;

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

    public List<Usuario> getUsuarios() {
        return dataService.buscarTodos();
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public void setSelectedUsuarios(List<Usuario> selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
        
    }
    
    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    //</editor-fold>


    

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }
}
