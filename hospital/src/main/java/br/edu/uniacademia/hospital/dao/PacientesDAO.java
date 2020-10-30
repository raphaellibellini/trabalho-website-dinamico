/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Pacientes;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Raphaelli Bellini
 */
public class PacientesDAO {
    public static PacientesDAO pacientesDAO;

    public static PacientesDAO getInstance() {
        if (pacientesDAO == null) {
            pacientesDAO = new PacientesDAO();
        }
        return pacientesDAO;
    }

    public Pacientes buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Pacientes a where a.nomePacientes =:nome ");
        query.setParameter("nome", nome);

        List<Pacientes> categoria = query.getResultList();
        if (categoria != null && categoria.size() > 0) {
            return categoria.get(0);
        }

        return null;
    }
    
    public Pacientes findById(Long id){
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Pacientes a where a.idPaciente =:id ");
        query.setParameter("id", id);

        List<Pacientes> listPacientes = query.getResultList();
        if (listPacientes != null && listPacientes.size() > 0) {
            return listPacientes.get(0);
        }

        return null;
    }

    public List<Pacientes> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Pacientes As a");
        return query.getResultList();
    }

    public void remover(Pacientes pacientes) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(pacientes)) {
            pacientes = em.merge(pacientes);
        }
        em.remove(pacientes);
        em.getTransaction().commit();
    }

    public Pacientes persistir(Pacientes pacientes) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            pacientes = em.merge(pacientes);
            em.getTransaction().commit();
            System.out.println("Paciente gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from Pacientes ");
        query.executeUpdate();
        em.getTransaction().commit();
    }
}
