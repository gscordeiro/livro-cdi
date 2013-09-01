/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.jsf;

import java.util.Map;
import javax.enterprise.inject.Produces;
import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author gilliard
 */
public class ProdutorFaces {
    
    @Produces
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @Produces
    private ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    
    @Produces
    private Application application = FacesContext.getCurrentInstance().getApplication();
    
    @Produces @ApplicationMap
    public Map<String, Object> disponibilizaApplicationMap(ExternalContext externalContext){
        return externalContext.getApplicationMap();
    }
    
    @Produces @SessionMap
    public Map<String, Object> disponibilizaSessionMap(ExternalContext externalContext){
        return externalContext.getSessionMap();
    }
    
    @Produces @RequestMap
    public Map<String, Object> disponibilizaRequestMap(ExternalContext externalContext){
        return externalContext.getRequestMap();
    }
    
    @Produces @RequestParameterMap
    public Map<String, String> disponibilizaRequestParameterMap(ExternalContext externalContext){
        return externalContext.getRequestParameterMap();
    }
}
