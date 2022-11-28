package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.model.dao.ContatoDao;
import br.com.caelum.model.entities.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		Contato contato = new Contato();
		
		contato.setNome("Nomail");
		contato.setEmail("");
		contato.setEndereco("Rua nomail, 111");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adicionaContato(contato);
		
		System.out.println("Contato gravado com sucesso!");
	}

}
