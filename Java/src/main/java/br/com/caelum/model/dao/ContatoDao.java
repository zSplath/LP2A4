package br.com.caelum.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.DbException;
import br.com.caelum.model.entities.Contato;
import br.com.caelum.mvc.logica.Logica;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContatoDao {	
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public ContatoDao(Connection connection) {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionaContato(Contato obj) {
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement(
					" INSERT INTO contatos "
					+ "(nome, email, endereco, dataNascimento) "
					+ "VALUES "
					+ "(?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS
					);
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getEmail());
			st.setString(3, obj.getEndereco());
			st.setDate(4, new Date(obj.getDataNascimento().getTimeInMillis()));
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				ConnectionFactory.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro inesperado! Nenhuma linha foi afetada.");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			ConnectionFactory.closeStatement(st);
		}
}
	
	public List<Contato> getLista() {
		PreparedStatement st = null;
		
		try {
			List<Contato> contatos = new ArrayList<>();
			st = connection.prepareStatement(
					"SELECT * FROM contatos"
					);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			ConnectionFactory.closeResultSet(rs);
			return contatos;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			ConnectionFactory.closeStatement(st);
		}
	}

	public void removeContato(int id) {
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement(
					"DELETE FROM contatos "
					+ "WHERE "
					+ "id = ?;"
					);
			
			st.setInt(1, id);
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println("Deletado com sucesso! "+ rowsAffected +" linha(s) afetada(s).");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			ConnectionFactory.closeStatement(st);
		}
	}
	
	public void alteraContato(Contato obj) {
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement(
					"UPDATE contatos "
					+ "SET nome = ?, email = ?, endereco = ?, dataNascimento = ? "
					+ "WHERE id = ?;"
					);
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getEmail());
			st.setString(3, obj.getEndereco());
			st.setDate(4, new Date(obj.getDataNascimento().getTimeInMillis()));
			st.setLong(5, obj.getId());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println("Alteração realizada com sucesso!");
			}
			else {
				throw new DbException("Ocorreu um erro inesperado. Nenhuma linha foi afetada.");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			ConnectionFactory.closeStatement(st);
		}
	}

	public Contato encontraPorId(int id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		Contato contato = new Contato();
		
		try {
			st = connection.prepareStatement(
					"SELECT * FROM contatos "
					+ "WHERE id = ?"
					);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setDataNascimento(data);
			}
			else {
				throw new DbException("Erro inesperado. Nenhuma linha foi afetada");
			}
						
			return contato;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			ConnectionFactory.closeStatement(st);
			ConnectionFactory.closeResultSet(rs);
		}
	}
}
