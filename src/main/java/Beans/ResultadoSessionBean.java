/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import GestaoProcessos.Resultado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gabriel
 */
@Stateless
public class ResultadoSessionBean implements ResultadoSessionBeanLocal {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Resultado resultado) {
        entityManager.persist(resultado);
    }

    @Override
    public Resultado buscarPorId(Long id) {
        return entityManager.find(Resultado.class, id);
    }

    @Override
    public void editar(Resultado resultado) {
        entityManager.refresh(resultado);
    }

    @Override
    public void deletar(Resultado resultado) {
        entityManager.remove(resultado);
    }
}
