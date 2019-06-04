package br.com.sas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.com.sas.model.Atendente;
import br.com.sas.model.Paciente;
import br.com.sas.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repository;
	
	public List<Paciente> findAll() {
		return repository.findAll();
	}
	
	public Page<Paciente> findAll(PageRequest pr) {
//		PageRequest.of(page, 5)
		return repository.findAll(pr);
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
	
	public List<String> getMensagensErros(BindingResult bindResult) {
		List<String> msg = new ArrayList<>();
		for(ObjectError objError : bindResult.getAllErrors()) {
			msg.add(objError.getDefaultMessage());
		}
		return msg;
	}
	
}
