/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GestaoProcessos;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe Inscricao
 * @author yodem
 */
@Entity
public class Inscricao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "processoSeletivo_id")
    private ProcessoSeletivo processoSeletivo;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "candidato_id")
    private Usuario candidato;

    private LocalDate dataInscricao;
    
    private Double nota;
    
//<editor-fold defaultstate="collapsed" desc="construtores">

        public Inscricao() {
        }

        public Inscricao(ProcessoSeletivo processoSeletivo, Usuario candidato, LocalDate dataInscricao, Double nota) {
            this.processoSeletivo = processoSeletivo;
            this.candidato = candidato;
            this.dataInscricao = dataInscricao;
            this.nota = nota;
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

        public Usuario getCandidato() {
            return candidato;
        }

        public void setCandidato(Usuario candidato) {
            this.candidato = candidato;
        }

        public LocalDate getDataInscricao() {
            return dataInscricao;
        }

        public void setDataInscricao(LocalDate dataInscricao) {
            this.dataInscricao = dataInscricao;
        }

        public Double getNota() {
            return nota;
        }

        public void setNota(Double nota) {
            this.nota = nota;
        }

    //</editor-fold>

    @Override
    public String toString() {
        return "Inscricao{" + 
                "id=" + id + ", "
                + "processoSeletivo=" + processoSeletivo + ", "
                + "candidato=" + candidato + ", "
                + "dataInscricao=" + dataInscricao + ", "
                + "nota=" + nota + 
                '}';
    }
}
