/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.FuncionariosDAO;
import br.edu.uniacademia.hospital.dao.PacientesDAO;
import br.edu.uniacademia.hospital.dao.ProntuariosDAO;
import br.edu.uniacademia.hospital.model.Prontuarios;
import java.io.Serializable;
import java.util.ArrayList;
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
public class ProntuariosBean implements Serializable{
    
    Prontuarios prontuarios = new Prontuarios();
    List prontuariosList = new ArrayList();
    
    Long pacienteId;
    
    Long funcionarioId;
    
    String descricao;
    
    public ProntuariosBean() {
        prontuariosList = new ProntuariosDAO().buscarTodas();
        prontuarios = new Prontuarios();
        pacienteId = null;
        funcionarioId = null;
        descricao = "";
    }
    
    public void salvar(ActionEvent actionEvent) {
        prontuarios.setPacientesidPaciente(new PacientesDAO().findById(pacienteId));
        prontuarios.setFuncionariosidFuncionario(new FuncionariosDAO().findById(funcionarioId));
        
        new ProntuariosDAO().persistir(prontuarios);
        
        descricao = prontuarios.getDescricao();
        
        prontuariosList = new ProntuariosDAO().buscarTodas();
        prontuarios = new ProntuariosDAO().buscar(descricao);
    }
    
    public void remover(ActionEvent actionEvent) {
        new ProntuariosDAO().remover(prontuarios);
        
        prontuariosList = new ProntuariosDAO().buscarTodas();
        prontuarios = new Prontuarios();
    }

    public Prontuarios getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(Prontuarios prontuarios) {
        this.prontuarios = prontuarios;
    }

    public List getAllProntuarios() {
        return prontuariosList;
    }

    public void setProntuariosList(List prontuariosList) {
        this.prontuariosList = prontuariosList;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
