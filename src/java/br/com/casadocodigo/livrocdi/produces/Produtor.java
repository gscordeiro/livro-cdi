package br.com.casadocodigo.livrocdi.produces;

import javax.enterprise.inject.Produces;

import br.com.casadocodigo.livrocdi.folhapagamento.CalculadoraFolhaPagamento;
import br.com.casadocodigo.livrocdi.folhapagamento.CalculadoraFolhaPagamentoReal;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Produtor {

//	@Produces
	public CalculadoraFolhaPagamento criaUmaCalculadora(){
		System.out.println("Produtor.criaUmaCalculadora()");
		return new CalculadoraFolhaPagamentoReal();
	}
        
        @Produces
        public Logger criaLogger(InjectionPoint injectionPoint){
            return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
        }
}
