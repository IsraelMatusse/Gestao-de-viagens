package com.curso.spring.boot.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.spring.boot.web.model.ViagemModel;
import com.curso.spring.boot.web.model.ViajanteModel;
import com.curso.spring.boot.web.repository.ViagemRepository;
import com.curso.spring.boot.web.repository.ViajanteRepository;
import com.curso.spring.boot.web.service.TransporteService;
import com.curso.spring.boot.web.service.ViagemService;
import com.curso.spring.boot.web.service.ViajanteService;


@Controller
public class ViagemController  {

	@Autowired
	private ViagemService viagemservice;
	@Autowired
	private ViajanteService viajanteservice;
	@Autowired
	private TransporteService transporteservice;
	
	@RequestMapping(value="/cadastrarViagem", method=RequestMethod.GET)
	public ModelAndView viagem() {
		ModelAndView mv= new ModelAndView("viagem/viagem");
		mv.addObject("viagem", new ViagemModel());
		mv.addObject("viagem", viagemservice.listarViagens());
		mv.addObject("transportes", transporteservice.listartransporte() );
		return mv;
	}
	
	@RequestMapping(value="/cadastrarViagem", method=RequestMethod.POST)
	public String viagem(ViagemModel viagem) {
		viagemservice.salvarViagem(viagem);
		return "redirect:/cadastrarViagem";
	}
	
	@RequestMapping(value="/",  method=RequestMethod.GET)
	public ModelAndView ListarViagem() {
		ModelAndView mv= new ModelAndView("viagem/ListarViagem");
		mv.addObject("viagens", viagemservice.listarViagens());
		return mv;
	}
	
	@RequestMapping("Cod_viagem/{cod_viagem}")
	public ModelAndView detalhesViagem(@PathVariable ("cod_viagem") Long cod_viagem) {
		ModelAndView mv= new ModelAndView("viagem/detalhesViagem");
		mv.addObject("viagem", viagemservice.listarporCodigo(cod_viagem));
		return mv;
	}
	

	
}
