/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import gestaoProcessos.Prova;
import javax.ejb.Local;

/**
 *
 * @author yodem
 */
@Local
public interface ProvaSessionBeanLocal {
    
    public void salvar(Prova prova);
    
    public Prova buscarPorId(Long id);
    
    public void editar(Prova prova);
    
    public void deletar(Prova prova);
    
}
