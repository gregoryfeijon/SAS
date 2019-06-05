package br.com.sas.model;

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
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Consultorio {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String nome;
	
	@CNPJ
	private String cnpj;
	
	private String nomeFantasia;
	
	private Date dataCriacao;
	
	private String telefone;
	
	private String celular;
	
	@ManyToOne
	private Medico medicoCriador;
	
	@JoinColumn(unique=true)
    @OneToOne
	private Endereco enderecoConsultorio;
	
	@ManyToMany
	private List<Medico> medicos;
	
	@ManyToMany
	private List<Agendamento> agendamentos;

	@ManyToMany
	private List<Paciente> pacientes;
	
	@ManyToMany
	private List<Atendente> atendentes;
	
	
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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Atendente> getAtendentes() {
		return atendentes;
	}

	public void setAtendentes(List<Atendente> atendentes) {
		this.atendentes = atendentes;
	}

	
	
	
	
	
}
