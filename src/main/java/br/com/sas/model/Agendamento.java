package br.com.sas.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Agendamento {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Por favor, informe a DATA, da do agendamneto da consulta")
	private Date dataConsulta;
	
	@NotNull(message = "Por favor, informe o valor da consulta")
	private Double valorConsulta;
	
	@ManyToOne(cascade = {CascadeType.DETACH})
	@NotNull(message = "É necessário, que tenha um MÉDICO, no agendamento")
	private Medico medico = new Medico();
	
	@ManyToOne(cascade = {CascadeType.DETACH})
	@NotNull(message = "É necessário, que tenha um PACIENTE, no agendamento ")
	private Paciente paciente = new Paciente();
	
//	On
//	private Atendimento atendimento;
	
	// ================================ GETTERs  and SETTERs =====================================
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Double getValorConsulta() {
		return valorConsulta;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public void setValorConsulta(Double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	
	
	
}
