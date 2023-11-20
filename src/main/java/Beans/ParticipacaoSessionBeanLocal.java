/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Beans;

import GestaoProcessos.Participacao;
import javax.ejb.Local;

/**
 *
 * @author yodem
 */
@Local
public interface ParticipacaoSessionBeanLocal {
    public void salvar(Participacao participacao);
    
    public Participacao buscarPorId(Long id);
    
    public void editar(Participacao participacao);
    
    public void deletar(Participacao participacao);
}
