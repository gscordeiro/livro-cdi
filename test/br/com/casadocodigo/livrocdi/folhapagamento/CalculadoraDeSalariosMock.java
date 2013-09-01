package br.com.casadocodigo.livrocdi.folhapagamento;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Vetoed;

@Vetoed
public class CalculadoraDeSalariosMock extends CalculadoraDeSalariosPlano2005 {

	private double salarioFixo;

	public CalculadoraDeSalariosMock(double salarioFixo){
		this.salarioFixo = salarioFixo;
	}
	public double calculaSalario(Funcionario funcionario){
		return salarioFixo;
	}
}
