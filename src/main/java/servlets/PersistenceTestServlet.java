/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import gestaoProcessos.Arquivo;
import gestaoProcessos.Categoria;
import gestaoProcessos.Edital;
import gestaoProcessos.ProcessoSeletivo;
import gestaoProcessos.Prova;
import gestaoProcessos.Publicacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import beans.UsuarioServiceLocal;
import beans.EditalServiceLocal;
import beans.ParticipacaoServiceLocal;
import beans.ProcessoSeletivoServiceLocal;
import beans.ProvaSessionServiceLocal;
import beans.PublicacaoServiceLocal;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@WebServlet(name = "PersistenceTest", urlPatterns = {"/PersistenceTest"})
@Transactional
public class PersistenceTestServlet extends HttpServlet {
    @Inject
    ProvaSessionServiceLocal provabean;
    @Inject
    EditalServiceLocal editalbean;
    @Inject
    PublicacaoServiceLocal publicacaobean;
    @Inject
    ProcessoSeletivoServiceLocal processoSeletivobean;
    @Inject
    UsuarioServiceLocal usuariobean;
    @Inject
    ParticipacaoServiceLocal participacaobean;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//        // Prova
//            // Criação
//            ArquivoP arquivoProva = new ArquivoProva("Prova-1","caminhoParaArquivoProva");
//            ArquivoGabarito arquivoGabarito= new ArquivoGabarito("Gabarito-Prova-1","caminhoParaArquivoGabarito-Prova");
//            Prova prova = new Prova(LocalDate.of(2023, Month.MARCH, 2),arquivoProva, arquivoGabarito, (short)1,"azul");        
//            provabean.salvar(prova);
//            
//            // Busca
//            Prova provaBuscada = provabean.buscarPorId(prova.getId());
//        
//        // Edital
//            // Criação
//            ArquivoEdital arquivoEdital = new ArquivoEdital("Edital-1", "CaminhoParaArquivoDoEdital");
//            Edital edital = new Edital(LocalDate.of(2023, Month.MARCH, 25),1,arquivoEdital,"edital refente ao enem 2023");
//            editalbean.salvar(edital);
//            
            // Busca
//            Edital editalBuscado = editalbean.BuscarPorId(edital.getId());
            
        // Publicacao
//            // Criação 
//            Publicacao publicacao = new Publicacao("Edital Enem 2023", "Atenção ao edital para o enem...", Categoria.EDITAL, edital );
//            publicacaobean.salvar(publicacao);
//            
//            // Busca
//            Publicacao publicacaoBuscada = publicacaobean.buscarPorId(publicacao.getId());
//        
//        // Processo Seletivo
//            // Criacao 
//            ProcessoSeletivo processoSeletivo = new ProcessoSeletivo("ProcessoSeletivo-1", "Descrição do processo", Boolean.TRUE, edital, prova);
//            
//            processoSeletivobean.salvar(processoSeletivo);
//            
//            // Busca
//            ProcessoSeletivo processoSeletivoBuscado = processoSeletivobean.BuscarPorId(processoSeletivo.getId());
            

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testDados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Prova Buscada:</h1>");           
//            out.println("<p>"+ provaBuscada.toString() +"</p>");            
            out.println("<h1>Edital Buscado:</h1>");
//            out.println("<p>"+ editalBuscado.toString() +"</p>");
            out.println("<h1>Publicacao Buscada:</h1>");
//            out.println("<p>"+ publicacaoBuscada.toString() +"</p>");
            out.println("<h1>Processo Seletivo Buscado:</h1>");
//            out.println("<p>"+ processoSeletivoBuscado.toString() +"</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
