package br.com.isidrocorp.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.hello.model.Produto;

/* As anotações são consideradas "comentários uteis", ou seja
 * esta anotação será usada pelo Framework SpringBoot para indicar que
 * a classe HelloController agora está apta a atender requisições via WEB
 * 
 */


@RestController
public class HelloController {
	
	/*Agora anotamas o método sayHello para que a url
	 * 		https://localhost:8080/hello
	 * execute exatamente este método
	 * 
	 */
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Olha só... Meu primeiro programa em Spring Boot";
	}
	
	@GetMapping("/produto")
	public Produto exibirProduto() {
		Produto p = new Produto();
		p.setId(123456);
		p.setDescricao("Computador top de linha");
		p.setPreco(1500.00);
		p.setQtdeEstoque(3);
		return p;
		
	}
	
	@PostMapping("/adicionarproduto")
	public String adicionarNovoProduto(@RequestBody Produto novo) {
		System.out.println("Recebi um novo produto...");
		System.out.println(novo.getId() + " " + novo.getDescricao() + " "+novo.getPreco()+" "+novo.getQtdeEstoque());
		return "ok";
	}

}
