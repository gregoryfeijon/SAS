package br.com.sas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")   		
public class Paciente extends Pessoa {

//	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	
	@ManyToMany
	private List<Alergias> alergiasPaciente;

	
	// ================================ GETTERs  and SETTERs =====================================
	public List<Alergias> getAlergiasPaciente() {
		return alergiasPaciente;
	}

	public void setAlergiasPaciente(List<Alergias> alergiasPaciente) {
		this.alergiasPaciente = alergiasPaciente;
	}
	

	
	
}
