/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.interceptador;

import br.com.casadocodigo.livrocdi.folhapagamento.CalculadoraDeImpostos;
import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundTimeout;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor @Rastreavel @Priority(1000)
public class RastreadorConstrutor {
    
//    @AroundTimeout
    public Object timer(InvocationContext context) throws Exception{
        
        Object target = context.getTarget();
        
        Object retorno = context.proceed();
        
        System.out.println("intercept timer!");
        
        return retorno;
        
    }
    
    @PostConstruct
    public void postConstruct(InvocationContext context) throws Exception{
        Object target = context.getTarget();
        
        context.proceed();
        
        System.out.println(">>> intercept post construct");
    }
    
    @AroundConstruct
    public void construct(InvocationContext context) throws Exception {
        
        Object target = context.getTarget();
        
        boolean teste = true;
//        if(teste){
            Object obj = context.proceed();
//        }
        
        target = context.getTarget();
        
        Object novo = new CalculadoraDeImpostos(null);
        
        
        if(false)throw new Exception("!!!!!!paulera ao criar a calculadora de impostos!!!!!");
        
        //return novo;
        
    }
}
