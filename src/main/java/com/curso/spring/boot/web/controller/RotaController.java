package com.curso.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.spring.boot.web.model.RotaModel;
import com.curso.spring.boot.web.service.RotaService;

@Controller
public class RotaController {
	
	@Autowired
	RotaService rotaservice;
	
	@GetMapping("/rota")
	public String rota() {
		return "rota/rota";
		
	}
	
	@PostMapping("/rota")
	public String salvarrota(RotaModel rota, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "verifique os campos");
			return "redirect:/rota";
			}
		rotaservice.salvarrota(rota);
		attributes.addFlashAttribute("mensagem", "Dados cadastrados com sucesso");
		return"redirect:/rota";
	}
	
	@GetMapping("/listarota")
	public ModelAndView listarrota() {
		ModelAndView mv= new ModelAndView("rota/listarotas");
		mv.addObject("rota",rotaservice.listarotas());
		return mv ;	
	}
	
	@GetMapping("/listarporcodigo{cod_rota}")
	public ModelAndView detalhesrota(Long cod_rota) {
		ModelAndView mv= new ModelAndView("rota/detalhesrota");
		mv.addObject("rota",rotaservice.listarporcodigo(cod_rota));
		return mv;
	}
	
	

}
