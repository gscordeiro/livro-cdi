/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;


//@WebFilter("/*")
public class FiltroAutenticacao implements Filter {
    
    @Inject
    private Logger logger;
    
    @Override
    public void doFilter(ServletRequest request, 
                        ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        //faz um processamento prévio
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Object usuario = session.getAttribute("usuarioLogado");
        
        String paginaDeLogin = "login.jsf";
        String paginaAtual = req.getRequestURI();
        
        if(usuario == null && !paginaAtual.endsWith(paginaDeLogin)){
            //envia para tela de autenticação
            logger.info("usuário não autenticado");
            ((HttpServletResponse)response).sendRedirect(paginaDeLogin);
        }
        else {
            
            //chama a ação original
            chain.doFilter(request, response);
       
            //faz processamento posterior
            logger.info("terminando requisição para página " + paginaAtual);
        
        }
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {
        
    }
}
