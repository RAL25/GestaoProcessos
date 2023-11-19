/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GestaoProcessos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.PrePersist;
import javax.ws.rs.DefaultValue;

/**
 * Classe Candidato
 * @author yodem
 */
@Entity(name= "candidato")
public class Candidato 
        extends Usuario 
        implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Boolean receberNoticias;

    public Candidato() {
        this.receberNoticias = false;
    }
    
    public Candidato( Boolean receberNoticias) {
        this.receberNoticias = receberNoticias;
    }

    public Boolean getReceberNoticias() {
        return receberNoticias;
    }

    public void setReceberNoticias(Boolean receberNoticias) {
        this.receberNoticias = receberNoticias;
    }

    @Override
    public String toString() {
        return "Candidato{" 
                + "receberNoticias=" + receberNoticias 
                + '}';
    }
    
    

}
