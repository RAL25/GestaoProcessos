/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package Beans;

import GestaoProcessos.Prova;
import GestaoProcessos.Edital;
import GestaoProcessos.Inscricao;
import GestaoProcessos.ProcessoSeletivo;
import GestaoProcessos.Arquivo;
import GestaoProcessos.Publicacao;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    
    @Inject
    private ProvaSessionBeanLocal provaBean;
    
    @Inject
    private EditalSessionBeanLocal editalBean;
    
    @Inject
    private ParticipacaoSessionBeanLocal participacaoBean;
    
    @Inject
    private ProcessoSeletivoSessionBeanLocal processoBean;
    
    @Inject
    private PublicacaoSessionBeanLocal publicacaoBean;
    
    @Inject
    private ArquivoSessionBeanLocal arquivoBean;
    
    @PostConstruct
    public void PopularAdm(){
        
        ProcessoSeletivo processo = new ProcessoSeletivo();
        
        
        Prova provaDia1 = new Prova();
        provaDia1.setCor("azul");
        provaDia1.setData(LocalDate.of(2023, 11, 5));
        provaDia1.setDia((short)1);
        Prova provaDia2 = new Prova();
        provaDia2.setCor("amarelo");
        provaDia2.setData(LocalDate.of(2023, 11, 12));
        provaDia2.setDia((short)2);
        
        Edital edital = new Edital();
        edital.setData(LocalDate.of(2023, 8, 23));
        edital.setDescricao("O PRESIDENTE DO INSTITUTO NACIONAL DE ESTUDOS E PESQUISAS EDUCACIONAIS ANÍSIO TEIXEIRA -INEP, no uso das suas atribuições, em cumprimento aos dispositivos da Chamada Pública nº 43, de 19 de Junho de 2023, torna pública a relação, em ordem alfabética dos interessados confirmados/não confirmados e dos convocados para o curso de capacitação na modalidade a distância que atenderam integralmente aos requisitos estabelecidos no item 3 do Edital de Chamada Pública, disponível no endereço eletrônico: http://certificadores.inep.gov.br/");
        edital.setNumero(59);
        
        Inscricao participacao = new Inscricao();
        participacao.setProcessoSeletivo(processo);
        
        processo.setAberto(Boolean.TRUE);
        processo.getCandidatos().add(participacao);
        processo.setDescricao("descricao");
        processo.setEdital(edital);
        
        Publicacao publicacao = new Publicacao();
        publicacao.setConteudo("O PRESIDENTE DO INSTITUTO NACIONAL DE ESTUDOS E PESQUISAS EDUCACIONAIS ANÍSIO TEIXEIRA -INEP, no uso das suas atribuições, em cumprimento aos dispositivos da Chamada Pública nº 43, de 19 de Junho de 2023, torna pública a relação, em ordem alfabética dos interessados confirmados/não confirmados e dos convocados para o curso de capacitação na modalidade a distância que atenderam integralmente aos requisitos estabelecidos no item 3 do Edital de Chamada Pública, disponível no endereço eletrônico: http://certificadores.inep.gov.br/");
        publicacao.setCreatedAt(LocalDateTime.now());
        publicacao.setEdital(edital);
        publicacao.setProva(provaDia1);
        publicacao.setTitulo("Edital para prova do dia 1");
        publicacao.setUpdatedAt(LocalDateTime.now());
        
        Arquivo arquivo = new Arquivo();
        arquivo.setNome("Edital numero 59");
        
        provaBean.salvar(provaDia1);
        
        editalBean.salvar(edital);
        
        participacaoBean.salvar(participacao);
        
        processoBean.salvar(processo);
        
        publicacaoBean.salvar(publicacao);
        
        arquivoBean.salvar(arquivo);
    }
}
