/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import gestaoProcessos.Arquivo;
import javax.ejb.Local;

/**
 *
 * @author gabriel
 */
@Local
public interface ArquivoSessionBeanLocal {
    
    public void salvar(Arquivo arquivo);
    
    public Arquivo buscarPorId(Long id);
    
    public void editar(Arquivo arquivo);
    
    public void deletar(Arquivo arquivo);
    
}
