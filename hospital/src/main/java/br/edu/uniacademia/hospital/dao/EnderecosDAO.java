/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Raphaelli Bellini
 */
public class EnderecosDAO {
    public static EnderecosDAO enderecosDAO;

    public static EnderecosDAO getInstance() {
        if (enderecosDAO == null) {
            enderecosDAO = new EnderecosDAO();
        }
        return enderecosDAO;
    }

    public Enderecos buscar(String localidade) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Enderecos a where a.localidadeEnderecos =:localidade ");
        query.setParameter("localidade", localidade);

        List<Enderecos> categoria = query.getResultList();
        if (categoria != null && categoria.size() > 0) {
            return categoria.get(0);
        }

        return null;
    }
    
    public Enderecos findById(Long id) {

        EntityManager em = PersistenceUtil.getEntityManager();
        
        Query query = em.createQuery("SELECT e FROM Enderecos e WHERE e.idEndereco = :idEndereco");
        query.setParameter("idEndereco", id);

        List<Enderecos> listEnderecos = query.getResultList();

        listEnderecos = query.getResultList();

        return listEnderecos.get(0);

    }

    public List<Enderecos> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Enderecos As a");
        return query.getResultList();
    }

    public void remover(Enderecos enderecos) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(enderecos)) {
            enderecos = em.merge(enderecos);
        }
        em.remove(enderecos);
        em.getTransaction().commit();
    }

    public Enderecos persistir(Enderecos enderecos) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            enderecos = em.merge(enderecos);
            em.getTransaction().commit();
            System.out.println("Endereco gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enderecos;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from Enderecos ");
        query.executeUpdate();
        em.getTransaction().commit();
    }
}
