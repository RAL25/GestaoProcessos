/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import gestaoProcessos.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Local
public interface UsuarioServiceLocal {
    
    //<-------------Persistência para salvar dados------------->//
    public void salvar(Usuario usuario);
    
    public Usuario buscarPorId(Long id);
    
    public void editar(Usuario usuario);
    
    public void deletar(Usuario usuario);
    
    public Usuario buscarPorEmail(String email);

    List<Usuario> buscarTodos();
}
