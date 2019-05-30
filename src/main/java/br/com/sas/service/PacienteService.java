package br.com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sas.model.Paciente;
import br.com.sas.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repository;
	
	public List<Paciente> findAll() {
		return repository.findAll();
	}
	
	public Optional<Paciente> findOne(Long id) {
		return repository.findById(id); 
	}
	
	public Paciente save(Paciente paciente) {
		return repository.saveAndFlush(paciente);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}
