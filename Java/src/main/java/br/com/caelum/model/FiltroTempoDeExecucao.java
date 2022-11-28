package br.com.caelum.model;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			long tempoInicial = System.currentTimeMillis();
			
			chain.doFilter(request, response);
			
			long tempoFinal = System.currentTimeMillis();
			String uri = ((HttpServletRequest)request).getRequestURI();
			String parametros = ((HttpServletRequest) request).getParameter("logica");
			System.out.println("Tempo da requisicao de " + uri+ "?logica="+ parametros + " demorou (ms): "+ (tempoFinal - tempoInicial));
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
