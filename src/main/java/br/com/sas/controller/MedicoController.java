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
import br.com.sas.model.Medico;
import br.com.sas.service.EnderecoService;
import br.com.sas.service.MedicoService;

@Controller
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping("/cadastrarMedico")
	public ModelAndView cadastrarMedicoForm() {
		ModelAndView mv = new ModelAndView("cadastros/cadastro-medico");
		Medico medico = new Medico();
		mv.addObject("medico", medico);
		mv.addObject("estados", Arrays.asList(Estado.values()));

		return mv;
	}

	@PostMapping("/cadastrarEditarMedico")
	public ModelAndView save(@Valid Medico medico, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("cadastros/cadastro-medico");
			mv.addObject("estados", Arrays.asList(Estado.values()));
			mv.addObject("medico", medico);
			mv.addObject("mensagemErro", medicoService.getMensagensErros(result));

			return mv;
		}

		ModelAndView mv = new ModelAndView("redirect:/medico/cadastrarMedico");
		enderecoService.save(medico.getEndereco());
		medicoService.save(medico);
		attributes.addFlashAttribute("mensagemSucesso", "Médico alterado/cadastrado com sucesso!");

		return mv;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView edit(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("cadastros/cadastro-medico");
		Medico[] medico = new Medico[1];
		medicoService.findOne(id).ifPresent(m -> medico[0] = m);
		//por mensagem de erro caso médico não exista
		mv.addObject("medico", medico[0]);
		mv.addObject("estados", Arrays.asList(Estado.values()));

		return mv;
	}

	@GetMapping("/consultar")
	public ModelAndView findAll(Model model, @RequestParam(defaultValue = "0") int page) {
		ModelAndView mv = new ModelAndView("consultas/consultar-medicos");
		mv.addObject("listMedicos", medicoService.findAll(PageRequest.of(page, 5)));
		model.addAttribute("paginaAtual", page);

		return mv;
	}

	@PostMapping("/consultar/nome")
	public ModelAndView findByNome(@RequestParam("nomeMedico") String nomeMedico, Model model, @RequestParam(defaultValue = "0") int page) {
		ModelAndView mv = new ModelAndView("consultas/consultar-medicos");
		mv.addObject("listMedicos", medicoService.findByNome(PageRequest.of(page, 5), nomeMedico));
		model.addAttribute("paginaAtual", page);
		return mv;
	}
	
	@DeleteMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable long id, RedirectAttributes attributes) {
		Medico[] medico = new Medico[1];
		medicoService.findOne(id).ifPresent(m -> medico[0] = m);
		try {
			if (medico[0] != null) {
				medicoService.delete(medico[0]);
				attributes.addFlashAttribute("mensagemSucesso", "Médico deletado com sucesso!");
			} else {
				attributes.addFlashAttribute("mensagemErro", "Médico especificado não existe!");
			}
		} catch (Exception e) {
			attributes.addFlashAttribute("mensagemErro","Esse Médico NÃO, pode ser deletado pois está atrelado a uma consulta!");
		}
		return new ModelAndView("redirect:/medico/consultar");
	}
}
