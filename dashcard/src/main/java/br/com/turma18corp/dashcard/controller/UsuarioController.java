package br.com.turma18corp.dashcard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.turma18corp.dashcard.dao.UsuarioDAO;
import br.com.turma18corp.dashcard.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired // serve para deixar a gestao do objeto na responsabilidade da JVM, facilita a vida
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios") // metodo GET que traz todos os usuários cadastrados na base
	public ArrayList<Usuario> retornarTodos(){
		ArrayList<Usuario> lista;
		lista = (ArrayList<Usuario>)dao.findAll();
		return lista;
	}
	
	@PostMapping("/login") // metodo POST para validar email ou racf do usuario e senha
	public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario dados) {
		Usuario resultado = dao.findByEmailOrRacf(dados.getEmail(), dados.getRacf());
		if(resultado != null) {
			if(resultado.getSenha().contentEquals(dados.getSenha())) {
				return ResponseEntity.ok(resultado);
			}
			else {
				return ResponseEntity.status(403).build();
			}
		}
		else{
			return ResponseEntity.notFound().build();
		}
	}
}
