/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import GestaoProcessos.Categoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yodem
 */
@Stateless
public class CategoriaSessionBean implements CategoriaSessionBeanLocal {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Categoria categoria) {
        entityManager.persist(categoria);
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return entityManager.find(Categoria.class, id);
    }

    @Override
    public void editar(Categoria categoria) {
        entityManager.refresh(categoria);
    }

    @Override
    public void deletar(Categoria categoria) {
        entityManager.remove(categoria);
    }
}
