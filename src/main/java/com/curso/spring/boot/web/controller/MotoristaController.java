package com.curso.spring.boot.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.spring.boot.web.model.MotoristaModel;
import com.curso.spring.boot.web.repository.MotoristaRepository;
import com.curso.spring.boot.web.service.MotoristaService;

@Controller
public class MotoristaController {

	@Autowired
	MotoristaService motoristaservice;
	
	@RequestMapping(value="/cadastrarmotorista", method=RequestMethod.GET)
	public String motorista() {
		return "motorista/motorista";
	}
	
	@PostMapping("/cadastrarmotorista" )
		public String motorista(@Validated MotoristaModel motorista, BindingResult result, RedirectAttributes attributes) {
			if(result.hasErrors()) {
				attributes.addFlashAttribute("mensagem", "verifique os campos");
				return "redirect:/cadastrarmotorista";
			}
		motoristaservice.cadastrarmotorista(motorista);
		attributes.addFlashAttribute("mensagem", "cadastrado com sucesso");
		return "redirect:/cadastrarmotorista";
	}
	
	@RequestMapping(path={"/listarmotorista", "/searchmotorista"})
	public String listarmotorista(Model model,  String keyword) {
		if(keyword!=null){
			List<MotoristaModel> motorista= motoristaservice.searchmotorista(keyword);
			model.addAttribute("motorista", motorista);
		}else {
			List<MotoristaModel>motorista= motoristaservice.listarmostoristas();
			model.addAttribute("motorista", motorista);}
			return "motorista/listarmotorista";
	}
	
	@GetMapping("Cod_Motorista/{cod_motorista}")
	public ModelAndView detalhesmotorista(@RequestParam ("cod_motorista") Long codigo_motorista ) {
		ModelAndView mv = new ModelAndView("motorista/detalhesmotorista");
		mv.addObject("motorista",motoristaservice.listarporcodigo(codigo_motorista));
		return mv;	
	}
	
	@GetMapping("/editmotorista/{cod_motorista}")
	public String showupdateform(Model model, @PathVariable("cod_motorista") Long cod_motorista){
		MotoristaModel motorista= motoristaservice.listarporcodigo(cod_motorista);
		model.addAttribute("motorista", motorista);
		return "motorista/updatemotorista";	
		}
	
	@PostMapping("/updatemotorista")
	public String updatemotorista(MotoristaModel motoristad, @PathVariable("cod_motorista") Long cod_motorista) {
	Optional <MotoristaModel> motorista= Optional.ofNullable(motoristaservice.listarporcodigo(cod_motorista));
	motorista.get().setAnonascimento(motoristad.getAnonascimento());
	motorista.get().setApelido(motoristad.getApelido());
	motorista.get().setBairro(motoristad.getBairro());
	motorista.get().setCidade(motoristad.getCidade());
	motorista.get().setEmail(motoristad.getEmail());
	motorista.get().setNivelcarta(motoristad.getNivelcarta());
	motorista.get().setNome(motoristad.getNome());
	motorista.get().setProvincia(motoristad.getProvincia());
	motorista.get().setNrcarta(motoristad.getNrcarta());
	motoristaservice.cadastrarmotorista(motorista.get());
	return "redirect:/listarmotorista";
	}
	
	@RequestMapping("/deletemotorista/{cod_motorista}")
	public String deletetransporte(@PathVariable("cod_motorista") Long cod_motorista) {
		MotoristaModel motorista= motoristaservice.listarporcodigo(cod_motorista);
		motoristaservice.deletemotorista(motorista, cod_motorista);
		return "redirect:/listarmotorista";
	}
}
