/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import GestaoProcessos.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Stateless
public class UsuarioBean implements UsuarioBeanLocal {
    @PersistenceContext
    EntityManager entityManager;
    
    //<-------------Persistência para salvar dados------------->//
    @Override
    public void salvar(Usuario usuario) {
        entityManager.persist(usuario);
    }
    
}
