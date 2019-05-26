package br.com.sas.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Agendamento {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
//	private Date dataConsulta;
	private LocalDate dataConsulta;
	
	private Double valorConsulta;
	
	@ManyToOne
	private Medico medico;
	
	@ManyToOne
	private Paciente paciente;
	
//	On
//	private Atendimento atendimento;
	
	// ================================ GETTERs  and SETTERs =====================================
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public Date getDataConsulta() {
//		return dataConsulta;
//	}
//
//	public void setDataConsulta(Date dataConsulta) {
//		this.dataConsulta = dataConsulta;
//	}
	
	public Double getValorConsulta() {
		return valorConsulta;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
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
