package com.luizalabs.veiculo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.luizalabs.veiculo.controller.utils.Mensagem;
import com.luizalabs.veiculo.model.Modelo;
import com.luizalabs.veiculo.repository.Modelos;

@Controller
@RequestMapping("/veiculo")
public class ModelosController {

	@Autowired
	private Modelos modelos;

	Map<String, Mensagem> mensagensIniciais = new HashMap<String, Mensagem>() {{ put("mensagemCadastro", new Mensagem("","")); put("mensagemRemocao", new Mensagem("",""));}};
	ModelAndView modelAndView = new ModelAndView("ModelosVeiculo", mensagensIniciais);

	@GetMapping("/modelos")
	public ModelAndView listar() {

		modelAndView.addObject("modelos", modelos.findAllModified());
		modelAndView.addObject("modelo", new Modelo());		

		return modelAndView;
	}

	@PostMapping("/modelos")
	public String salvar(Modelo modelo) {

		try {
			this.modelos.save(modelo);
			modelAndView.addObject("mensagemCadastro", new Mensagem("Sucesso","Cadastro realizado com sucesso!"));
		} catch (DataIntegrityViolationException e){
			modelAndView.addObject("mensagemCadastro", new Mensagem("Falha","O modelo "+modelo.getModelo()+" já foi cadastrado!"));
			this.modelos.save(new Modelo(null, modelo.getMarca()));			
		} catch (Exception e) {
			modelAndView.addObject("mensagemCadastro", new Mensagem("Falha","Falha ao cadastrar modelo!"));
		}

		modelAndView.addObject("mensagemRemocao", new Mensagem("",""));	

		return "redirect:/veiculo/modelos";		
	}

	//@DeleteMapping("/modelos/{modelo}")
	@PostMapping("/modelos/{modelo}")
	public String deletar(@PathVariable String modelo) {

		List<Modelo> modelosList = this.modelos.findByMarca(this.modelos.findByModelo(modelo).getMarca());

		if(modelosList.size() > 1) {
			this.modelos.deleteByModelo(modelo);
		}else{
			this.modelos.save(new Modelo(modelosList.get(0).getId(),null, modelosList.get(0).getMarca()));
		}
		modelAndView.addObject("mensagemRemocao", new Mensagem("Sucesso","Remocão realizada com sucesso!"));		
		modelAndView.addObject("mensagemCadastro", new Mensagem("",""));		

		return "redirect:/veiculo/modelos";
	}

}
