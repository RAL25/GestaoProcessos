/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import GestaoProcessos.Participacao;
import GestaoProcessos.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yodem
 */
@Stateless
public class ParticipacaoSessionBean implements ParticipacaoSessionBeanLocal {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Participacao participacao) {
        entityManager.persist(participacao);
    }

    @Override
    public Participacao buscarPorId(Long id) {
        return entityManager.find(Participacao.class, id);
    }

    @Override
    public void editar(Participacao participacao) {
        entityManager.refresh(participacao);
    }

    @Override
    public void deletar(Participacao participacao) {
        entityManager.remove(participacao);
    }

}
