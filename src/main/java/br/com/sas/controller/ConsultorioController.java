//package br.com.sas.controller;
//
//import java.util.Arrays;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import br.com.sas.enums.Estado;
//import br.com.sas.model.Atendente;
//import br.com.sas.service.AtendenteService;
//import br.com.sas.service.EnderecoService;
//
//@Controller
//@RequestMapping("/atendente")
//public class ConsultorioController {
//
//	@Autowired
//	private AtendenteService atendenteService;
//
//	@Autowired
//	private EnderecoService enderecoService;
//
//	@GetMapping("/cadastrarAtendente")
//	public ModelAndView form() {
//		ModelAndView mv = new ModelAndView("cadastros/cadastro-atendente");
//		Atendente atendente = new Atendente();
//		mv.addObject("atendente", atendente);
//		mv.addObject("estados", Arrays.asList(Estado.values()));
//
//		return mv;
//	}
//
//	// Método que serve para salvar um cadastro e/ou editar
//	@PostMapping("/cadastrarEditarAtendente")
//	public ModelAndView save(@Valid Atendente atendente, BindingResult result, RedirectAttributes attributes) {
//		if (result.hasErrors()) {
//			ModelAndView mv = new ModelAndView("cadastros/cadastro-atendente");
//			mv.addObject("estados", Arrays.asList(Estado.values()));
//			// Passando o mesmo obj recebido, para manter os dados informados, no formulario
//			mv.addObject("atendente", atendente);
//			mv.addObject("mensagemErro", atendenteService.getMensagensErros(result));
//
//			return mv;
//		}
//		ModelAndView mv = new ModelAndView("redirect:/atendente/cadastrarAtendente");
//		enderecoService.save(atendente.getEndereco());
//		atendenteService.save(atendente);
//		attributes.addFlashAttribute("mensagemSucesso", "Atendente alterado/cadastrado com sucesso!");
//
//		return mv;
//	}
//
//	// Método que irá carregar na tela de cadastro, os valores cadastrados de um atendente (para poder editar)
//	@GetMapping("/editar/{id}")
//	public ModelAndView edit(@PathVariable long id) {
//		ModelAndView mv = new ModelAndView("cadastros/cadastro-atendente");
//		Atendente atendente = atendenteService.findOne(id).get();
//		mv.addObject("atendente", atendente);
//		mv.addObject("estados", Arrays.asList(Estado.values()));
//		return mv;
//	}
//
//	// Método que irá carregar todos os atendentes, na tabela
//	@GetMapping("/consultar")
//	public ModelAndView findAll(Model model, @RequestParam(defaultValue = "0") int page) {
//		ModelAndView mv = new ModelAndView("consultas/consultar-atendentes");
//		mv.addObject("listAtendentes", atendenteService.findAll(PageRequest.of(page, 5)));
//		model.addAttribute("paginaAtual", page);
//		return mv;
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public ModelAndView delete(@PathVariable("id") long id, RedirectAttributes attributes) {
//		atendenteService.deleteById(id);
//		attributes.addFlashAttribute("mensagemSucesso", "Atendente deletado com sucesso!");
//		return new ModelAndView("redirect:/atendente/consultar");
//	}
//
//}
