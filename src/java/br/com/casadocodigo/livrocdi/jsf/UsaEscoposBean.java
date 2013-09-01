/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.jsf;

import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gilliard
 */
@Named
@RequestScoped
public class UsaEscoposBean {
    
    @Inject @ApplicationMap
    private Map<String, Object> applicationMap;
    
    @Inject @SessionMap
    private Map<String, Object> sessionMap;
    
    @Inject @RequestMap
    private Map<String, Object> requestMap;
    
    @Inject @RequestParameterMap
    private Map<String, String> requestParameterMap;
   
    public void teste(){
        System.out.println("applicationMap >> " + applicationMap);
        System.out.println("sessionMap >> " + sessionMap);
        System.out.println("requestMap >> " + requestMap);
        System.out.println("requestParameterMap >> " + requestParameterMap);
        
    }
}
