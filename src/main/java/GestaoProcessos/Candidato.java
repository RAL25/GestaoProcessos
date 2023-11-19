/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GestaoProcessos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
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
    
    @OneToMany(mappedBy = "candidato",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Participacao> participacoes;

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

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(List<Participacao> participacoes) {
        this.participacoes = participacoes;
    }

    @Override
    public String toString() {
        return "Candidato{" 
                + "receberNoticias=" + receberNoticias 
                + '}';
    }
    
    

}
