package br.com.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sas.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
