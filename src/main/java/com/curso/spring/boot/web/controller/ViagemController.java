package com.curso.spring.boot.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	 ViagemService viagemservice;
	@Autowired
	 ViajanteService viajanteservice;
	@Autowired
	 TransporteService transporteservice;

	
	@RequestMapping(value="/viagem", method=RequestMethod.GET)
	public ModelAndView viagem() {
		ModelAndView mv= new ModelAndView("viagem/viagem");
		mv.addObject("viagem", new ViagemModel());
		mv.addObject("viagens", viagemservice.listarViagens());
		mv.addObject("associacoes", viagemservice.listarViagens());
		mv.addObject("transportes", transporteservice.listartransporte() );
		return mv;
	}
	
	@RequestMapping(value="/salvarviagem", method=RequestMethod.POST)
	public String viagem(@ModelAttribute("viagem")ViagemModel viagem) {
		viagemservice.salvarViagem(viagem);
		return "redirect:/viagem";
	}
	
	 @RequestMapping(path = {"/listarviagem","/search"})
	 public String listarviagem(Model model, String keyword) {
	  if(keyword!=null) {
	   List<ViagemModel> viagem = viagemservice.getByKeyword(keyword);
	   model.addAttribute("viagem",viagem);
	  }else {
	  List<ViagemModel> viagem = viagemservice.listarViagens();
	  model.addAttribute("viagem", viagem);}
	  return "viagem/listaviagem";
	 }
	
	@RequestMapping("Cod_viagem/{cod_viagem}")
	public ModelAndView detalhesViagem(@PathVariable ("cod_viagem") Long cod_viagem) {
		ModelAndView mv= new ModelAndView("viagem/detalhesViagem");
		mv.addObject("viagem", viagemservice.listarporCodigo(cod_viagem));
		return mv;
	}
	
	@GetMapping("/edit/{cod_viagem}")
	public String showUpdateForm(@PathVariable("cod_viagem") long cod_viagem, Model model) {
	    ViagemModel viagem = viagemservice.listarporCodigo(cod_viagem);
	    
	    model.addAttribute("viagem", viagem);
	    return "viagem/updateviagem";
	}
	
	@PostMapping("/update/{cod_viagem}")
	public String udpateviagem(@PathVariable ("cod_viagem") Long cod_viagem, ViagemModel viagemd) {
		Optional<ViagemModel> viagem= Optional.ofNullable(viagemservice.listarporCodigo(cod_viagem));
		viagem.get().setDestino_viagem(viagemd.getDestino_viagem());
		viagem.get().setPrev_chegada(viagemd.getDestino_viagem());
		viagem.get().setSaida(viagemd.getSaida());
		viagemservice.salvarViagem(viagem.get());
		return"redirect:/listarviagem";
	}
	
	@GetMapping("/delete/{cod_viagem}")
	public String deleteviagem(@PathVariable("cod_viagem") long cod_viagem, Model model) {
		ViagemModel viagem= viagemservice.listarporCodigo(cod_viagem);
	      viagemservice.apagarviagem(cod_viagem , viagem);
	    return "redirect:/listarviagem";
	}
	

	
}
