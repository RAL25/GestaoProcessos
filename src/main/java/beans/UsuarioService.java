/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import gestaoProcessos.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Stateless
public class UsuarioService implements UsuarioServiceLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    Pbkdf2PasswordHash passwordHasher;

    //<-------------Persistência para salvar dados------------->//
    @Override
    public void salvar(Usuario usuario) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3071");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        
        passwordHasher.initialize(parameters);
        
        usuario.setSenha(passwordHasher.generate(usuario.getSenha().toCharArray()));
        
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

        if (usuarios.isEmpty()) {
            return null;
        } else {
            return usuarios.get(0);
        }
    }

    @Override
    public void editar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void deletar(Usuario usuario) {
        entityManager.remove(usuario);
    }

}
