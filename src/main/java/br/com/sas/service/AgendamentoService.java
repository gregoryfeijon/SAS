package br.com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sas.model.Agendamento;
import br.com.sas.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository repository;
	
	public List<Agendamento> findAll() {
		return repository.findAll();
	}
	
	public Optional<Agendamento> findOne(Long id) {
		return repository.findById(id); 
	}
	
	public Agendamento save(Agendamento agendamento) {
		return repository.saveAndFlush(agendamento);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
