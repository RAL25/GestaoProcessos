    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import GestaoProcessos.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Stateless
public class UsuarioService implements UsuarioServiceLocal {
    
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
        List<Usuario> usuarios = entityManager.createQuery("SELECT usuario FROM Usuario usuario WHERE usuario.email = :email", Usuario.class)
                .setParameter("email", email)
                .getResultList();
        
        if(usuarios.isEmpty()) {
             return null;
        } else {
            return usuarios.get(0);
        }
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
