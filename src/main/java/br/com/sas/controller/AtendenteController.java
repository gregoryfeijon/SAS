package br.com.sas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sas.model.Atendente;
import br.com.sas.repository.AtendenteRepository;

@Controller
public class AtendenteController {

	@Autowired
	AtendenteRepository ar;
	
	@GetMapping("/")
//	@ResponseBody
	public String ola() {
		
		return "cadastros/cadastro-atendente";
	}
	
	
	@PostMapping("/cadastrarAtendente")
	public String form(@Valid Atendente atendente, BindingResult result, RedirectAttributes attributes){
//		if(result.hasErrors()){
//			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
//			return "redirect:/cadastrarEvento";
//		}
		
		ar.save(atendente);
		attributes.addFlashAttribute("mensagem", "Atendente cadastrado com sucesso!");
		return "redirect:/";
	}
}
