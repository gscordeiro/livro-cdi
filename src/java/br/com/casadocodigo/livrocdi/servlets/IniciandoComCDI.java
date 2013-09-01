package br.com.casadocodigo.livrocdi.servlets;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.casadocodigo.livrocdi.folhapagamento.CalculadoraDeImpostos;
import br.com.casadocodigo.livrocdi.folhapagamento.Funcionario;
import br.com.casadocodigo.livrocdi.folhapagamento.FuncionarioBuilder;

@WebServlet("/hello-cdi")
public class IniciandoComCDI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private CalculadoraDeImpostos calculadoraImpostos;
	
	public IniciandoComCDI() {
		System.out.println("Instanciando a Servlet...");
	}
	
	@PostConstruct
	public void ok(){
		System.out.println("Servlet pronta.");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		double salarioBase = Double.parseDouble(req.getParameter("salario"));
		
		Funcionario funcionario = new FuncionarioBuilder()
										.comSalarioBaseDe(salarioBase)
										.build();

		System.out.println("Efetuando o cálculo.");
		
		//a calculadora de IR usa outra classe para calcular o salário
		double imposto = calculadoraImpostos.calculaImpostoDeRenda(funcionario);
		
		res.getOutputStream().print(String.format("Salario base: R$ %.2f\n" +
				"Imposto devido: R$ %.2f", salarioBase, imposto));
		System.out.println("Fim.");
	}

}
