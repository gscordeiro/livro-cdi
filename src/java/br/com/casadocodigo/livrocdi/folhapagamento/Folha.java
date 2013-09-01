package br.com.casadocodigo.livrocdi.folhapagamento;

import java.util.Date;
import java.util.List;

public class Folha {

	private Date dataCalculo;
	private Double valor;
	private List<Funcionario> funcionarios;

	public Folha(Date dataCalculo, Double valor, List<Funcionario> funcionarios) {
		this.dataCalculo = dataCalculo;
		this.valor = valor;
		this.funcionarios = funcionarios;
        }
	
	public Date getDataCalculo() {
		return dataCalculo;
	}
	public Double getValor() {
		return valor;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
}
