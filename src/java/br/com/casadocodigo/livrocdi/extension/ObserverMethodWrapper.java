/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.extension;

import java.lang.reflect.Type;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.enterprise.inject.spi.ObserverMethod;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gilliard
 */
public class ObserverMethodWrapper<T> implements ObserverMethod<T> {

    private Logger logger = LoggerFactory.getLogger(ObserverMethodWrapper.class);
    
    private ObserverMethod delegate;
    
    private ExecutorService executor;

    public ObserverMethodWrapper(ObserverMethod delegate) {
        this.delegate = delegate;
    }

    private ExecutorService getExecutor() {
        if (executor != null) {
            return executor;
        }

        try {
            Context ctx = new InitialContext();
            executor = (ManagedExecutorService) ctx.lookup("java:comp/env/concurrent/ManagedExecutorService");
        } catch (Exception e) {
            logger.error("Erro ao buscar o ManagedExecutorService (JSR 236)", e);
            logger.warn("Usando implementação simples de Executors.newCachedThreadPool()");
            executor = Executors.newCachedThreadPool();
        }
        
        return executor;

    }

    @Override
    public Class getBeanClass() {
        return delegate.getBeanClass();
    }

    @Override
    public Type getObservedType() {
        return delegate.getObservedType();
    }

    @Override
    public Set getObservedQualifiers() {
        return delegate.getObservedQualifiers();
    }

    @Override
    public Reception getReception() {
        return delegate.getReception();
    }

    @Override
    public TransactionPhase getTransactionPhase() {
        return delegate.getTransactionPhase();
    }

    @Override
    public void notify(Object event) {
        
        getExecutor().execute(new ExecuteEventRunnable(delegate, event));
    }

    class ExecuteEventRunnable implements Runnable {

        private ObserverMethod delegate;
        private Object event;

        public ExecuteEventRunnable(ObserverMethod delegate, Object event) {
            this.delegate = delegate;
            this.event = event;
        }

        @Override
        public void run() {
            delegate.notify(event);
        }
    }
}
