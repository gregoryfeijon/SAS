package br.com.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sas.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
