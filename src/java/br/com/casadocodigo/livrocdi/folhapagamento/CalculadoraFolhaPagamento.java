package br.com.casadocodigo.livrocdi.folhapagamento;

import java.util.List;

public interface CalculadoraFolhaPagamento {

	Folha calculaFolha(List<Funcionario> funcionarios);

}
