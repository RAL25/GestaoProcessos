/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GestaoProcessos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Classe Resultado
 * @author yodem
 */
@Entity
public class Resultado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double nota;
    
    @OneToOne
    private Participacao participacao;
    
    //<editor-fold defaultstate="collapsed" desc="construtores">
        public Resultado() {

        }
        public Resultado(Double nota, Participacao participacao) {
            this.nota = nota;
            this.participacao = participacao;
        }
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Double getNota() {
            return nota;
        }

        public void setNota(Double nota) {
            this.nota = nota;
        }

        public Participacao getParticipacao() {
            return participacao;
        }

        public void setParticipacao(Participacao participacao) {
            this.participacao = participacao;
        }
    //</editor-fold>

    @Override
    public String toString() {
        return "Resultado{" 
                + "id=" + id + ","
                + " nota=" + nota + ","
                + " participacao=" + participacao 
                + '}';
    }
}
