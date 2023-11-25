/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestaoProcessos;

import Util.Util;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 65)
    private String nome;
    
    @Column(length = 11, unique = true)
    private String cpf;    
    
    @Column(length = 250, unique = true)
    private String email;   
    
    private String senha;
    
    private Boolean receberNoticia;
    
    private TipoUsuario tipo;
    
    private Boolean ativo;
    
    private String salt;
    
    private UUID key;
    
    //<editor-fold defaultstate="collapsed" desc="construtores">
        public Usuario() {
        }

        public Usuario(String nome, String cpf, String email, String senha, Boolean receberNoticia, TipoUsuario tipo) {
            this.nome = nome;
            this.cpf = cpf;
            this.email = email;
            this.senha = senha;
            this.receberNoticia = receberNoticia;
            this.tipo = tipo;
        }
        
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String[] hash = Util.hash(senha);
        this.senha = (hash[Util.ENCPASSWD]);
        
        setSalt(hash[Util.SALT]);
    }

    public Boolean getReceberNoticia() {
        return receberNoticia;
    }

    public void setReceberNoticia(Boolean receberNoticia) {
        this.receberNoticia = receberNoticia;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public UUID getKey() {
        return key;
    }

    public void setKey(UUID key) {
        this.key = key;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    //</editor-fold>
    
    @Override
    public String toString() {
        return "Usuario{" 
                + "id=" + id 
                + ", nome=" + nome + ","
                + " cpf=" + cpf + ","
                + " email=" + email + ","
                + '}';
    }

    
    
}
