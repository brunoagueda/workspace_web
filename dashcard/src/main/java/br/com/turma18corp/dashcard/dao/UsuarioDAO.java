package br.com.turma18corp.dashcard.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.turma18corp.dashcard.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

	// aqui vão as consultas personalizadas (os selects especificos)
	public Usuario findByEmailOrRacf(String email, String racf);
}
