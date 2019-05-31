package br.com.sas.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")   		
public class Atendente extends Pessoa {

//	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	
//	public void teste() {
//		
//		Atendente a = new Atendente().getDataNascimento()
//	}
}
