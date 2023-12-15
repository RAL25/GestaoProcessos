/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import gestaoProcessos.Prova;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author yodem
 */
@Local
public interface ProvaSessionServiceLocal {
    
    public void salvar(Prova prova);
    
    public Prova buscarPorId(Long id);
    
    public List<Prova> buscarTodas();
    
    public void editar(Prova prova);
    
    public void deletar(Prova prova);
    
}
