package br.com.sas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Remedio {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	private String observacao;
	
	// ================================ GETTERs  and SETTERs =====================================
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
