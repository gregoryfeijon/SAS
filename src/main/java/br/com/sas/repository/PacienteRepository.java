package br.com.sas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sas.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	@Query("SELECT p FROM Paciente p WHERE p.nome LIKE %?1%")
	Page<Paciente> findPacienteByNome(Pageable pageable, String nome);
}
