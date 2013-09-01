package br.com.casadocodigo.livrocdi.servlets;

import br.com.casadocodigo.livrocdi.folhapagamento.CalculadoraDeSalarios;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.casadocodigo.livrocdi.folhapagamento.CalculadoraFolhaPagamento;
import br.com.casadocodigo.livrocdi.folhapagamento.Folha;
import br.com.casadocodigo.livrocdi.folhapagamento.Funcionario;
import br.com.casadocodigo.livrocdi.folhapagamento.FuncionarioBuilder;

@WebServlet("/calcular-folha")
public class CalcularFolhaPagamento extends HttpServlet {

	private static final long serialVersionUID = -1101326761035072120L;
	
	
	@Inject
	private CalculadoraFolhaPagamento calculadoraFolha;
        
        public CalcularFolhaPagamento() {
		System.out.println("Instanciando a Servlet CalcularFolhaPagamento...");
	}
	
	@PostConstruct
	public void ok(){
		System.out.println("CalcularFolhaPagamento pronta.");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
										throws ServletException, IOException {
		
		FuncionarioBuilder builder = new FuncionarioBuilder();

		Funcionario f1 = builder.comSalarioBaseDe(1000.0).build();
		Funcionario f2 = builder.comSalarioBaseDe(2000.0).build();
		Funcionario f3 = builder.comSalarioBaseDe(3000.0).build();

		List<Funcionario> funcionarios = Arrays.asList(f1, f2, f3);

		System.out.println("Efetuando o cálculo...");

		Folha folha = calculadoraFolha.calculaFolha(funcionarios);
		
		//mensagem para o usuário
		res.getOutputStream().print("Calculo da folha executado com sucesso");

		//saída no console
		System.out.println("Fim.");
	}

}
