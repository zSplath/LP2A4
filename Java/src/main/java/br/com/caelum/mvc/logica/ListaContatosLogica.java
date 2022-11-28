package br.com.caelum.mvc.logica;

import java.util.List;

import br.com.caelum.model.dao.ContatoDao;
import br.com.caelum.model.entities.Contato;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListaContatosLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        List<Contato> contatos = new ContatoDao().getLista();
        
		
        req.setAttribute("contatos", contatos);
        
        return "/WEB-INF/jsp/lista-contatos.jsp";
	}
}
