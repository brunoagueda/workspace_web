package br.com.turma18corp.dashcard.dto;

public class TotaisDTO {
	
	private String nomeAgente;
	private float volume;
	private int totalSucesso;
	private int totalFalha;
	private int totalFraude;
	
	
	public String getNomeAgente() {
		return nomeAgente;
	}
	public void setNomeAgente(String nomeAgente) {
		this.nomeAgente = nomeAgente;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public int getTotalSucesso() {
		return totalSucesso;
	}
	public void setTotalSucesso(int totalSucesso) {
		this.totalSucesso = totalSucesso;
	}
	public int getTotalFalha() {
		return totalFalha;
	}
	public void setTotalFalha(int totalFalha) {
		this.totalFalha = totalFalha;
	}
	public int getTotalFraude() {
		return totalFraude;
	}
	public void setTotalFraude(int totalFraude) {
		this.totalFraude = totalFraude;
	}
	
}
