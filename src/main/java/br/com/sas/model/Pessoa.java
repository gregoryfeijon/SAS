package br.com.sas.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

//import org.springframework.data.annotation.Id;

@Entity
//@Inheritance(strategy= InheritanceType.JOINED) 	
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
public class Pessoa {	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
//	@Lob
	private String rg;
	
//	@Lob
	private String cpf;
	
	@DateTimeFormat
	private Date dataNascimento;
	
	private int telefone;
	
	private int celular;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@JoinColumn(unique=true)
	@OneToOne
	private Endereco endereco;
	
	
	// ================================ GETTERs  and SETTERs =====================================
	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getTelefone() {
		return telefone;
	}
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public int getCelular() {
		return celular;
	}
	
	public void setCelular(int celular) {
		this.celular = celular;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
		
}
