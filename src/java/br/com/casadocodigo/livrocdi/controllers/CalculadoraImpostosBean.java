package br.com.casadocodigo.livrocdi.controllers;


import br.com.casadocodigo.livrocdi.estereotipo.CalculadoraBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.casadocodigo.livrocdi.folhapagamento.CalculadoraDeImpostos;
import br.com.casadocodigo.livrocdi.folhapagamento.Funcionario;
import br.com.casadocodigo.livrocdi.folhapagamento.FuncionarioBuilder;

@CalculadoraBean
public class CalculadoraImpostosBean {
    private static final long serialVersionUID = 1L;

    @Inject
    private CalculadoraDeImpostos calculadoraImpostos;
    
    private double salarioBase;
    private double imposto;

    public CalculadoraImpostosBean() {
            System.out.println("Instanciando a CalculadoraImpostosBean...");
    }

    @PostConstruct
    public void ok(){
            System.out.println("CalculadoraImpostosBean pronta.");
    }

    public void calculaImposto() {


            Funcionario funcionario = new FuncionarioBuilder()
                                            .comSalarioBaseDe(salarioBase)
                                            .build();

            System.out.println("Efetuando o cálculo.");
            
            System.out.println("Salário base: " + salarioBase);

            //a calculadora de IR usa outra classe para calcular o salário
            imposto = calculadoraImpostos.calculaImpostoDeRenda(funcionario);
            

            System.out.println("valor do imposto: " + imposto);
            System.out.println("Fim.");
    }

   
    public double getSalarioBase() {
        return salarioBase;
    }

    
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    
    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

}
