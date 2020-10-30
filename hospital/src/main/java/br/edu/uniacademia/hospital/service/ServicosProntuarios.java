/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.service;

import br.edu.uniacademia.hospital.dao.ProntuariosDAO;
import br.edu.uniacademia.hospital.model.Prontuarios;
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
@Path("servicosProntuarios")
@RequestScoped
public class ServicosProntuarios {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicosProntuariosResource
     */
    public ServicosProntuarios() {
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizar(Prontuarios pt) {
        ProntuariosDAO.getInstance().persistir(pt);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void gravar(Prontuarios pt) {
        ProntuariosDAO.getInstance().persistir(pt);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prontuarios> buscarTodos() {
        return ProntuariosDAO.getInstance().buscarTodas();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prontuarios buscar(Prontuarios pt) {
        return ProntuariosDAO.getInstance().buscar(pt.getDescricao());
    }

    @DELETE
    @Path("{id}")
    public void remover(Prontuarios pt) {
        ProntuariosDAO.getInstance().remover(pt);
    }
}
