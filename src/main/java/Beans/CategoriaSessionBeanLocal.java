/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Beans;

import GestaoProcessos.Categoria;
import javax.ejb.Local;

/**
 *
 * @author yodem
 */
@Local
public interface CategoriaSessionBeanLocal {
    public void salvar(Categoria categoria);
    
    public Categoria buscarPorId(Long id);
    
    public void editar(Categoria categoria);
    
    public void deletar(Categoria categoria);
}
