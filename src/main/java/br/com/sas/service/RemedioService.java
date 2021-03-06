package br.com.sas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.com.sas.model.Remedio;
import br.com.sas.repository.RemedioRepository;

@Service
public class RemedioService {
	
	@Autowired
	private RemedioRepository repository;
	
	public List<Remedio> findAll() {
		return repository.findAll();
	}
	
	public Optional<Remedio> findOne(Long id) {
		return repository.findById(id); 
	}
	
	public Remedio save(Remedio remedio) {
		return repository.saveAndFlush(remedio);
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
