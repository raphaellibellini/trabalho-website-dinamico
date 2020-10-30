/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.service;

import br.edu.uniacademia.hospital.dao.PacientesDAO;
import br.edu.uniacademia.hospital.model.Pacientes;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Raphaelli Bellini
 */
@Path("servicosPacientes")
@RequestScoped
public class ServicosPacientes {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicosPacientesResource
     */
    public ServicosPacientes() {
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizar(Pacientes pc) {
        PacientesDAO.getInstance().persistir(pc);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void gravar(Pacientes pc) {
        PacientesDAO.getInstance().persistir(pc);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pacientes> buscarTodos() {
        return PacientesDAO.getInstance().buscarTodas();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pacientes buscar(Pacientes pc) {
        return PacientesDAO.getInstance().buscar(pc.getNomePaciente());
    }

    @DELETE
    @Path("{id}")
    public void remover(Pacientes pc) {
        PacientesDAO.getInstance().remover(pc);
    }
}

