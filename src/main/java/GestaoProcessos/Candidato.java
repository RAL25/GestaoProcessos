/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GestaoProcessos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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
    
    //<editor-fold defaultstate="collapsed" desc="construtores">
        public Candidato() {
            super();
            this.receberNoticias = false;
        }
        
        public Candidato( Boolean receberNoticias) {
            this.receberNoticias = receberNoticias;
        }

        public Candidato(Boolean receberNoticias, String nome, String cpf, String email, String senha) {
            super(nome, cpf, email, senha);
            this.receberNoticias = receberNoticias;
        }
        public Candidato(Boolean receberNoticias, List<Participacao> participacoes, String nome, String cpf, String email, String senha) {
            super(nome, cpf, email, senha);
            this.receberNoticias = receberNoticias;
            this.participacoes = participacoes;
        }

        
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
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
    //</editor-fold>

    @Override
    public String toString() {
        return "Candidato{" 
                + super.toString()+ ","
                + "receberNoticias=" + receberNoticias + ","
                + " participacoes=" + participacoes 
                + '}';
    }

}
