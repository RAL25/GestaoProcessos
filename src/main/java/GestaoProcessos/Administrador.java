/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GestaoProcessos;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * Classe Administrador
 * @author yodem
 */
@Entity(name = "administrador")
public class Administrador 
        extends Usuario
        implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    //<editor-fold defaultstate="collapsed" desc="construtores">
        public Administrador(String nome, String cpf, String email, String senha) {        
            super(nome, cpf, email, senha);
        }
        
        public Administrador() {
            super();
        }
    //</editor-fold>

    @Override
    public String toString() {
        return "Administrador{" + '}';
    }
    
    

}
