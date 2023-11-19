/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GestaoProcessos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe Participacao
 * @author yodem
 */
@Entity
public class Participacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "processoSeletivo_id")
    private ProcessoSeletivo processoSeletivo;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;


    //<editor-fold defaultstate="collapsed" desc="construtores">

        public Participacao() {
        }

        public Participacao(ProcessoSeletivo processoSeletivo, Candidato candidato) {
            this.processoSeletivo = processoSeletivo;
            this.candidato = candidato;
        }
        
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    public Long getId() {
        return id;
    }

        public void setId(Long id) {
            this.id = id;
        }

        public ProcessoSeletivo getProcessoSeletivo() {
            return processoSeletivo;
        }

        public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
            this.processoSeletivo = processoSeletivo;
        }

        public Candidato getCandidato() {
            return candidato;
        }
        
        public void setCandidato(Candidato candidato) {
            this.candidato = candidato;
        }
    //</editor-fold>
        
    @Override
    public String toString() {
        return "Participacao{" 
                + "id=" + id + ", "
                + "processoSeletivo=" + processoSeletivo + ", "
                + "candidato=" + candidato 
                + '}';
    }
    
    

}
