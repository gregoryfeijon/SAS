package br.com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sas.model.Endereco;
import br.com.sas.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll() {
		return repository.findAll();
	}
	
	public Optional<Endereco> findOne(Long id) {
		return repository.findById(id); 
	}
	
	public Endereco save(Endereco endereco) {
		return repository.saveAndFlush(endereco);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}
