/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.interceptador;

import java.lang.reflect.Method;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;

@Interceptor @Auditavel @Priority(Interceptor.Priority.APPLICATION)
public class Auditor {
    
    @Inject
    private Logger logger;
    
    
    @AroundInvoke
    public Object auditar(InvocationContext context) throws Exception {
        
        //faz processamento antes
        logger.info("faz processamento anterior");
        
        Method method = context.getMethod();
        Object target = context.getTarget();
        Object[] params = context.getParameters();
        
        logger.info(String.format("auditando o método: '%s' "
                + "do objeto: '%s' "
                + "com os parâmetros: '%s'", method, target, params));
        
        
        //chama o método orignal
        logger.info("chama método original");
        Object retorno = context.proceed();
        
        
        //faz processamento posterior
        logger.info("faz processamento posterior");
        
        return retorno;
    }
}
