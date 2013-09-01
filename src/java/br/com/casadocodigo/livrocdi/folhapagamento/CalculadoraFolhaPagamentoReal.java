package br.com.casadocodigo.livrocdi.folhapagamento;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class CalculadoraFolhaPagamentoReal implements CalculadoraFolhaPagamento, Serializable {

        @Inject
        private CalculadoraDeSalarios calculadoraDeSalarios;
    
	@Override
	public Folha calculaFolha(List<Funcionario> funcionarios) {
		double valor = 0.0;
                for (Funcionario funcionario : funcionarios) {
                    valor += calculadoraDeSalarios.calculaSalario(funcionario);
                }
		return new Folha(new Date(), valor, funcionarios);
	}

}
