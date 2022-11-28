package br.com.caelum.tarefas.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.tarefas.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		
		System.out.println(connection.getClass().getName());
		
		System.out.println("Conexão aberta!");
		
		connection.close();
		
	}

}
