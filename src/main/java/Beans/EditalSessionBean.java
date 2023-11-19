/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import GestaoProcessos.Edital;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Stateless
public class EditalSessionBean implements EditalSessionBeanLocal {

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public void salvar(Edital edital) {
        entityManager.persist(edital);
    }

    @Override
    public Edital BuscarPorId(Long Id) {
        return entityManager.find(Edital.class, Id);
    }

    @Override
    public void editar(Edital edital) {
        entityManager.refresh(edital);
    }

    @Override
    public void deletar(Edital edital) {
        entityManager.remove(edital);
    }

    
}
