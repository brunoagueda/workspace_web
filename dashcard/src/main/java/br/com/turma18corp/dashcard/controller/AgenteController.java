package br.com.turma18corp.dashcard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.turma18corp.dashcard.dao.AgenteDAO;
import br.com.turma18corp.dashcard.model.Agente;

@RestController
@CrossOrigin("*")
public class AgenteController {
	
	@Autowired
	private AgenteDAO dao;
	
	@GetMapping("/agentes")
	private ArrayList<Agente> recuperarTodos(){
		return dao.findByOrderByVolumeDesc();
	}
	
}
