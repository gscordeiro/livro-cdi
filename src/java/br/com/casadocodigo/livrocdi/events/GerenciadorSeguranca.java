/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.events;

import br.com.casadocodigo.livrocdi.folhapagamento.CalculadoraDeSalarios;
import br.com.casadocodigo.livrocdi.folhapagamento.Funcionario;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.EventMetadata;
import org.slf4j.Logger;
/**
 *
 * @author gilliard
 */
@Stateless
public class GerenciadorSeguranca {
    
    @Assincrono
    public void observaFuncionario(@Observes Funcionario funcionario, Logger logger, CalculadoraDeSalarios calc, EventMetadata metadata) throws Exception{
        logger.info("--> Escutando funcionario: {}", funcionario);
        //logger.info("Evento com qualificadores: {}", metadata.getQualifiers());
        
        logger.info("--> " + calc);
        logger.info("--> " + metadata);
        
        logger.info(">> espera um pouco...");
        Thread.sleep(3000);
        logger.info(">> agora terminou ;)");
        
    }
    
    /*
    public void observaAposentadoriaFuncionario(@Observes @Aposentadoria Funcionario funcionario, Logger logger){
        logger.info("Escutando aposentadoria do funcionario: {}", funcionario);
    }
    
     public void observaDemissaoFuncionario(@Observes @Demissao Funcionario funcionario, Logger logger){
        logger.info("Escutando demissao do funcionario: {}", funcionario);
    }
     */
      public void observaAposentadoriaFuncionario2(@Observes @Desligamento(TipoDesligamento.APOSENTADORIA) Funcionario funcionario, Logger logger){
        logger.info("Escutando aposentadoria do funcionario2: {}", funcionario);
    }
    
      /*
     @Asynchronous
     public void observaDemissaoFuncionario2(@Observes @Desligamento(TipoDesligamento.DEMISSAO) Funcionario funcionario, Logger logger) throws Exception{
        logger.info("Escutando demissao do funcionario2: {}", funcionario);
        logger.info("espera um pouco (3s)...");
        Thread.sleep(3000);
        logger.info("agora terminou os 3s ;)");
    }
     */
     
   
}
