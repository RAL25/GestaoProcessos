/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Named(value = "menuService")
@SessionScoped
public class MenuService implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String logout() {
        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .invalidateSession();
        return "logout";
    }

}
