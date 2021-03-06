package br.com.sas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.com.sas.model.Alergia;
import br.com.sas.repository.AlergiaRepository;

@Service
public class AlergiaService {
	
	@Autowired
	private AlergiaRepository repository;
	
	public List<Alergia> findAll() {
		return repository.findAll();
	}
	
	public Optional<Alergia> findOne(Long id) {
		return repository.findById(id); 
	}
	
	public Alergia save(Alergia alergia) {
		return repository.saveAndFlush(alergia);
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
