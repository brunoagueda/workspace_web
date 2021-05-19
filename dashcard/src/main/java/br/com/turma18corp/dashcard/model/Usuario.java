package br.com.turma18corp.dashcard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity			//essa anotação indica ao JPA que a classe Usuario será mapeada no banco para uma tabela
@Table(name="mtb310_usuario") //como o nome da tabela no anco não conincide com o nome da classe, eu preciso especificar
public class Usuario {
	
	@Id				//indica que o atributo é chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // isso eu preciso indicar quando o campo é AUTO_INCREMENT no MySQL
	@Column(name="id_usuario")
	private int id;
	
	@Column(name="nome_usuario")
	private String nome;
	
	@Column(name="email_usuario", length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(name="senha_usuario", length = 50, nullable = false, unique = true)
	private String senha;
	
	@Column(name="racf_usuario", length = 7, nullable = false, unique = true)
	private String racf;
	
	@Column(name="ramal_usuario", length = 10)
	private String ramal;
	
	@Column(name="nome_depto", length = 50, nullable = false)
	private String nomeDepto;
	
	@Column(name="link_foto", length = 255)
	private String linkFoto;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public String getNomeDepto() {
		return nomeDepto;
	}
	public void setNomeDepto(String nomeDepto) {
		this.nomeDepto = nomeDepto;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	
	/////  Precisa de Getters e Setters!!!!
	
}
