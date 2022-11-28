package br.com.caelum.mvc.logica;

import java.sql.Connection;

import br.com.caelum.model.dao.ContatoDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		
		Connection connection = (Connection) req.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);

		dao.removeContato((int)id);
		
	    System.out.println("Excluindo contato... ");
	      
	    return "mvc?logica=ListaContatosLogica";
	}

}
