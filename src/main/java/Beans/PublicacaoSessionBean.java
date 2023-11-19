/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import GestaoProcessos.Publicacao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gabriel
 */
@Stateless
public class PublicacaoSessionBean implements PublicacaoSessionBeanLocal {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Publicacao publicacao) {
        entityManager.persist(publicacao);
    }

    @Override
    public Publicacao buscarPorId(Long id) {
        return entityManager.find(Publicacao.class, id);
    }

    @Override
    public void editar(Publicacao publicacao) {
        entityManager.refresh(publicacao);
    }

    @Override
    public void deletar(Publicacao publicacao) {
        entityManager.remove(publicacao);
    }
}
