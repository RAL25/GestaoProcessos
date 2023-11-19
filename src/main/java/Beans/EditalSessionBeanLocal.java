/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Beans;

import GestaoProcessos.Edital;
import javax.ejb.Local;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Local
public interface EditalSessionBeanLocal {
    public void salvar(Edital edital);
    public Edital BuscarPorId(Long Id);
    public void editar(Edital edital);
    public void deletar(Edital edital);
}
