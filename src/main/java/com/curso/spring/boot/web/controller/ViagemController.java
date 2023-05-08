package com.curso.spring.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.curso.spring.boot.web.model.ViagemModel;
import com.curso.spring.boot.web.repository.RankingDestino;
import com.curso.spring.boot.web.service.AssociacaoService;
import com.curso.spring.boot.web.service.TransporteService;
import com.curso.spring.boot.web.service.ViagemService;
import com.curso.spring.boot.web.service.ViajanteService;
import com.curso.spring.boot.web.DTO.ViagemDTO.ViagemActualizarDTO;

@Controller
public class ViagemController  {

	@Autowired
	 ViagemService viagemservice;
	@Autowired
	 ViajanteService viajanteservice;
	@Autowired
	 TransporteService transporteservice;
	
	@Autowired
	AssociacaoService associacaoservice;

	
	@RequestMapping(value="/viagem", method=RequestMethod.GET)
	public ModelAndView viagem() {
		ModelAndView mv= new ModelAndView("viagem/viagem");
		mv.addObject("viagem", new ViagemModel());
		mv.addObject("viagens", viagemservice.listarViagens());
		mv.addObject("associacoes", associacaoservice.listarassociacao());
		mv.addObject("transportes", transporteservice.listartransporte() );
		return mv;
	}
	
	@PostMapping(value="/salvarviagem")
	public String viagem(@ModelAttribute("viagem")ViagemModel viagem) {
		
		viagemservice.salvarViagem(viagem);
		return "redirect:/viagem";
	}
	
	 @RequestMapping(path = {"/listarviagem","/searchviagem"})
	 public String listarviagem(Model model, String keyword) {
	  if(keyword!=null) {
	   List<ViagemModel> viagem = viagemservice.getByKeyword(keyword);
	   model.addAttribute("viagem",viagem);
	  }else {
	  List<ViagemModel> viagem = viagemservice.listarViagens();
	  model.addAttribute("viagem", viagem);}
	  return "viagem/listarviagem";
	 }
	
	@RequestMapping("cod_viagem/{cod_viagem}")
	public ModelAndView detalhesViagem(@PathVariable ("cod_viagem") Long cod_viagem) {
		ModelAndView mv= new ModelAndView("viagem/detalhesViagem");
		mv.addObject("viagem", viagemservice.listarporCodigo(cod_viagem));
		return mv;
	}
	
	@GetMapping("/editviagem/{cod_viagem}")
	public String showUpdateForm(@PathVariable("cod_viagem") long cod_viagem, Model model) {
	    ViagemModel viagem = viagemservice.listarporCodigo(cod_viagem);
	    
	    model.addAttribute("viagem", viagem);
	    return "viagem/updateviagem";
	}
	
	/*@PostMapping("/updateviagem/{cod_viagem}")
	public String udpateviagem(@PathVariable ("cod_viagem") Long cod_viagem, @RequestBody ViagemActualizarDTO viagemActualizarDTO) {
		ViagemModel viagem= viagemservice.listarporCodigo(viagemActualizarDTO.getCodviagem());
		viagemservice.updateCandidato(viagemActualizarDTO);
		return"redirect:/listarviagem";
	}

	 */
	
	@GetMapping("/deleteviagem/{cod_viagem}")
	public String deleteviagem(@PathVariable("cod_viagem") long cod_viagem, Model model) {
		ViagemModel viagem= viagemservice.listarporCodigo(cod_viagem);
	      viagemservice.apagarviagem(cod_viagem , viagem);
	    return "redirect:/listarviagem";
	}
	
	/* @RequestMapping(path = {"/listarviagens","/findbydestino"})
	 public String findbydestino(Model model, String destino_viagem) {
	  if(destino_viagem!=null) {
	   List<ViajantesDestino> viajantesdestino = viagemservice.viajantesdestino(destino_viagem);
	   model.addAttribute("viajantesdestino",viajantesdestino);
	  }else {
	  List<ViagemModel> viagem = viagemservice.listarViagens();
	  model.addAttribute("viagem", viagem);}
	  return "Estatisticas/viagem";
	 }
	 */
	/* @RequestMapping(path = {"/listarviagens","/findByChave"})
	 public String findbychave(Model model, String chaveviagem) {
	  if(chaveviagem!=null) {
	   List<DestinoChave> destinoporchave = viagemservice.viajantesporchave(chaveviagem);
	   model.addAttribute("destinoporchave", destinoporchave);
	  }else {
	  List<ViagemModel> viagem = viagemservice.listarViagens();
	  model.addAttribute("viagem", viagem);}
	  return "Estatisticas/viagem";
	 }
*/
	 
	 @RequestMapping("/rankingdestino")
	 public String finddestino(Model model) {
	   List<RankingDestino> rankingdestino = viagemservice.rankingdestino();
	   model.addAttribute("rankingdestino", rankingdestino);
	  return "Estatisticas/viagem";
	 }

	
}
