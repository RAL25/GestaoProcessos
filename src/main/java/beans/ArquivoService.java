/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import gestaoProcessos.Arquivo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gabriel
 */
@Stateless
public class ArquivoService implements ArquivoServiceLocal {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Arquivo arquivo) {
        entityManager.persist(arquivo);
    }

    @Override
    public Arquivo buscarPorId(Long id) {
        return entityManager.find(Arquivo.class, id);
    }

    @Override
    public void editar(Arquivo arquivo) {
        entityManager.refresh(arquivo);
    }

    @Override
    public void deletar(Arquivo arquivo) {
        entityManager.remove(arquivo);
    }
}
