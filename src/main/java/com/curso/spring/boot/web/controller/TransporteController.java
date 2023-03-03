package com.curso.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.spring.boot.web.model.AssociacaoModel;
import com.curso.spring.boot.web.model.MotoristaModel;
import com.curso.spring.boot.web.model.TransporteModel;
import com.curso.spring.boot.web.model.ViagemModel;
import com.curso.spring.boot.web.model.ViajanteModel;
import com.curso.spring.boot.web.service.AssociacaoService;
import com.curso.spring.boot.web.service.MotoristaService;
import com.curso.spring.boot.web.service.TransporteService;

@Controller
public class TransporteController {

	@Autowired
	TransporteService transporteservice;
	AssociacaoService associacaoservice;
	MotoristaService motoristaservice;
	
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
	
	@RequestMapping( value="/detalhestransporte", method=RequestMethod.POST)
	public String viagemviajante(@RequestParam("cod_transporte") Long cod_transporte, @ModelAttribute MotoristaModel motorista, @ModelAttribute AssociacaoModel associacao ) {
		
		associacao= associacaoservice.listarporcodigo(associacao.getCodassociacao());
		motorista= motoristaservice.listarporcodigo(motorista.getCodigo());
		TransporteModel transporte =transporteservice.listarporcodigo(cod_transporte);
		
		
		viajante.getViagem().add(viagem);
		viajanteservice.salvarViajante(viajante);
		return "redirect:detalhesviajante/{cod_viajante}";
		
		
		
	
	
}
