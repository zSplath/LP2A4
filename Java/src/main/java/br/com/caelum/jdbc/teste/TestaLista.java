package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.model.dao.ContatoDao;
import br.com.caelum.model.entities.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato obj : contatos) {
			System.out.println(obj);
		}
	}
}
