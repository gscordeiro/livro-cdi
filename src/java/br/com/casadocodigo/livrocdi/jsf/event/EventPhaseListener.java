/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.jsf.event;

import java.lang.annotation.Annotation;
import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import static javax.faces.event.PhaseId.*;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author gilliard
 */
public class EventPhaseListener implements PhaseListener {

    @Inject
    private Logger logger;
    
    @Inject
    private Event<PhaseEvent> event;
    
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    public void disparaEvento(PhaseEvent phaseEvent, Annotation qualificadorAntesOuDepois){
        
        Annotation qualificadorFase = null;
        
        if(RESTORE_VIEW.equals(phaseEvent.getPhaseId())){
            qualificadorFase = new AnnotationLiteral<RestoreView>(){};
        }
        else if(APPLY_REQUEST_VALUES.equals(phaseEvent.getPhaseId())){
            qualificadorFase = new AnnotationLiteral<ApplyRequestValues>(){};
        }
        else if(PROCESS_VALIDATIONS.equals(phaseEvent.getPhaseId())){
            qualificadorFase = new AnnotationLiteral<ProcessValidations>(){};
        }
        else if(UPDATE_MODEL_VALUES.equals(phaseEvent.getPhaseId())){
            qualificadorFase = new AnnotationLiteral<UpdateModelValues>(){};
        }
        else if(INVOKE_APPLICATION.equals(phaseEvent.getPhaseId())){
            qualificadorFase = new AnnotationLiteral<InvokeApplication>(){};
        }
        else if(RENDER_RESPONSE.equals(phaseEvent.getPhaseId())){
            qualificadorFase = new AnnotationLiteral<RenderResponse>(){};
        }
        
        event.select(qualificadorAntesOuDepois).select(qualificadorFase).fire(phaseEvent);
        
    }
    
    
    @Override
    public void afterPhase(PhaseEvent event) {

        logger.debug("afterPhase: {}", event);
        disparaEvento(event, new AnnotationLiteral<After>(){});
    }

    @Override
    public void beforePhase(PhaseEvent event) {

        logger.debug("beforePhase: {}", event);
        disparaEvento(event, new AnnotationLiteral<Before>(){});
    }

    
}
