package Controllers;

import Beans.UsuarioService;
import Beans.UsuarioServiceLocal;
import GestaoProcessos.Usuario;
import java.io.IOException;
import java.io.Serializable;
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
public class LoginController implements Serializable {

    private String email;

    private String senha;

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
    //</editor-fold>

    public void execute() throws IOException {

        Usuario usuario = dataService.buscarPorEmail(email);

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
