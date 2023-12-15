/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import gestaoProcessos.Arquivo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gabriel
 */
@Stateless
public class ArquivoService implements ArquivoServiceLocal {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Arquivo arquivo) {
        entityManager.persist(arquivo);
    }

    @Override
    public Arquivo buscarPorId(Long id) {
        return entityManager.find(Arquivo.class, id);
    }

    @Override
    public void editar(Arquivo arquivo) {
        entityManager.merge(arquivo);
    }

    @Override
    public void deletar(Arquivo arquivo) {
        entityManager.remove(arquivo);
    }

    @Override
    public List<Arquivo> buscarTodos() {
        return entityManager.createQuery("SELECT arquivo FROM Arquivo arquivo", Arquivo.class).getResultList();
    }

    @Override
    public void deletarPorPath(String path) {
        Arquivo arquivo = this.buscarPorPath(path);
        this.deletar(arquivo);
    }

    @Override
    public Arquivo buscarPorPath(String path) {
         List<Arquivo> arquivos = entityManager.createQuery("SELECT arquivo FROM Arquivo arquivo WHERE arquivo.path = :path", Arquivo.class)
                .setParameter("path", path)
                .getResultList();

        if (arquivos.isEmpty()) {
            return null;
        } else {
            return arquivos.get(0);
        }
    }
}
