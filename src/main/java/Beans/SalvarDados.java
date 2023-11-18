/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package Beans;

import GestaoProcessos.Usuario;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Singleton
public class SalvarDados {

    @PersistenceContext
    EntityManager entityManager;
    //<-------------Persistência para salvar dados------------->//
//    @Override
    public void salvar(Usuario usuario) {
        entityManager.persist(usuario);
    }
    
}
