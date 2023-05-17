package com.curso.spring.boot.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence. *;
@Data
@Entity(name="viagem")
public class ViagemModel implements Serializable{

	@ManyToOne
	private AssociacaoModel associacao;
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

	@Column(nullable=false)
	private String chaveviagem;

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
