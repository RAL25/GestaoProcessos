/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import gestaoProcessos.Inscricao;
import javax.ejb.Local;

/**
 *
 * @author yodem
 */
@Local
public interface ParticipacaoSessionBeanLocal {
    public void salvar(Inscricao participacao);
    
    public Inscricao buscarPorId(Long id);
    
    public void editar(Inscricao participacao);
    
    public void deletar(Inscricao participacao);
}
