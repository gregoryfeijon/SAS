package br.com.sas.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")   		
public class Medico extends Pessoa {

	private static final String CRM_OBRIGATORIO = "O campo CRM do médico é obrigatório!";
	
	private String especialidade;
	
	@NotNull (message = CRM_OBRIGATORIO)
	@NotBlank (message = CRM_OBRIGATORIO)
	private String crm;
	
	// ================================ GETTERs  and SETTERs =====================================
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	
}
