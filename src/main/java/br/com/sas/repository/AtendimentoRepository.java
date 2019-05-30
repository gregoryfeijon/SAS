package br.com.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sas.model.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{

}
