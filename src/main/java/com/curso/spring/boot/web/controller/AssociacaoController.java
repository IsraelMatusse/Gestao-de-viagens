package com.curso.spring.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.spring.boot.web.model.AssociacaoModel;
import com.curso.spring.boot.web.model.RotaModel;
import com.curso.spring.boot.web.repository.AssociacaoRepository;
import com.curso.spring.boot.web.service.AssociacaoService;
import com.curso.spring.boot.web.service.RotaService;

@Controller
public class AssociacaoController {

	@Autowired
	AssociacaoService associacaoservice;
	@Autowired
	RotaService rotaservice;
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
	@GetMapping("/detalhesassociacao/{cod_associacao}")
	public ModelAndView detalhesAssociacao( @PathVariable("cod_associacao") Long cod_associacao) {	
		ModelAndView mv= new ModelAndView("associacao/detalhesAssociacao");
		AssociacaoModel associacao=associacaoservice.listarporcodigo(cod_associacao);
		mv.addObject("associacao", associacao);
		List<RotaModel> rotanaoassociada= rotaservice.listarotas();
		rotanaoassociada.removeAll(associacao.getRotas());
		mv.addObject("rota", rotanaoassociada);
		return mv;
	}
	
	@PostMapping("/associarrota")
	public String associarrota(@ModelAttribute("rota") RotaModel rota, @RequestParam("cod_associacao") Long cod_associacao) {
		AssociacaoModel associacao= associacaoservice.listarporcodigo(cod_associacao);
		rota=rotaservice.listarporcodigo(rota.getCodrota());
		associacao.getRotas().add(rota);
		associacaoservice.cadastrarassociacao(associacao);
		return "redirect: /detalhesassociacao/"+cod_associacao;
	}
}
