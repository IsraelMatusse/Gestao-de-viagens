package com.curso.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		public String motorista(MotoristaModel motorista) {
		motoristaservice.cadastrarmotorista(motorista);
		return "redirect:/cadastrarmotorista";
	}
	
	@GetMapping("/listarmotorista")
	public ModelAndView listarmotorista() {
		ModelAndView mv= new ModelAndView("motorista/listarmotorista");
		mv.addObject("motoristas", motoristaservice.listarmostoristas());
		return mv;
	}
	
	@GetMapping("Cod_Motorista/{cod_motorista}")
	public ModelAndView detalhesmotorista(@RequestParam ("cod_motorista") Long codigo_motorista ) {
		ModelAndView mv = new ModelAndView("motorista/detalhesmotorista");
		mv.addObject("motorista",motoristaservice.listarporcodigo(codigo_motorista));
		return mv;	
	}
	
}
