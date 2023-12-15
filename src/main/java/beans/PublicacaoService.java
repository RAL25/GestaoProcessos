/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import gestaoProcessos.Categoria;
import gestaoProcessos.Publicacao;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gabriel
 */
@Stateless
public class PublicacaoService implements PublicacaoServiceLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Publicacao publicacao) {
        publicacao.setCreatedAt(LocalDateTime.now());
        publicacao.setUpdatedAt(LocalDateTime.now());
        entityManager.persist(publicacao);
    }

    @Override
    public Publicacao buscarPorId(Long id) {
        return entityManager.find(Publicacao.class, id);
    }

    @Override
    public void editar(Publicacao publicacao) {
        publicacao.setUpdatedAt(LocalDateTime.now());
        entityManager.refresh(publicacao);
    }

    @Override
    public void deletar(Publicacao publicacao) {
        entityManager.remove(publicacao);
    }

    @Override
    public List<Publicacao> buscarTodos() {
        return entityManager.createQuery("SELECT publicacao FROM Publicacao publicacao", Publicacao.class).getResultList();
    }

    @Override
    public List<Publicacao> buscarTodosTipado(Categoria tipo) {
        List<Publicacao> publicacoes = entityManager.createQuery(
                "SELECT publicacao FROM Publicacao publicacao WHERE publicacao.categoria = :tipo", Publicacao.class)
                .setParameter("tipo", tipo)
                .getResultList();
        
        return publicacoes;

    }

}
