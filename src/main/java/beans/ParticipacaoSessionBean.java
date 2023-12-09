/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import gestaoProcessos.Inscricao;
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
    public void salvar(Inscricao participacao) {
        entityManager.persist(participacao);
    }

    @Override
    public Inscricao buscarPorId(Long id) {
        return entityManager.find(Inscricao.class, id);
    }

    @Override
    public void editar(Inscricao participacao) {
        entityManager.refresh(participacao);
    }

    @Override
    public void deletar(Inscricao participacao) {
        entityManager.remove(participacao);
    }

}
