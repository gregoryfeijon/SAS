package br.com.sas.controller;

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

import br.com.sas.model.Agendamento;
import br.com.sas.service.AgendamentoService;
import br.com.sas.service.MedicoService;
import br.com.sas.service.PacienteService;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;

	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private MedicoService medicoService;
	
	
	@GetMapping("/cadastrarAgendamento")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("agendamentos/agendamento-de-consulta");
		Agendamento agendamento = new Agendamento();
		mv.addObject("agendamento", agendamento);
		mv.addObject("pacientes", pacienteService.findAll());
		mv.addObject("medicos", medicoService.findAll());
		
		return mv;
	}

	// Método que serve para salvar um cadastro e/ou editar
	@PostMapping("/cadastrarEditarAgendamento")
	public ModelAndView save(@Valid Agendamento agendamento, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("agendamentos/agendamento-de-consulta");
		if (result.hasErrors()) {
//			ModelAndView mv = new ModelAndView("agendamentos/agendamento-de-consulta");
			mv.addObject("pacientes", pacienteService.findAll());
			mv.addObject("medicos", medicoService.findAll());
			// Passando o mesmo obj recebido, para manter os dados informados, no formulario
			mv.addObject("agendamento", agendamento);
			mv.addObject("mensagemErro", agendamentoService.getMensagensErros(result));
	
			return mv;
		} 
		mv.setViewName("redirect:/agendamento/cadastrarAgendamento");
		agendamentoService.save(agendamento);
		attributes.addFlashAttribute("mensagemSucesso", "Agendamento alterado/cadastrado com sucesso!");
		return mv;
	}

	// Método que irá carregar na tela de cadastro, os valores cadastrados de um agendamento (para poder editar)
	@GetMapping("/editar/{id}")
	public ModelAndView edit(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("agendamentos/agendamento-de-consulta");
		Agendamento agendamento = agendamentoService.findOne(id).get();
		mv.addObject("agendamento", agendamento);
		mv.addObject("pacientes", pacienteService.findAll());
		mv.addObject("medicos", medicoService.findAll());
		return mv;
	}

	// Método que irá carregar todos os agendamentos, na tabela
	@GetMapping("/consultar")
	public ModelAndView findAll(Model model, @RequestParam(defaultValue = "0") int page) {
		ModelAndView mv = new ModelAndView("agendamentos/agenda-de-consulta");
		mv.addObject("listAgendamentos", agendamentoService.findAll(PageRequest.of(page, 5)));
		model.addAttribute("paginaAtual", page);
		return mv;
	}

	@DeleteMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable long id, RedirectAttributes attributes) {
		agendamentoService.deleteById(id);
		attributes.addFlashAttribute("mensagemSucesso", "Agendamento deletado com sucesso!");
		return new ModelAndView("redirect:/agendamento/consultar");
	}

}
