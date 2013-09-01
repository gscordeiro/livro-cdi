package br.com.casadocodigo.livrocdi.folhapagamento;

import java.util.List;

import br.com.casadocodigo.livrocdi.qualificadores.Simulador;

@Simulador
public class SimuladoraCalculoFolhaPagamento implements
		CalculadoraFolhaPagamento {

	@Override
	public Folha calculaFolha(List<Funcionario> funcionarios) {
		System.out.println("Apenas uma simulação da folha de pagamentos");
		return null;
	}

}
