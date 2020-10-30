/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.service;

import br.edu.uniacademia.hospital.dao.FuncionariosDAO;
import br.edu.uniacademia.hospital.model.Funcionarios;
import java.util.List;
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
public class ServicosFuncionarios {
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicosTipoFuncionarioResource
     */
    public ServicosFuncionarios() {
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizar(Funcionarios f) {
        FuncionariosDAO.getInstance().persistir(f);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void gravar(Funcionarios f) {
        FuncionariosDAO.getInstance().persistir(f);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Funcionarios> buscarTodos() {
        return FuncionariosDAO.getInstance().buscarTodas();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionarios buscar(Funcionarios f) {
        return FuncionariosDAO.getInstance().buscar(f.getNomeFuncionario());
    }

    @DELETE
    @Path("{id}")
    public void remover(Funcionarios f) {
        FuncionariosDAO.getInstance().remover(f);
    }
}
