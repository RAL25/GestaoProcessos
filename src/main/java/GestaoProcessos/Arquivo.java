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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe Arquivo
 * @author yodem
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Arquivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    private String path;
    
    //<editor-fold defaultstate="collapsed" desc="construtores">

        public Arquivo() {
        }
        
        public Arquivo(String nome, String path) {
            this.nome = nome;
            this.path = path;
        }

    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    //</editor-fold>

    @Override
    public String toString() {
        return "{" + "id=" + id + ", nome=" + nome + ", path=" + path + '}';
    }

}
