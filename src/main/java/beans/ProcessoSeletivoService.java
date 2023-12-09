/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import gestaoProcessos.ProcessoSeletivo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Stateless
public class ProcessoSeletivoService implements ProcessoSeletivoServiceLocal {

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public void salvar(ProcessoSeletivo processo) {
        entityManager.persist(processo);
    }

    @Override
    public ProcessoSeletivo BuscarPorId(Long Id) {
        return entityManager.find(ProcessoSeletivo.class, Id);
    }

    @Override
    public void editar(ProcessoSeletivo processo) {
        entityManager.refresh(processo);
    }

    @Override
    public void deletar(ProcessoSeletivo processo) {
        entityManager.remove(processo);
    }

    
}
