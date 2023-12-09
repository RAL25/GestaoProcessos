/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Named(value = "menuAplication")
@ApplicationScoped
public class MenuAplication {

    public String canItBeRendered(String page) {
        FacesContext context = FacesContext.getCurrentInstance();
        String expression = "#{view.viewId"
                + ".replace('/', '')"
                + ".replace('.xhtml','') ne '" + page + "'}";
        String rendered = context.getApplication()
                .evaluateExpressionGet(
                        context,
                        expression,
                        String.class);
        System.out.println(">>> Rendered? " + expression + " > " + rendered);
        return rendered;
    }
    
}
