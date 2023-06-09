package com.curso.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.spring.boot.web.model.CargaModel;
import com.curso.spring.boot.web.service.CargaService;

@Controller
public class CargaController {
	
	@Autowired
	CargaService cargaservice;
	
	@GetMapping("/carga")
	public String carga() {
		return "carga/carga";
	}
	
	@PostMapping("/carga")
	public String salvarvarga(@Validated CargaModel carga, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "verifique os campos");
			return "redirect:/carga";
		}
		cargaservice.salvarcarga(carga);
		attributes.addFlashAttribute("mensagem", "cadastrado com sucesso");
		return "redirect:/carga";
	}
	
	@GetMapping("/listacarga")
	public ModelAndView listacarga() {
		ModelAndView mv= new ModelAndView("carga/listacarga");
		mv.addObject("carga", cargaservice.listarcarga());
		return mv;
	}
	
	@GetMapping("/detalhescarga/{cod_carga}")
	public ModelAndView listaporcodigo(Long cod_carga) {
		ModelAndView mv= new ModelAndView("carga/detalhecarga");
		mv.addObject("carga", cargaservice.listarporcodigo(cod_carga));
		return mv;
	}
}
