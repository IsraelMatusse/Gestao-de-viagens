package com.curso.spring.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	 @RequestMapping(path = {"/listarAssociacao","/search"})
	 public String listarassociacao(Model model, String keyword) {
	  if(keyword!=null) {
	   List<AssociacaoModel> associacao = associacaoservice.getByKeyword(keyword);
	   model.addAttribute("associacao", associacao);
	  }else {
	  List<AssociacaoModel> associacao = associacaoservice.listarassociacao();
	  model.addAttribute("associacao", associacao);}
	  return "associacao/listarAssociacao";
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
	
	/*
	@RequestMapping(path={"/listarAssociacao","/nomeassociacao"})
	public ModelAndView listarpornome(@PathVariable("nomeassociacao") String nomeassociacao) {
		ModelAndView mv= new ModelAndView("associacao/pesquisas");
		AssociacaoModel associacao =associacaoservice.listarpornome(nomeassociacao);
		mv.addObject("ässociacao", associacao);
		return mv;
	}
	
	@GetMapping("/listarpoemail")
	public AssociacaoModel listarporemail(@PathVariable("emailassociacao") String emailassociacao) {
	AssociacaoModel associacao= associacaoservice.listarporemail(emailassociacao);
	return associacao;
	}
	
	@RequestMapping("/apagarpornome")
	public void apagarpornome(@RequestParam("nomeassociacao") String nomeassociacao, AssociacaoModel associacao) {
		associacaoservice.apagarpornome(nomeassociacao, associacao);
	}
	
	@RequestMapping("/apagarporemail")
	public void apagarporemail(@RequestParam("emailassociacao") String emailassociacao, AssociacaoModel associacao) {
		associacaoservice.apagarporemail(emailassociacao, associacao);
	}
	*/
	
	@GetMapping("/edit/{cod_associacao}")
	public String showUpdateForm(@PathVariable("cod_associacao") long cod_associacao, Model model) {
	    AssociacaoModel associacao = associacaoservice.listarporcodigo(cod_associacao);
	    
	    model.addAttribute("associacao", associacao);
	    return "associacao/updateassociacao";
	}
	
	@PostMapping("/update/{cod_associacao}")
	public String updateassociacao(@PathVariable("cod_associacao") long cod_associacao, AssociacaoModel associacao, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        associacao.setCodassociacao(cod_associacao);
	        return "associacao/updateassociacao";
	    }
	        
	    associacaoservice.cadastrarassociacao(associacao);
	    return "redirect:associacao/listarAssociacao";
	}
	
	@GetMapping("/delete/{cod_associacao}")
	public String deleteassociacao(@PathVariable("cod_associacao") long cod_associacao, Model model) {
	   AssociacaoModel associacao= associacaoservice.listarporcodigo(cod_associacao);
	     
	      associacaoservice.apagarassociacao(cod_associacao , associacao);
	    return "associacao/listarAssociacao";
	}
}
