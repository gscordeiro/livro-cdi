/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.events;

import br.com.casadocodigo.livrocdi.folhapagamento.Funcionario;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.EventMetadata;
import org.slf4j.Logger;

/**
 *
 * @author gilliard
 */
public class EscutadorDeEventosFake {
    
    
    public void observaFuncionario(Funcionario funcionario){
        System.out.printf("FAKE!!!!!  >>> Escutando funcionario: %s\n", funcionario);
    }
    
    
    public void observaFuncionario(Funcionario funcionario, Logger logger, EventMetadata metadata){
        logger.info("FAKE!!!!!  >>> Escutando funcionario: {}", funcionario);
        logger.info("FAKE!!!!!  >>> Evento com qualificadores: {}", metadata.getQualifiers());
    }
}
