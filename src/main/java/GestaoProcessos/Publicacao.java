/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestaoProcessos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author gabriel
 */
@Entity
public class Publicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length=50)
    private String titulo;
    
    @Column(length=1000)
    private String conteudo;

    @OneToOne()
    private Categoria categoria;
    
    @OneToOne
    private Edital edital;

    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    //<editor-fold defaultstate="collapsed" desc="construtores">
        public Publicacao() {
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
        }

        public Publicacao(String titulo, String conteudo, Categoria categoria, Edital edital) {
            this();
            this.titulo = titulo;
            this.conteudo = conteudo;
            this.categoria = categoria;
            this.edital = edital;
        }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
            setUpdatedAt(LocalDateTime.now());
        }

        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
            setUpdatedAt(LocalDateTime.now());
        }

        public Categoria getCategoria() {
            return categoria;
        }

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
            setUpdatedAt(LocalDateTime.now());

        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updateAt) {
            this.updatedAt = updateAt;
        }

        public Edital getEdital() {
            return edital;
        }

        public void setEdital(Edital edital) {
            this.edital = edital;
        }
    //</editor-fold>

    @Override
    public String toString() {
        return "Publicacao{" 
                + "id=" + id + ", "
                + "titulo=" + titulo + ", "
                + "conteudo=" + conteudo + ", "
                + "categoria=" + categoria + ", "
                + "createdAt="  + createdAt + ", "
                + "updateAt=" + updatedAt + '}';
    }
}
