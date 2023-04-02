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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.spring.boot.web.model.AssociacaoModel;
import com.curso.spring.boot.web.model.MotoristaModel;
import com.curso.spring.boot.web.model.TransporteModel;
import com.curso.spring.boot.web.model.ViagemModel;
import com.curso.spring.boot.web.model.ViajanteModel;
import com.curso.spring.boot.web.repository.Viagensrealizadas;
import com.curso.spring.boot.web.service.AssociacaoService;
import com.curso.spring.boot.web.service.MotoristaService;
import com.curso.spring.boot.web.service.ProprietarioEmpresaService;
import com.curso.spring.boot.web.service.ProprietarioService;
import com.curso.spring.boot.web.service.RotaService;
import com.curso.spring.boot.web.service.TransporteService;

import DTO.TransporteDTO;

@Controller
public class TransporteController {

	@Autowired
	TransporteService transporteservice;
	@Autowired
	AssociacaoService associacaoservice;
	@Autowired
	MotoristaService motoristaservice;
	@Autowired 
	ProprietarioService proprietarioserice;
	
	@Autowired
	ProprietarioEmpresaService empresaservice;
	
	@Autowired
	RotaService rotaservice;
	
	@GetMapping("/transporte")
	public ModelAndView transporte() {
		ModelAndView mv= new ModelAndView("transporte/transporte");
		mv.addObject("transporte", new TransporteModel());
		mv.addObject("transportes", transporteservice.listartransporte());
		mv.addObject("associacoes", associacaoservice.listarassociacao());
		mv.addObject("motoristas", motoristaservice.listarmostoristas());
		mv.addObject("proprietarios", empresaservice.listarempresa());
		mv.addObject("rotas", rotaservice.listarotas() );
		return mv;
		
	}
	
	
	@PostMapping("/transporte")
	public String cadastrartransporte(@ModelAttribute("transporte") TransporteModel transporte, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "verifique os campos");
			return "redirect:/transporte"; }
		 transporteservice.cadastrartransporte(transporte);
			attributes.addFlashAttribute("mensagem", "Dados cadastrados com sucesso");
		 return "redirect:/transporte";
	}
	
	@RequestMapping(path={"/listartransporte","/searchtransporte"})
	public String listartransporte(Model model, String keyword, Long cod_transporte){
		
		if(keyword !=null) {
			List<TransporteModel> transporte=transporteservice.getByKeyword(keyword);
			model.addAttribute("transporte", transporte);
		}else {
		List <TransporteModel> transporte=transporteservice.listartransporte();
		model.addAttribute("transporte", transporte); }
		return "transporte/listartransporte";
		
		
	}
	
	@GetMapping("/detalhestransporte")
	public ModelAndView detalhestransporte(Long cod_transporte) {
		ModelAndView mv = new ModelAndView("transporte/detalhestransporte");
	
		mv.addObject("Transporte", transporteservice.listarporcodigo(cod_transporte));
		return mv;
	}
	
	/*@RequestMapping( value="/detalhestransporte", method=RequestMethod.POST)
	public String viagemviajante(@RequestParam("cod_transporte") Long cod_transporte, @ModelAttribute MotoristaModel motorista, @ModelAttribute AssociacaoModel associacao ) {
		
		associacao= associacaoservice.listarporcodigo(associacao.getCodassociacao());
		motorista= motoristaservice.listarporcodigo(motorista.getCodigo());
		TransporteModel transporte =transporteservice.listarporcodigo(cod_transporte);
			
		
		viajante.getViagem().add(viagem);
		viajanteservice.salvarViajante(viajante);
		return "redirect:detalhesviajante/{cod_viajante}";
		*/
	

	@GetMapping("/edittransporte/{cod_transporte}")
	public String showUpdateForm(@PathVariable("cod_transporte") long cod_transporte, Model model) {
	    TransporteModel transporte = transporteservice.listarporcodigo(cod_transporte);
	    
	    model.addAttribute("transporte", transporte);
	    return "transporte/updatetransporte";
	}
	
	@PostMapping("/updatetransporte/{cod_transporte}")
	public String udpatetransporte(@PathVariable ("cod_transporte") Long cod_transporte, TransporteModel transported) {
		Optional<TransporteModel> transporte= Optional.ofNullable(transporteservice.listarporcodigo(cod_transporte));
				transporte.get().setAnofabrico(transported.getAnofabrico());
				transporte.get().setCombustivel(transported.getCombustivel());
				transporte.get().setCor(transported.getCor());
				transporte.get().setLotacao(transported.getLotacao());
				transporte.get().setMarca(transported.getMarca());
				transporte.get().setNrmotor(transported.getNrmotor());
				transporte.get().setQuilometragem(transported.getQuilometragem());
				transporte.get().setTipo(transported.getTipo());
				transporte.get().setNrportas(transported.getNrportas());
				transporte.get().setPesobruto(transported.getPesobruto());
				transporte.get().setMarca(transported.getMarca());
				transporteservice.cadastrartransporte(transporte.get());
				return"redirect:/listartransporte";
	}
		
	@GetMapping("/deletetransporte/{cod_transporte}")
	public String deletetransporte(@PathVariable("cod_transporte") long cod_transporte, Model model) {
		TransporteModel transporte= transporteservice.listarporcodigo(cod_transporte);
	     	transporteservice.apagartransporte(cod_transporte, transporte);
	    return "redirect:/listartransporte";
	}
	
	@GetMapping("/viagensrealizadas")
	public String viagensrealizadas(Model model) {
		List<Viagensrealizadas> numeroviagens = transporteservice.viagensrealizadas();
		model.addAttribute("numeroviagens", numeroviagens);
		return "Estatisticas/transporte";
	
	}
	
}
