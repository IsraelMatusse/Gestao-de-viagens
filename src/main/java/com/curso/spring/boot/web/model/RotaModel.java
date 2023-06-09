package com.curso.spring.boot.web.model;

import lombok.Data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Data
@Entity(name="rota")
public class RotaModel {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codrota;
	@Column(nullable=false)
	private String nomerota;
	@Column(nullable=false)
	private Long distancia;
	@Column(nullable=false)
	private long preco;
	

	@ManyToMany
	@JoinTable(name="associacao_rota",
	joinColumns= @JoinColumn(name="rota_fk"),
	inverseJoinColumns = @JoinColumn(name="associacao_fk"))
	private List<AssociacaoModel> associacao;
	public List<AssociacaoModel> getAssociacao() {
		return associacao;
	}
	public void setAssociacao(List<AssociacaoModel> associacao) {
		this.associacao = associacao;
	}
	
	@OneToMany(mappedBy="rota")
	private List<TransporteModel> transporte;
	public List<TransporteModel> getTransporte() {
		return transporte;
	}
	public void setTransporte(List<TransporteModel> transporte) {
		this.transporte = transporte;
	} 
	
	
	
}
