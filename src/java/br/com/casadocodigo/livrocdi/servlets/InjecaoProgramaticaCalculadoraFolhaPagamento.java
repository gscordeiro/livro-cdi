package br.com.casadocodigo.livrocdi.servlets;

import br.com.casadocodigo.livrocdi.folhapagamento.CalculadoraFolhaPagamento;
import br.com.casadocodigo.livrocdi.qualificadores.SimuladorQualifier;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/injecao-programatica")
public class InjecaoProgramaticaCalculadoraFolhaPagamento extends HttpServlet {

    @Inject
    private Instance<CalculadoraFolhaPagamento> calculadoraFolhaPagamentoPadrao;
    
    @Inject @Any
    private Instance<CalculadoraFolhaPagamento> todasCalculadoraFolhaPagamento;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        PrintWriter writer = res.getWriter();
        
        writer.printf("Calculadora padrão de folha %s \n ", calculadoraFolhaPagamentoPadrao.get().getClass());
        
        
        writer.printf("Todas Calculadoras de folha: \n");
        
        Iterator<CalculadoraFolhaPagamento> iterator = todasCalculadoraFolhaPagamento.iterator();
        while(iterator.hasNext()){
            writer.printf("-> %s\n", iterator.next().getClass());
        }
        
        
        Instance<CalculadoraFolhaPagamento> simuladores = todasCalculadoraFolhaPagamento.select(new SimuladorQualifier(){});
        writer.printf("\nTodas Simuladoras de calculadoras: \n");
        
        Iterator<CalculadoraFolhaPagamento> iterator2 = simuladores.iterator();
        while(iterator2.hasNext()){
            writer.printf("-> %s\n", iterator2.next().getClass());
        }
    }

}
