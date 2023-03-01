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
	
	@PostMapping("/transporte")
	public String cadastrartransporte(TransporteModel transporte) {
		 transporteservice.cadastrartransporte(transporte);
		 return "redirect:/transporte/transporte";
	}
	
	@GetMapping("/listartransporte")
	public ModelAndView listartransporte(){
		ModelAndView mv= new ModelAndView();
		mv.addObject("transporte", transporteservice.listarmotorista());
		return mv;
	}
	
	@GetMapping("/detalhestransporte")
	public ModelAndView detalhestrnasporte(Long cod_transporte) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("Transporte", transporteservice.listarporcodigo(cod_transporte));
		return mv;
	}
	
	
	
	
}
