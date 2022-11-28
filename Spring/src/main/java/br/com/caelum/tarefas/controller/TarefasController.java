package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.tarefas.dao.TarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Transactional
@Controller
public class TarefasController {
		
	@Autowired
	//@Qualifier("jpaTarefaDao") Desativado
	TarefaDao dao;
	  
	
	@RequestMapping(value="novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}
	
	@RequestMapping(value="adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if(result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}

	@RequestMapping("listaTarefas")
	public ModelAndView lista() {
	    List<Tarefa> tarefas = dao.lista();
	    
	    ModelAndView mv = new ModelAndView("tarefa/lista");
	    mv.addObject("tarefas", tarefas);
	    return mv;
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
      dao.remove(tarefa);
      return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {	
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
	  dao.altera(tarefa);
	  return "redirect:listaTarefas";
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) {
	dao.finaliza(id);
	model.addAttribute("tarefa", dao.buscaPorId(id));
    return "tarefa/finalizada";
	}
}
