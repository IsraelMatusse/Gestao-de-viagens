package com.curso.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.curso.spring.boot.web.model.AssociacaoModel;
import com.curso.spring.boot.web.repository.AssociacaoRepository;
import com.curso.spring.boot.web.service.AssociacaoService;

@Controller
public class AssociacaoController {

	@Autowired
	
	AssociacaoService associacaoservice;
	@RequestMapping(value="/cadastrarAssociacao", method= RequestMethod.GET )
	public String cadastrarAssociacao() {
		return "associacao/associacao";
	}
	
	@RequestMapping(value="/cadastrarAssociacao", method=RequestMethod.POST)
	 public String cadastrarViagem( AssociacaoModel associacao) {
		associacaoservice.cadastrarassociacao(associacao);
		 return "redirect:/cadastrarAssociacao";
	 }
	
	@RequestMapping(value="/listarAssociacao", method=RequestMethod.GET)
	public ModelAndView listarAssociacao() {
		ModelAndView mv= new ModelAndView("associacao/ListarAssociacao");
		
		mv.addObject("associacoes", associacaoservice.listarassociacao());
		return mv;
	}
	@RequestMapping("Cod_Associacao/{cod_associacao}")
	public ModelAndView detalhesAssociacao( @PathVariable("cod_associacao") Long cod_associacao) {	
		ModelAndView mv= new ModelAndView("associacao/detalhesAssociacao");
		mv.addObject("associacao", associacaoservice.listarporcodigo(cod_associacao));
		return mv;
	}
}
