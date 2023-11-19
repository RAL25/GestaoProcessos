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

/**
 * Classe ArquivoProva
 * @author yodem
 */
@Entity(name="prova")
public class ArquivoProva
        extends Arquivo
        implements Serializable {

    private static final long serialVersionUID = 1L;

    public ArquivoProva() {
    }

    @Override
    public String toString() {
        return "ArquivoProva{" + '}';
    }
    
    

}
