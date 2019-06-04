package br.com.sas.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sas.enums.Estado;
import br.com.sas.model.Medico;
import br.com.sas.service.MedicoService;

@Controller
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	MedicoService medicoService;
	
	@GetMapping("/cadastrarMedico")
	public ModelAndView cadastrarMedicoForm() {
		ModelAndView mv = new ModelAndView("cadastros/cadastro-medico");
		Medico medico = new Medico();
		mv.addObject("medico", medico);
		mv.addObject("estados", Arrays.asList(Estado.values()));
		
		return mv;
	}
}
