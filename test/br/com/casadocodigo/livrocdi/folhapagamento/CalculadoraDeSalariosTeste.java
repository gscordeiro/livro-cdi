package br.com.casadocodigo.livrocdi.folhapagamento;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

public class CalculadoraDeSalariosTeste {

	@Test
	public void testaSalarioFuncionarioComEscolaridadeCorretaSemTempoServico(){
		
		Funcionario funcionario = new FuncionarioBuilder()
										.comSalarioBaseDe(3000.0)
										.comEscolaridadeCorreta()
										.build();
		
		CalculadoraDeSalarios calculadora = new CalculadoraDeSalariosPlano2005();
		
		double salario = calculadora.calculaSalario(funcionario);
		
		Assert.assertEquals(3000.0, salario, 0.000);
		
	}
	
	@Test
	public void testaSalarioFuncionarioComEscolaridadeCorretaE2AnosServico(){
		
		Funcionario funcionario = new FuncionarioBuilder()
										.comSalarioBaseDe(3000.0)
										.comEscolaridadeCorreta()
										.comTempoDeServicoDe(2, Calendar.YEAR)
										.build();
		
		CalculadoraDeSalarios calculadora = new CalculadoraDeSalariosPlano2005();
		
		double salario = calculadora.calculaSalario(funcionario);
		
		//2% de aumento
		Assert.assertEquals(3000.0 * 1.02, salario, 0.000);
		
	}
	@Test
	public void testaSalarioFuncionarioComEscolaridadeAcimaE3AnosServico(){
		
		Funcionario funcionario = new FuncionarioBuilder()
										.comSalarioBaseDe(3000.0)
										.comEscolaridadeAcima()
										.comTempoDeServicoDe(3, Calendar.YEAR)
										.build();
		
		CalculadoraDeSalarios calculadora = new CalculadoraDeSalariosPlano2005();
		
		double salario = calculadora.calculaSalario(funcionario);
		
		//(20% escolaridade + 3% dos 3 anos)
		double salarioEsperado = 3000.0 * 1.2;
		salarioEsperado *= 1.03;
		Assert.assertEquals(salarioEsperado, salario, 0.000);
		
	}
}
