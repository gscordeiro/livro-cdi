package br.com.casadocodigo.livrocdi.folhapagamento;

public interface CalculadoraDeSalarios {

	double calculaSalario(Funcionario funcionario);
        void setTabelaDeReferenciaSalarial(TabelaDeReferenciaSalarial tabela);

}