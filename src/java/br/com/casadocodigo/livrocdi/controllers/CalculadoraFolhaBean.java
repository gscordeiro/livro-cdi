/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.controllers;

import br.com.casadocodigo.livrocdi.folhapagamento.CalculadoraFolhaPagamento;
import br.com.casadocodigo.livrocdi.folhapagamento.Folha;
import br.com.casadocodigo.livrocdi.folhapagamento.Funcionario;
import br.com.casadocodigo.livrocdi.folhapagamento.FuncionarioBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gilliard
 */
@Named @ConversationScoped
public class CalculadoraFolhaBean implements Serializable{
    
    private Folha folha;
    private FuncionarioBuilder builder;
    private List<Funcionario> funcionarios;
    private double salarioFuncionario;
    
    @Inject
    private Conversation conversation;
    
    @Inject
    private CalculadoraFolhaPagamento calculadoraFolha;
    
    @PostConstruct
    public void init(){
        builder = new FuncionarioBuilder();
        funcionarios = new ArrayList<>();
    }
    
    public void iniciaConversacao(){
        if(conversation.isTransient()){
            conversation.begin();
        }
    }
    
    public void terminaConversacao(){
        if(!conversation.isTransient()){
            conversation.end();
        }
    }
    
    public void adicionaFuncionario(){
        Funcionario funcionario = builder
                .comSalarioBaseDe(salarioFuncionario).build();
        getFuncionarios().add(funcionario);
    }
    
    public void calcularFolha(){
        folha = calculadoraFolha.calculaFolha(getFuncionarios());
    }

    public double getSalarioFuncionario() {
        return salarioFuncionario;
    }

    public void setSalarioFuncionario(double salarioFuncionario) {
        this.salarioFuncionario = salarioFuncionario;
    }

    public Folha getFolha() {
        return folha;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
