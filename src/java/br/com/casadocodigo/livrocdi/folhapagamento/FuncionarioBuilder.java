package br.com.casadocodigo.livrocdi.folhapagamento;

import br.com.casadocodigo.livrocdi.folhapagamento.Cargo;
import br.com.casadocodigo.livrocdi.folhapagamento.Escolaridade;
import br.com.casadocodigo.livrocdi.folhapagamento.Funcionario;
import java.util.Calendar;

public class FuncionarioBuilder {

	private int anoAdmissao;
	private Escolaridade escolaridadeFuncionario;
	private Escolaridade escolaridadeCargo;
	private double salarioBase;
	
	public FuncionarioBuilder() {
		escolaridadeCargo = escolaridadeFuncionario = Escolaridade.SUPERIOR;
		anoAdmissao = Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public FuncionarioBuilder comTempoDeServicoDe(int quantidade, int unidadeDeTempo){
		Calendar calendar = Calendar.getInstance();
		calendar.add(unidadeDeTempo, -quantidade);
		anoAdmissao = calendar.get(Calendar.YEAR);
		
		return this;
	}
	
	public FuncionarioBuilder comEscolaridadeInferior(){
		escolaridadeFuncionario = Escolaridade.MEDIO;
		escolaridadeCargo = Escolaridade.SUPERIOR;
		
		return this;
	}
	public FuncionarioBuilder comEscolaridadeCorreta(){
		escolaridadeFuncionario = Escolaridade.SUPERIOR;
		escolaridadeCargo = Escolaridade.SUPERIOR;
		
		return this;
	}
	public FuncionarioBuilder comEscolaridadeAcima(){
		escolaridadeFuncionario = Escolaridade.ESPECIALIZACAO;
		escolaridadeCargo = Escolaridade.SUPERIOR;
		
		return this;
	}
	
	public FuncionarioBuilder comSalarioBaseDe(double salarioBase){
		this.salarioBase = salarioBase;
		
		return this;
	}
	
	public Funcionario build(){
		Cargo cargo = new Cargo(salarioBase, escolaridadeCargo);
		return new Funcionario("Fulano", cargo, escolaridadeFuncionario, anoAdmissao);
	}
}
