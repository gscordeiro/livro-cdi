/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.events;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.inject.Produces;

/**
 *
 * @author gilliard
 */
public class ExecutorProvider {
    
    @Resource
    private ManagedExecutorService executorService;
    
    
    @Produces
    public ExecutorService produzExecutorService(){
        if(executorService != null) return executorService;
        
        return Executors.newSingleThreadExecutor();
    }
}
