package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecosDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.uniacademia.hospital.dao.FuncionariosDAO;
import br.edu.uniacademia.hospital.dao.TipoFuncionarioDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.model.TipoFuncionario;

@Named
@ViewScoped
public class FuncionariosBean implements Serializable {
    Funcionarios funcionarios = new Funcionarios();

    List funcionariosList = new ArrayList();
    
    Long enderecoId;
    
    Long tipoFuncionarioId;

    public FuncionariosBean() {
        funcionariosList = new FuncionariosDAO().buscarTodas();
        funcionarios = new Funcionarios();
        enderecoId = null;
        tipoFuncionarioId = null;
    }

    public void salvar(ActionEvent actionEvent) {
        Enderecos enderecos = new Enderecos();
        TipoFuncionario tipoFuncionario = new TipoFuncionario();
        
        enderecos = new EnderecosDAO().findById(enderecoId);
        tipoFuncionario = new TipoFuncionarioDAO().findById(tipoFuncionarioId);
        
        funcionarios.setEnderecosidEnderecos(enderecos);
        funcionarios.setTipoFuncionarioidtipoFuncionario(tipoFuncionario);
        
        new FuncionariosDAO().persistir(funcionarios);
        funcionariosList = new FuncionariosDAO().buscarTodas();
    }

    public void remover(ActionEvent actionEvent) {
        new FuncionariosDAO().remover(funcionarios);
        funcionariosList = new FuncionariosDAO().buscarTodas();
        funcionarios = new Funcionarios();
    }

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List getAllFuncionarios() {
        return funcionariosList;
    }

    public void setAllFuncionarios(List funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Long getTipoFuncionarioId() {
        return tipoFuncionarioId;
    }

    public void setTipoFuncionarioId(Long tipoFuncionarioId) {
        this.tipoFuncionarioId = tipoFuncionarioId;
    }
}
