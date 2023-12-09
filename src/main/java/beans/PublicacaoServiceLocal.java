/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import gestaoProcessos.Publicacao;
import javax.ejb.Local;

/**
 *
 * @author gabriel
 */
@Local
public interface PublicacaoServiceLocal {
    
    public void salvar(Publicacao publicacao);
    
    public Publicacao buscarPorId(Long id);
    
    public void editar(Publicacao publicacao);
    
    public void deletar(Publicacao publicacao);
    
}
