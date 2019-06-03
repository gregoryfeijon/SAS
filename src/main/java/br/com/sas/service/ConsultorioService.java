package br.com.sas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.com.sas.model.Consultorio;
import br.com.sas.repository.ConsultorioRepository;

@Service
public class ConsultorioService {
	
	@Autowired
	private ConsultorioRepository repository;
	
	public List<Consultorio> findAll() {
		return repository.findAll();
	}
	
	public Optional<Consultorio> findOne(Long id) {
		return repository.findById(id); 
	}
	
	public Consultorio save(Consultorio consultorio) {
		return repository.saveAndFlush(consultorio);
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
