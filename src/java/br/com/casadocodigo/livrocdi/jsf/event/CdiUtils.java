/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.jsf.event;

import javax.enterprise.inject.spi.BeanManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gilliard
 */
public class CdiUtils {
    
    private static final String BEAN_MANAGER_JNDI_NAME_JEE = "java:comp/BeanManager";
    private static final String BEAN_MANAGER_JNDI_NAME_NON_JEE = "java:comp/env/BeanManager";
    
    private Logger logger = LoggerFactory.getLogger(CdiUtils.class);
    
    public BeanManager getBeanManager(){
        try {
            Context ctx = new InitialContext();
            BeanManager beanManager = (BeanManager) ctx.lookup(BEAN_MANAGER_JNDI_NAME_JEE);
            return beanManager;
        } catch (Exception e) {
            logger.error("Falha ao buscar o BeanManager via lookup", e);
            return null;
        }
    }
}
