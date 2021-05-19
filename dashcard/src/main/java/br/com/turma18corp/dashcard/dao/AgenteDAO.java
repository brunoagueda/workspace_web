package br.com.turma18corp.dashcard.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.turma18corp.dashcard.model.Agente;

public interface AgenteDAO extends CrudRepository<Agente, Integer>{
	
	public ArrayList<Agente> findByOrderByVolumeDesc();

}
