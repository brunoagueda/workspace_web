package br.com.turma18corp.dashcard.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mtb310_transaction")
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_transacao")
	private int id;
	
	@Column(name="data_hora")
	private LocalDateTime	dataHora;
	
	@Column(name="dispositivo")
	private int dispositivo;
	
	@Column(name="valor_solic")
	private float valorSolicitado;
	
	@Column(name="valor_aut")
	private int valorAutorizado;
	
	@Column(name="status")
	private int status;
	
	@ManyToOne
	@JoinColumn(name="ag_financeiro")
	private Agente agente;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public int getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(int dispositivo) {
		this.dispositivo = dispositivo;
	}
	public float getValorSolicitado() {
		return valorSolicitado;
	}
	public void setValorSolicitado(float valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}
	public int getValorAutorizado() {
		return valorAutorizado;
	}
	public void setValorAutorizado(int valorAutorizado) {
		this.valorAutorizado = valorAutorizado;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Agente getAgente() {
		return agente;
	}
	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	
	
	
}
