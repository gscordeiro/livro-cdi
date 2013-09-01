/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.events;

import br.com.casadocodigo.livrocdi.folhapagamento.Funcionario;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import org.slf4j.Logger;

/**
 *
 * @author gilliard
 */
@Stateless
public class ObservadorDeFuncionarios {
    
    @Inject
    private JMSContext jmsContext;
    
    @Resource(mappedName = "jms/demissaoTopic")
    private Topic topicoDemissao;
    
    @Asynchronous
     public void notificaAgenciaDeEmprego(@Observes @Desligamento(TipoDesligamento.DEMISSAO) Funcionario funcionario, Logger logger) throws Exception{
        logger.info("Enviando demissão do funcionario {} para agencia de empregos", funcionario);
        jmsContext.createProducer().send(topicoDemissao, funcionario);
    }
    
}
