/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestaoProcessos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author gabriel
 */
@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length=50)
    private String nome;
    
    //<editor-fold defaultstate="collapsed" desc="construtores">
        public Categoria() {
        }

        public Categoria(String nome) {
            this.nome = nome;
        }
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
//</editor-fold>

    @Override
    public String toString() {
        return "Categoria{" 
                + "id=" + id + ","
                + " nome=" + nome 
                + '}';
    }    

}
