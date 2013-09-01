/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.events;

import br.com.casadocodigo.livrocdi.folhapagamento.Funcionario;
import java.lang.annotation.Annotation;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import static br.com.casadocodigo.livrocdi.events.TipoDesligamento.*;

/**
 *
 * @author gilliard
 */
@Model
public class GestorFuncionarioBean {
    
    private Funcionario funcionario;
    private TipoDesligamento tipoDesligamento;
    
    @Inject
    private Event<Funcionario> eventoFuncionario;
    
    @Inject
    private Event<Funcionario> eventoDesligamento;
    
    @PostConstruct
    public void init(){
        funcionario = new Funcionario();
    }

    
    public TipoDesligamento[] tiposDesligamento(){
        return TipoDesligamento.values();
    }
    
    public void cadastraFuncionario(){
        //salva funcionario no banco
        System.out.println("####>> cadastrar usuário...");
        eventoFuncionario.fire(funcionario);
        System.out.println("####>> usuário cadastrado!");
    }
    
    public void desligarFuncionario(){
        
        Annotation qualificador = null;
        if(tipoDesligamento == TipoDesligamento.APOSENTADORIA){
            //faz a lógica de aposentadoria
            qualificador = new DesligamentoQualifier(APOSENTADORIA){};
        }
        else if(tipoDesligamento == TipoDesligamento.DEMISSAO){
            qualificador = new DesligamentoQualifier(DEMISSAO){};
        }
       
        Event<Funcionario> eventoQualificado = eventoDesligamento.select(qualificador);
        
        
        System.out.println("####>> desligar usuário...");
        
        eventoQualificado.fire(funcionario);
        
        
        System.out.println("####>> usuário desligado!");
        
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public TipoDesligamento getTipoDesligamento() {
        return tipoDesligamento;
    }

    public void setTipoDesligamento(TipoDesligamento tipoDesligamento) {
        this.tipoDesligamento = tipoDesligamento;
    }
    
}
