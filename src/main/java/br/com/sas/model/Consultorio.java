package br.com.sas.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

@Entity
public class Consultorio {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	private String cnpj;
	
	private String nomeFantasia;
	
//	private Date dataCriacao;
	private LocalDate dataCriacao;
	
	@ManyToOne
	private Medico medicoCriador;
	
	@JoinColumn(unique=true)
    @OneToOne
	private Endereco enderecoConsultorio;
	
//	@LazyCollection : VER SE É ESSA A ANOTAÇÃO, QUE FAZ O TRABALHO DE ("LAZY LOAD")
	@ManyToMany
	private List<Medico> medicos;
	
	@ManyToMany
	private List<Agendamento> agendamentos;

	
	
	// ================================ GETTERs  and SETTERs =====================================
	public Medico getMedicoCriador() {
		return medicoCriador;
	}

	public void setMedicoCriador(Medico medicoCriador) {
		this.medicoCriador = medicoCriador;
	}

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Endereco getEnderecoConsultorio() {
		return enderecoConsultorio;
	}

	public void setEnderecoConsultorio(Endereco enderecoConsultorio) {
		this.enderecoConsultorio = enderecoConsultorio;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	
	
	
	
	
}
