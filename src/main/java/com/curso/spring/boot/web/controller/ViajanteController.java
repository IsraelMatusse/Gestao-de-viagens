package com.curso.spring.boot.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.spring.boot.web.model.ViagemModel;
import com.curso.spring.boot.web.model.ViajanteModel;
import com.curso.spring.boot.web.service.ViagemService;
import com.curso.spring.boot.web.service.ViajanteService;



@Controller
public class ViajanteController {
	
	@Autowired
 ViajanteService viajanteservice;
	@Autowired
 ViagemService viagemservice;
	
	 @RequestMapping(path = {"/listarviajante","/searchviajante"})
	 public String listarviajante(Model model, String keyword) {
	  if(keyword!=null) {
	   List<ViajanteModel> viajante = viajanteservice.getByKeyword(keyword);
	   model.addAttribute("viajante",viajante);
	  }else {
	  List<ViajanteModel> viajante = viajanteservice.listarViajantes();
	  model.addAttribute("viajante", viajante);}
	  return "viajante/listarviajante";
	 }
	
	
	@GetMapping("/viajante")
	public String cadastrarviajante() {
		return "viajante/viajante";
	}
	
	@PostMapping("/viajante")
	public String cadastarviajante(ViajanteModel viajante, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "verifique os campos");
			return "redirect:/rota";}
		viajanteservice.salvarViajante(viajante);
		attributes.addFlashAttribute("mensagem", "Dados cadastrados com sucesso");
		return"redirect:/viajante";
	}
	
	@GetMapping("/detalhesviajante/{cod_viajante}")
	public ModelAndView detalhesviajante(@PathVariable(name="cod_viajante") Long cod_viajante) {
		ViajanteModel viajante= viajanteservice.ListarporCodigo(cod_viajante);
		ModelAndView mv= new ModelAndView("viajante/detalhesviajante");
		mv.addObject("viajante", viajante);
		List <ViagemModel> viagemnaoassociada=  viagemservice.listarViagens();
		viagemnaoassociada.removeAll(viajante.getViagem());
		mv.addObject("viagem", viagemnaoassociada);
		return mv;
	}


	@RequestMapping( value="/associarviajante", method=RequestMethod.POST)
	public String viagemviajante( ViagemModel viagem, @RequestParam("cod_viajante") Long cod_viajante ) {
		ViajanteModel viajante=viajanteservice.ListarporCodigo(cod_viajante);
		viagem=viagemservice.listarporCodigo(viagem.getCodviagem());
		viajante.getViagem().add(viagem);
		viajanteservice.salvarViajante(viajante);
		return "redirect:/detalhesviajante/"+ cod_viajante;
	}
		
	
	@GetMapping("/editviajante/{cod_viajante}")
	public String showUpdateForm(@PathVariable("cod_viajante") long cod_viajante, Model model) {
	    ViajanteModel viajante = viajanteservice.ListarporCodigo(cod_viajante);
	    model.addAttribute("viajante", viajante);
	    return "viajante/updateviajante";
	}
	
	@PostMapping("/updateviajante/{cod_viajante}")
	public String udpateviajante(@PathVariable ("cod_viajante") Long cod_viajante, ViajanteModel viajanted) {
		Optional<ViajanteModel> viajante= Optional.ofNullable(viajanteservice.ListarporCodigo(cod_viajante));
		viajante.get().setAnonascimento(viajanted.getAnonascimento());
		viajante.get().setApelido(viajanted.getApelido());
		viajante.get().setBairro(viajanted.getBairro());
		viajante.get().setCidade(viajanted.getCidade());
		viajante.get().setEmail(viajanted.getEmail());
		viajante.get().setNome(viajanted.getNome());
		viajante.get().setProvincia(viajanted.getProvincia());
		viajanteservice.salvarViajante(viajante.get());
		return"redirect:/listarviajante";
	}
	
	@GetMapping("/deleteviajante/{cod_viajante}")
	public String deleteviajante(@PathVariable("cod_viajante") long cod_viajante, Model model) {
		ViajanteModel viajante= viajanteservice.ListarporCodigo(cod_viajante);
	     viajanteservice.apagarviajante(cod_viajante, viajante);
	    return "redirect:/listarviajante";
	}
		
		
		
	}

