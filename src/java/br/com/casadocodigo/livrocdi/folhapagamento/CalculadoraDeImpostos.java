package br.com.casadocodigo.livrocdi.folhapagamento;

import br.com.casadocodigo.livrocdi.interceptador.Auditavel;
import br.com.casadocodigo.livrocdi.interceptador.Rastreavel;
import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

//@Stateless
@Rastreavel @Auditavel
public class CalculadoraDeImpostos {

	private CalculadoraDeSalarios calculadoraSalarios;

        public CalculadoraDeImpostos(){}
        
	@Inject
	public CalculadoraDeImpostos(CalculadoraDeSalarios calculadora){
		System.out.println("Iniciando Calculadora de impostos...");
		calculadoraSalarios = calculadora;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Calculadora de impostos pronta!");
	}

        @Schedule(hour = "*", minute = "*", second = "*/10")
        public void teste(){
            System.out.println("@@@##### via timer!!!");
        }
        
        
	public double calculaImpostoDeRenda(Funcionario funcionario){
		double salario = calculadoraSalarios.calculaSalario(funcionario);

		//tabela de IR de 2013
		double aliquota = 0.0;
		double parcelaDeduzir = 0.0;

		//ifs estão de forma mais didática, na prática poderiam ser reduzidos
		if(salario <= 1710.78){
			aliquota = 0.0;
			parcelaDeduzir = 0.0;
		}
		else if(salario > 1710.78 && salario <= 2563.91){
			aliquota = 7.5/100;
			parcelaDeduzir = 128.31;
		}
		else if(salario > 2563.91 && salario <= 3418.59){
			aliquota = 15.0/100;
			parcelaDeduzir = 320.60;
		}
		else if(salario > 3418.59 && salario <= 4271.59){
			aliquota = 22.5/100;
			parcelaDeduzir = 577.0;
		}
		else if(salario > 4271.59){
			aliquota = 27.5/100;
			parcelaDeduzir = 790.58;
		}

		double impostoSemDesconto = salario * aliquota;

		return impostoSemDesconto - parcelaDeduzir;
	}
}
