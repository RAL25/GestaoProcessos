/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GestaoProcessos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;

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
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.receberNoticias);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Candidato other = (Candidato) obj;
        return Objects.equals(this.receberNoticias, other.receberNoticias);
    }
    
    
    
    

}
