package br.com.sas.controller;

import java.util.Arrays;
	
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sas.enums.Estado;
import br.com.sas.model.Paciente;
import br.com.sas.service.PacienteService;
import br.com.sas.service.EnderecoService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	@Autowired 
	private EnderecoService enderecoService;
	
	@GetMapping("/cadastrarPaciente")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("cadastros/cadastro-paciente");
		Paciente paciente = new Paciente();
		mv.addObject("paciente",paciente);
		mv.addObject("estados", Arrays.asList(Estado.values()));
		
		return mv;
	}
	
	// Método que serve para salvar um cadastro, e ou editar
	@PostMapping("/cadastrarEditarPaciente")
	public ModelAndView save(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			ModelAndView mv = new ModelAndView("cadastros/cadastro-paciente");
			mv.addObject("estados", Arrays.asList(Estado.values()));
			// Passando o mesmo obj recebido, para manter os dados informados, no formulario
			mv.addObject("paciente", paciente);
			mv.addObject("mensagemErro", pacienteService.getMensagensErros(result));
			
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/paciente/cadastrarPaciente");
		enderecoService.save(paciente.getEndereco());
		pacienteService.save(paciente);
		attributes.addFlashAttribute("mensagemSucesso", "Paciente alterado/cadastrado com sucesso!");
		
		return mv;
	}
	
	// Método que irá carregar na tela de cadastro, os valores cadastrados de um paciente (para poder editar)
	@GetMapping("/editar/{id}")
	public ModelAndView edit(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("cadastros/cadastro-paciente");
		Paciente paciente = pacienteService.findOne(id).get();
		mv.addObject("paciente",paciente);
		mv.addObject("estados", Arrays.asList(Estado.values()));
		return mv;
	}
	
	// Método que irá carregar todos os atendentes, na tabela
	@GetMapping("/consultar")
	public ModelAndView findAll(Model model, @RequestParam(defaultValue="0") int page) {
		ModelAndView mv = new ModelAndView("consultas/consultar-paciente");
		mv.addObject("listPacientes", pacienteService.findAll(PageRequest.of(page, 5)));
		model.addAttribute("paginaAtual",page);
		return mv;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") long id, RedirectAttributes attributes) {
		pacienteService.deleteById(id);
		attributes.addFlashAttribute("mensagemSucesso", "Paciente deletado com sucesso!");
		return new ModelAndView("redirect:/paciente/consultar");
	}
	
	
	
}
