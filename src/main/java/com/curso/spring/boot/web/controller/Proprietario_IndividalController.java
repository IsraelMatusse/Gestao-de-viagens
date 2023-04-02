package com.curso.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.spring.boot.web.model.Proprietario_individualModel;
import com.curso.spring.boot.web.repository.ProprietarioIndividualRepository;

@Controller
public class Proprietario_IndividalController {
	
	@Autowired
	ProprietarioIndividualRepository pir;
	
	@GetMapping("/proprietarioindividual")
	public String proprietrioindividual() {
		return "/proprietario/proprietario_individual/proprietarioindividual";
	}
	
	@PostMapping("proprietarioindividual")
	public String cadastroindividual(Proprietario_individualModel proprietarioindividual, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "verifique os campos");
			return "redirect:/proprietarioindividual";
		}
			pir.save(proprietarioindividual);
			attributes.addFlashAttribute("mensagem", "Cadastrado com sucesso");
		return"redirect:/proprietarioindividual";
	}
}
