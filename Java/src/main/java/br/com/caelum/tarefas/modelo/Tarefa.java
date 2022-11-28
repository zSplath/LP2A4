package br.com.caelum.tarefas.modelo;

import java.util.Calendar;

public class Tarefa {
	private long id;
	private String descricao;
	private boolean finalizado;
	private Calendar dataFinalizacao;
	
	public Tarefa() {
	}

	public Tarefa(long id, String descricao, boolean finalizado, Calendar dataFinalizacao) {
		this.id = id;
		this.descricao = descricao;
		this.finalizado = finalizado;
		this.dataFinalizacao = dataFinalizacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}	
}
