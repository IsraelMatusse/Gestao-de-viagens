package com.curso.spring.boot.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence. *;

@Entity(name="viagem")
public class ViagemModel implements Serializable{

	@ManyToOne
	private AssociacaoModel associacao;
	public AssociacaoModel getAssociacao() {
		return associacao;
	}
	public void setAssociacao(AssociacaoModel associacao) {
		this.associacao = associacao;
	}
	private static final Long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codviagem;
	@Column(nullable=false)
	private String destino_viagem;
	@Column(nullable=false)
	private String saida;
	@Column(nullable=false)
	private String prev_chegada;
	public String getDestino_viagem() {
		return destino_viagem;
	}
	public void setDestino_viagem(String destino_viagem) {
		this.destino_viagem = destino_viagem;
	}

	public Long getCodviagem() {
		return codviagem;
	}
	public void setCod_viagem(Long cod_viagem) {
		this.codviagem = cod_viagem;
	}

	
	
	public String getSaida() {
		return saida;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}
	public String getPrev_chegada() {
		return prev_chegada;
	}
	public void setPrev_chegada(String prev_chegada) {
		this.prev_chegada = prev_chegada;
	}
	@ManyToMany
	@JoinTable(name="viagem_viajante",
	joinColumns= @JoinColumn(name="viagem_fk"),
	inverseJoinColumns = @JoinColumn(name="viajante_fk"))
	private List<ViajanteModel> viajante;
	
	public List<ViajanteModel> getViajante() {
		return viajante;
	}
	public void setViajante(List<ViajanteModel> viajante) {
		this.viajante = viajante;
	}
	
	@ManyToOne()
	private TransporteModel transporte;
	public TransporteModel getTransporte() {
		return transporte;
	}
	public void setTransporte(TransporteModel transporte) {
		this.transporte = transporte;
	}
	public void setCodviagem(Long codviagem) {
		this.codviagem = codviagem;
	}
	
}
