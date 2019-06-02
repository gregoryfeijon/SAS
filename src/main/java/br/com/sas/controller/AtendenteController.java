package br.com.sas.controller;

import java.util.Arrays;
import java.util.List;

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

import br.com.sas.enums.Estado;
import br.com.sas.model.Atendente;
import br.com.sas.service.AtendenteService;
import br.com.sas.service.EnderecoService;

@Controller
@RequestMapping("/atendente")
public class AtendenteController {

	@Autowired
	private AtendenteService atendenteService;
	
	@Autowired 
	private EnderecoService enderecoService;
	
	@GetMapping("/cadastrarAtendente")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("cadastros/cadastro-atendente");
		Atendente atendente = new Atendente();
		mv.addObject("atendente",atendente);
		mv.addObject("estados", Arrays.asList(Estado.values()));
		
		return mv;
	}
	
	
	@PostMapping("/cadastrarAtendente")
	public ModelAndView save(@Valid Atendente atendente, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			ModelAndView mv = new ModelAndView("cadastros/cadastro-atendente");
			mv.addObject("estados", Arrays.asList(Estado.values()));
			// Passando o mesmo obj recebido, para manter os dados informados, no formulario
			mv.addObject("atendente", atendente);
			mv.addObject("mensagem", atendenteService.getMensagensErros(result));
			
			return mv;
		}
		
		ModelAndView mv = new ModelAndView("redirect:/atendente/cadastrarAtendente");
		enderecoService.save(atendente.getEndereco());
		atendenteService.save(atendente);
		attributes.addFlashAttribute("mensagem", "Atendente cadastrado com sucesso!");
		
		return mv;
	}
	
	
	@GetMapping("/consultar")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("consultas/consultar-atendentes");
		
		List<Atendente> listAtendentes = atendenteService.findAll();
		mv.addObject("listAtendentes", listAtendentes);
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView edit(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("cadastros/cadastro-atendente");
		Atendente atendente = atendenteService.findOne(id).get();
		mv.addObject("atendente",atendente);
		mv.addObject("estados", Arrays.asList(Estado.values()));
		return mv;
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Atendente atendente, BindingResult result, RedirectAttributes attributes){
//		if(result.hasErrors()){
//			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
//			return "redirect:/cadastrarEvento";
//		}
//		enderecoService.findOne(atendente.getEndereco().getId());
		
		enderecoService.save(enderecoService.findOne(atendente.getEndereco().getId()).get());
		
		atendenteService.save(atendenteService.findOne(atendente.getId()).get());
		attributes.addFlashAttribute("mensagem", "Atendente cadastrado com sucesso!");
		
		return "redirect:/atendente/cadastrarAtendente";
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") long id) {
		atendenteService.deleteById(id);
		return findAll();
	}
	
	
	
}
