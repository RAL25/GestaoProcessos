/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import gestaoProcessos.Publicacao;
import java.time.LocalDateTime;
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
}
