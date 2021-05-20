package br.com.turma18corp.dashcard.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.turma18corp.dashcard.model.Agente;
import br.com.turma18corp.dashcard.model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer> {
	public ArrayList<Transacao> findAllByAgente(Agente agente);
}
