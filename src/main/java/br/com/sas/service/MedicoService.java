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

import br.com.sas.model.Medico;
import br.com.sas.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;

	public List<Medico> findAll() {
		return repository.findAll();
	}

	public Page<Medico> findAll(PageRequest pr) {
		return repository.findAll(pr);
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
	
	public void delete(Medico medico) {
		repository.delete(medico);
	}

	public List<String> getMensagensErros(BindingResult bindResult) {
		List<String> msg = new ArrayList<>();
		for (ObjectError objError : bindResult.getAllErrors()) {
			msg.add(objError.getDefaultMessage());
		}
		return msg;
	}

}
