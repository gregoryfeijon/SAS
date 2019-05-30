package br.com.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
