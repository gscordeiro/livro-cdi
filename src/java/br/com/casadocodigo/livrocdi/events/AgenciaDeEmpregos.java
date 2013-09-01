/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.events;

import br.com.casadocodigo.livrocdi.folhapagamento.Funcionario;
import javax.enterprise.event.Observes;
import org.slf4j.Logger;

/**
 *
 * @author gilliard
 */
public class AgenciaDeEmpregos {
    
    public void ajudarFuncionarioDemitido(@Observes @Demissao Funcionario funcionario, Logger logger){
        logger.info("Ajudando {} a conseguir um novo emprego", funcionario);
    }
}
