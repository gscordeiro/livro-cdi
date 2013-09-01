/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.events;

import static br.com.casadocodigo.livrocdi.events.TipoDesligamento.APOSENTADORIA;
import javax.enterprise.util.AnnotationLiteral;

/**
 *
 * @author gilliard
 */
public abstract class DesligamentoQualifier extends AnnotationLiteral<Desligamento> implements Desligamento {

    private TipoDesligamento tipoDesligamento;

    public DesligamentoQualifier(TipoDesligamento tipoDesligamento){
        this.tipoDesligamento = tipoDesligamento;
    }
    
    
    public TipoDesligamento value() {
        return tipoDesligamento;
    }
}
