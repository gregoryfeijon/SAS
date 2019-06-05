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

import br.com.sas.model.Consultorio;
import br.com.sas.service.ConsultorioService;
import br.com.sas.service.EnderecoService;
import br.com.sas.util.MetodosAuxiliares;
	
@Controller
@RequestMapping("/consultorio")
public class ConsultorioController {

	@Autowired
	private ConsultorioService consultorioService;

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping("/cadastrarConsultorio")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("cadastros/cadastro-consultorio");
		Consultorio consultorio = new Consultorio();
		mv.addObject("consultorio", consultorio);
		mv.addObject("estados", MetodosAuxiliares.getEstados());

		return mv;
	}

	// Método que serve para salvar um cadastro e/ou editar
	@PostMapping("/cadastrarEditarConsultorio")
	public ModelAndView save(@Valid Consultorio consultorio, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("cadastros/cadastro-consultorio");
			mv.addObject("estados", MetodosAuxiliares.getEstados());
			// Passando o mesmo obj recebido, para manter os dados informados, no formulario
			mv.addObject("consultorio", consultorio);
			mv.addObject("mensagemErro", consultorioService.getMensagensErros(result));

			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/consultorio/cadastrarConsultorio");
		enderecoService.save(consultorio.getEnderecoConsultorio());
		consultorioService.save(consultorio);
		attributes.addFlashAttribute("mensagemSucesso", "Consultorio alterado/cadastrado com sucesso!");

		return mv;
	}

	// Método que irá carregar na tela de cadastro, os valores cadastrados de um consultorio (para poder editar)
	@GetMapping("/editar/{id}")
	public ModelAndView edit(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("cadastros/cadastro-consultorio");
		Consultorio consultorio = consultorioService.findOne(id).get();
		mv.addObject("consultorio", consultorio);
		mv.addObject("estados", MetodosAuxiliares.getEstados());
		return mv;
	}

	// Método que irá carregar todos os consulltorios, na tabela
	@GetMapping("/consultar")
	public ModelAndView findAll(Model model, @RequestParam(defaultValue = "0") int page) {
		ModelAndView mv = new ModelAndView("consultas/consultar-consultorios");
		mv.addObject("listConsultorios", consultorioService.findAll(PageRequest.of(page, 5)));
		model.addAttribute("paginaAtual", page);
		return mv;
	}

	@DeleteMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") long id, RedirectAttributes attributes) {
		consultorioService.deleteById(id);
		attributes.addFlashAttribute("mensagemSucesso", "Consultório deletado com sucesso!");
		return new ModelAndView("redirect:/consultorio/consultar");
	}

}
