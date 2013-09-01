/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.jsf.event;

import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author gilliard
 */
public class EventPhaseListenerNaoInjetavel implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {

        BeanManager beanManager = new CdiUtils().getBeanManager();
        
        beanManager.fireEvent(event, new AnnotationLiteral<After>(){}, new AnnotationLiteral<RestoreView>(){});
    }

    @Override
    public void beforePhase(PhaseEvent event) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
