/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecosDAO;
import br.edu.uniacademia.hospital.dao.PacientesDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.model.Pacientes;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Raphaelli Bellini
 */
@Named
@ViewScoped
public class PacientesBean implements Serializable {
    Pacientes pacientes = new Pacientes();

    List pacientesList = new ArrayList();
    
    Long enderecoId;

    public PacientesBean() {
        pacientesList = new PacientesDAO().buscarTodas();
        pacientes = new Pacientes();
        enderecoId = null;
    }

    public void salvar(ActionEvent actionEvent) {
        Enderecos enderecos = new Enderecos();
        
        enderecos = new EnderecosDAO().findById(enderecoId);
        
        pacientes.setEndereco(enderecos);
        
        new PacientesDAO().persistir(pacientes);
        pacientesList = new PacientesDAO().buscarTodas();
    }

    public void remover(ActionEvent actionEvent) {
        new PacientesDAO().remover(pacientes);
        pacientesList = new PacientesDAO().buscarTodas();
        pacientes = new Pacientes();
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public List getAllPacientes() {
        return pacientesList;
    }

    public void setAllPacientes(List pacientesList) {
        this.pacientesList = pacientesList;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }
}
