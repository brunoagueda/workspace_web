package br.com.turma18corp.dashcard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.turma18corp.dashcard.dao.TransacaoDAO;
import br.com.turma18corp.dashcard.dto.TotaisDTO;
import br.com.turma18corp.dashcard.model.Agente;
import br.com.turma18corp.dashcard.model.Transacao;

@RestController
@CrossOrigin("*")
public class TransacaoController {
	
	@Autowired
	private TransacaoDAO dao;
	
	@GetMapping("/transacoes")
	public ArrayList<Transacao> recuperarTodas(){
		ArrayList<Transacao> lista;
		lista = (ArrayList<Transacao>) dao.findAll();
		return lista;
	}
	
	@GetMapping("/transacoes/{id}")
	public ArrayList<Transacao> recuperarPeloIdAgente(@PathVariable int id){
		Agente ag = new Agente();
		ag.setId(id);
		return dao.findAllByAgente(ag);
	}
	
	@GetMapping("/transacoestotais/{id}")
	public TotaisDTO resuperartotais(@PathVariable int id) {
		int totalSuc=0;
		int totalFal=0;
		int totalFra=0;
		Agente ag = new Agente();
		ag.setId(id);
		ArrayList<Transacao> lista = dao.findAllByAgente(ag);
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getStatus() == 0) {
				totalSuc++;
			}
			else if(lista.get(i).getStatus() == 1) {
				totalFal++;
			}
			else {
				totalFra++;
			}
		}
		
		TotaisDTO dto = new TotaisDTO();
		dto.setTotalSucesso(totalSuc);
		dto.setTotalFalha(totalFal);
		dto.setTotalFraude(totalFra);
		dto.setNomeAgente(lista.get(0).getAgente().getNome());
		dto.setVolume(lista.get(0).getAgente().getVolume());
		return dto;
		
	}
	
	
}
