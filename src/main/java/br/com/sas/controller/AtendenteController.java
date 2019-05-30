package br.com.sas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sas.model.Atendente;
import br.com.sas.service.AtendenteService;
import br.com.sas.service.EnderecoService;

@Controller
@RequestMapping("/atendente")
public class AtendenteController {

	@Autowired
	AtendenteService atendenteService;
	
	@Autowired 
	EnderecoService enderecoService;
	
	@GetMapping("/cadastrarAtendente")
	public String form() {
		return "cadastros/cadastro-atendente";
	}
	
	
	@PostMapping("/cadastrarAtendente")
	public String save(@Valid Atendente atendente, BindingResult result, RedirectAttributes attributes){
//		if(result.hasErrors()){
//			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
//			return "redirect:/cadastrarEvento";
//		}
		
		enderecoService.save(atendente.getEndereco());
		atendenteService.save(atendente);
		attributes.addFlashAttribute("mensagem", "Atendente cadastrado com sucesso!");
		return "redirect:/atendente/cadastrarAtendente";
//		return findAll();
	}
	
	
	@GetMapping("/consultar")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/consultar-atendentes");
		mv.addObject("listAtendentes", atendenteService.findAll());
		return mv;
	}
	
//	@GetMapping("/editar/{id}")
//	public ModelAndView edit(@PathVariable("id") long id) {
//		
//		return add(atendenteService.findOne(id));
//	}
	
	@DeleteMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") long id) {
		atendenteService.deleteById(id);
		return findAll();
	}
	
	
	
}
