    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import GestaoProcessos.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

    @Override
    public Usuario buscarPorId(Long id) {
        return entityManager.find(Usuario.class, id);
    }
    
    @Override
    public Usuario buscarPorEmail(String email) {
        return entityManager.createQuery("SELECT usuario FROM Usuario usuario WHERE usuario.email = :email", Usuario.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public void editar(Usuario usuario) {
        entityManager.refresh(usuario);
    }

    @Override
    public void deletar(Usuario usuario) {
        entityManager.remove(usuario);
    }
    
}
