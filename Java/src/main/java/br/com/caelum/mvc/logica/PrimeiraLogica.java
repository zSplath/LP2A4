package br.com.caelum.mvc.logica;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		System.out.println("Executando a lógica...");
		
		System.out.println("Retornando o nome da página JSP...");
		
		return "primeira-logica.jsp";
	}

}
