package com.curso.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.curso.spring.boot.web.model.TransporteModel;
import com.curso.spring.boot.web.service.TransporteService;

@Controller
public class TransporteController {

	@Autowired
	TransporteService transporteservice;
	
	@GetMapping("/transporte")
	public String transporte() {
		return "transporte/transporte";
	}
	
	
	@PostMapping("/transporte")
	public String cadastrartransporte(TransporteModel transporte) {
		 transporteservice.cadastrartransporte(transporte);
		 return "redirect:/transporte";
	}
	
	@GetMapping("/listartransporte")
	public ModelAndView listartransporte(){
		ModelAndView mv= new ModelAndView("transporte/listartransporte");
		mv.addObject("transporte", transporteservice.listartransporte());
		return mv;
	}
	
	@GetMapping("/detalhestransporte")
	public ModelAndView detalhestransporte(Long cod_transporte) {
		ModelAndView mv = new ModelAndView("transporte/detalhestransporte");
		mv.addObject("Transporte", transporteservice.listarporcodigo(cod_transporte));
		return mv;
	}
	
	
	
	
}
