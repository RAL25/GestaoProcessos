/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GestaoProcessos;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Classe Edital
 * @author yodem
 */
@Entity
public class Edital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate data;
    
    private Integer numero;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ArquivoEdital arquivoEdital;
    
    @Column(length = 1000)
    private String descricao;

    //<editor-fold defaultstate="collapsed" desc="construtores">
        
        public Edital() {
        }

        public Edital(LocalDate data, Integer numero, ArquivoEdital arquivoEdital, String descricao) {
            this.data = data;
            this.numero = numero;
            this.arquivoEdital = arquivoEdital;
            this.descricao = descricao;
        }

    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    public Long getId() {
        return id;
    }

        public void setId(Long id) {
            this.id = id;
        }
        
        public LocalDate getData() {
            return data;
        }

        public void setData(LocalDate data) {
            this.data = data;
        }

        public Integer getNumero() {
            return numero;
        }

        public void setNumero(Integer numero) {
            this.numero = numero;
        }

        public ArquivoEdital getArquivoEdital() {
            return arquivoEdital;
        }

        public void setArquivoEdital(ArquivoEdital arquivoEdital) {
            this.arquivoEdital = arquivoEdital;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
//</editor-fold>

    @Override
    public String toString() {
        return "Edital{" 
                + "id=" + id + ","
                + " data=" + data + ","
                + " numero=" + numero + ","
                + " arquivoEdital=" + arquivoEdital + ","
                + " descricao=" + descricao 
                + '}';
    }
        
    

}
