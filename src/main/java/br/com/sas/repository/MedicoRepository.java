package br.com.sas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sas.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

	@Query("SELECT a FROM Medico a WHERE a.nome LIKE %?1%")
	Page<Medico> findMedicoByNome(Pageable pageable, String nome);
}
