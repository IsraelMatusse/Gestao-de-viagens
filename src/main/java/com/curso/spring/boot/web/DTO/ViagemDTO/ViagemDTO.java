package com.curso.spring.boot.web.DTO.ViagemDTO;

public class ViagemDTO {
	
	private String nome;
	private String destino_viagem;
	private String chaveviagem;
	private Long numeroviagens;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDestino_viagem() {
		return destino_viagem;
	}
	public void setDestino_viagem(String destino_viagem) {
		this.destino_viagem = destino_viagem;
	}
	
	public String getChaveviagem() {
		return chaveviagem;
	}
	public void setChaveviagem(String chaveviagem) {
		this.chaveviagem=chaveviagem;
	}
	public Long getNumeroviagens() {
		return numeroviagens;
	}
	public void setNumeroviagens(Long numeroviagens) {
		this.numeroviagens = numeroviagens;
	}
	

}
