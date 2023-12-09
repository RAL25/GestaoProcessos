/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import gestaoProcessos.Prova;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yodem
 */
@Stateless
public class ProvaService implements ProvaSessionServiceLocal {
    @PersistenceContext
    EntityManager em;

    @Override
    public void salvar(Prova prova) {
        em.persist(prova);
    }

    @Override
    public Prova buscarPorId(Long id) {
        return em.find(Prova.class, id);
    }

    @Override
    public void editar(Prova prova) {
        em.refresh(prova);
    }

    @Override
    public void deletar(Prova prova) {
        em.remove(prova);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
