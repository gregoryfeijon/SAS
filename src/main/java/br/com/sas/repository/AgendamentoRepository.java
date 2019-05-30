package br.com.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sas.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

}
