package br.com.sas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sas.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
	
	@Query("SELECT a FROM Agendamento a WHERE a.paciente.nome LIKE %?1%")
	Page<Agendamento> findAgendamentoByPaciente(Pageable pageable, String nome);
}
