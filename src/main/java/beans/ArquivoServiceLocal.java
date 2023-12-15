/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import gestaoProcessos.Arquivo;
import gestaoProcessos.TipoArquivo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabriel
 */
@Local
public interface ArquivoServiceLocal {

    public void salvar(Arquivo arquivo);

    public List<Arquivo> buscarTodos();

    public void deletarPorPath(String path);

    public List<Arquivo> buscarArquivosPorTipo(TipoArquivo tipo);

    public Arquivo buscarPorPath(String path);

    public Arquivo buscarPorId(Long id);

    public void editar(Arquivo arquivo);

    public void deletar(Arquivo arquivo);

}
