package br.com.casadocodigo.livrocdi.folhapagamento;

import java.util.Set;
import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Decorated;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import org.slf4j.Logger;

@Decorator @Priority(Interceptor.Priority.APPLICATION)
public class CalculadoraDeSalariosPlano2013 implements CalculadoraDeSalarios {
	
        @Inject @Delegate
        private CalculadoraDeSalarios delegate;
        
        @Inject @Decorated
        private Bean<CalculadoraDeSalarios> bean;
        
        @Inject
        private Logger logger;
	
	@Override
	public double calculaSalario(Funcionario funcionario){
            
                logger.info("Delegate plano 2013");
                Class beanClass = bean.getBeanClass();
                Set<InjectionPoint> injectionPoints = bean.getInjectionPoints();
                logger.info(String.format("Bean original: '%s' "
                        + "com injection points: '%s'", beanClass, injectionPoints));
            
		double salario = delegate.calculaSalario(funcionario);
                
                return salario * 1.1;
	}

    @Override
    public void setTabelaDeReferenciaSalarial(TabelaDeReferenciaSalarial tabela) {
    }

}
