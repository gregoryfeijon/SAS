package br.com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sas.model.Atendente;
import br.com.sas.repository.AtendenteRepository;

@Service
public class AtendenteService {
	
	@Autowired
	private AtendenteRepository repository;
	
	public List<Atendente> findAll() {
		return repository.findAll();
	}
	
	public Optional<Atendente> findOne(Long id) {
		return repository.findById(id); 
	}
	
	public Atendente save(Atendente atendente) {
		return repository.save(atendente);
//		return repository.saveAndFlush(atendente);
	}
	
	
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
