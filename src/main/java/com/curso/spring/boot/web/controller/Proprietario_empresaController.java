package com.curso.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.spring.boot.web.model.Proprietario_EmpresaModel;
import com.curso.spring.boot.web.repository.ProprietarioempresaRepository;

@Controller
public class Proprietario_empresaController {
	
	@Autowired
	ProprietarioempresaRepository per;
	
	@GetMapping("/proprietarioempresa")
	public String proprietarioempresa() {
		return "/proprietario/proprietario_empresa/proprietario_empresa";
	}
	
	@PostMapping("/proprietarioempresa")
	public String cadastrarProprietarioEmpresa(Proprietario_EmpresaModel propempresa, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "verifique os campos");
			return "redirect:/proprietarioempresa";
		}
		per.save(propempresa);
		attributes.addFlashAttribute("mensagem", "Cadastro efectuado com sucesso");
		return "redirect:/proprietarioempresa";
	}
	
	@GetMapping("/listarempresa")
	public ModelAndView listarempresa() {
		ModelAndView mv = new ModelAndView("proprietario/proprietario_empresa/listar_proprietario_empresa");
		Iterable <Proprietario_EmpresaModel > proprietarioempresa = per.findAll();
		mv.addObject("proprietarioempresa", proprietarioempresa);
		return mv;	
	}
	
	@GetMapping("/{codproprietario}")
	public ModelAndView detalhesempresa(@PathVariable ("codproprietario") Long codproprietario) {
		ModelAndView mv= new ModelAndView("proprietario/proprietario_empresa/detalhesempresa");
		Proprietario_EmpresaModel proprietarioempresa= per.findByCodproprietario(codproprietario);
		mv.addObject("proprietarioempresa", proprietarioempresa);
		return mv;
	}
}
