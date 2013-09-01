package br.com.casadocodigo.livrocdi.folhapagamento;

public class Cargo {

	private double salarioBase;
	private Escolaridade escolaridade;
	
	public Cargo(double salarioBase, Escolaridade escolaridade) {
		this.salarioBase = salarioBase;
		this.escolaridade = escolaridade;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public Escolaridade getEscolaridadeDesejada() {
		return escolaridade;
	}

}
