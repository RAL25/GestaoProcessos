package controllers;

import beans.UserService;
import beans.UsuarioService;
import beans.UsuarioServiceLocal;
import gestaoProcessos.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.MessagingException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import util.MailServiceLocal;

/**
 *
 * @author Gabriel Sizilio <gabriel.sizilio>
 */
@Named
@RequestScoped
public class LoginController implements Serializable {

    @Inject
    FacesContext facesContext;

    @Inject
    SecurityContext securityContext;

    @Inject
    UsuarioServiceLocal dataService;
    
    @Inject
    MailServiceLocal mailService;
    
    private String email;

    private String senha;
    
    private Usuario usuario;


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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    //</editor-fold>

    public void execute() throws IOException {

        usuario = dataService.buscarPorEmail(email);

        if (usuario == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "Usuário não cadastrado no sistema!", null);
        } else {

            if (!usuario.getAtivo()) {
                addMessage(FacesMessage.SEVERITY_WARN, "Cheque seu email para ativar sua conta", null);
            } else {

                switch (processAuthentication()) {
                    case SEND_CONTINUE:
                        facesContext.responseComplete();
                        break;
                    case SEND_FAILURE:
                        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciais inválidas!", null));
                        break;
                    case SUCCESS:
                        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/index.xhtml");
                        break;
                }
            }
        }
    }

    public void recuperarSenha() throws IOException {

        Usuario usuario = dataService.buscarPorEmail(email);

        if (usuario == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "Usuário não cadastrado no sistema!", null);
        } else {
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

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage("msgs", new FacesMessage(severity, summary, detail));
    }

    private AuthenticationStatus processAuthentication() {
        ExternalContext ec = getExternalContext();
        return securityContext.authenticate(
                (HttpServletRequest) ec.getRequest(),
                (HttpServletResponse) ec.getResponse(),
                AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(email, senha)));
    }

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }
}
