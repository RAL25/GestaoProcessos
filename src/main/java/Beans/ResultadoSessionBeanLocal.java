/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Beans;

import GestaoProcessos.Resultado;
import javax.ejb.Local;

/**
 *
 * @author gabriel
 */
@Local
public interface ResultadoSessionBeanLocal {
    
    public void salvar(Resultado resultado);
    
    public Resultado buscarPorId(Long id);
    
    public void editar(Resultado resultado);
    
    public void deletar(Resultado resultado);
}
