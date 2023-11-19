/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package Beans;

import GestaoProcessos.Administrador;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Singleton
@Startup
public class CargaDadosSessionBean {

    @Inject
    private UsuarioBeanLocal usuarioBean;
    
    @PostConstruct
    public void PopularAdm(){
        Administrador adm = new Administrador();
        adm.setNome("Rian Alvesl Leal");
        adm.setCpf("11111111111");
        adm.setEmail("rian@mail.com");
        adm.setSenha("abcd12345");
        
        usuarioBean.salvar(adm);
    }
}
