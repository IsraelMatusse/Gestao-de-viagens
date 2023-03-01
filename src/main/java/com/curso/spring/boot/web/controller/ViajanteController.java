package com.curso.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.spring.boot.web.model.ViagemModel;
import com.curso.spring.boot.web.model.ViajanteModel;
import com.curso.spring.boot.web.service.ViagemService;
import com.curso.spring.boot.web.service.ViajanteService;

@Controller
public class ViajanteController {
	
	@Autowired
	private ViajanteService viajanteservice;
	@Autowired
	private ViagemService viagemservice;
	
	@GetMapping("/listarviajante")
	public ModelAndView viajante() {
		ModelAndView mv = new ModelAndView("viajante/listarviajante");
		mv.addObject("viajante", viajanteservice.listarViajantes());
		return mv;
	}
	
	@GetMapping("/viajante")
	public String cadastrarviajante() {
		return "viajante/viajante";
	}
	
	@PostMapping("/viajante")
	public String cadastarviajante(ViajanteModel viajante) {
		viajanteservice.salvarViajante(viajante);
		return"redirect:/viajante";
	}
	
	@GetMapping("detalhesviajante/{cod_viajante}")
	public ModelAndView detalhesviajante(@PathVariable("cod_viajante") Long cod_viajante, @ModelAttribute ViajanteModel viajante) {
		ModelAndView mv= new ModelAndView("viajante/detalhesviajante");
		mv.addObject("viajante", viajanteservice.ListarporCodigo(cod_viajante));
		mv.addObject("viagem", viagemservice.listarViagens());
		return mv;
	}
	
	@RequestMapping( value="associarviajante", method=RequestMethod.POST)
	public String viagemviajante(@RequestParam("cod_viajante") Long cod_viajante, @ModelAttribute ViagemModel viagem ) {
		
		ViajanteModel viajante=viajanteservice.ListarporCodigo(cod_viajante);
		viagem=viagemservice.listarporCodigo(viagem.getCodviagem());
		viajante.getViagem().add(viagem);
		viajanteservice.salvarViajante(viajante);
		return "redirect:detalhesviajante/{cod_viajante}";
		
		
		
	}
}
