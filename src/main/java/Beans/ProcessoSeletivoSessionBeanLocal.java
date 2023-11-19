/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Beans;

import GestaoProcessos.ProcessoSeletivo;
import javax.ejb.Local;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Local
public interface ProcessoSeletivoSessionBeanLocal {
    public void salvar(ProcessoSeletivo processo);
    public ProcessoSeletivo BuscarPorId(Long Id);
    public void editar(ProcessoSeletivo processo);
    public void deletar(ProcessoSeletivo processo);
}
