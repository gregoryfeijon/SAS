package br.com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sas.model.Medico;
import br.com.sas.repository.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository repository;
	
	public List<Medico> findAll() {
		return repository.findAll();
	}
	
	public Optional<Medico> findOne(Long id) {
		return repository.findById(id); 
	}
	
	public Medico save(Medico medico) {
		return repository.saveAndFlush(medico);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}
