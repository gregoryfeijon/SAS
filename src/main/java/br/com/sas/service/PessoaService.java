package br.com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sas.model.Pessoa;
import br.com.sas.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public Optional<Pessoa> findOne(Long id) {
		return repository.findById(id); 
	}
	
	public Pessoa save(Pessoa pessoa) {
		return repository.saveAndFlush(pessoa);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}
