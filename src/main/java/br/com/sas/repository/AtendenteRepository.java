package br.com.sas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sas.model.Atendente;

public interface AtendenteRepository extends JpaRepository<Atendente, Long>{
	
	@Query("SELECT a FROM Atendente a WHERE a.nome LIKE %?1%")
	Page<Atendente> findAtendenteByNome(Pageable pageable, String nome);
	
}
