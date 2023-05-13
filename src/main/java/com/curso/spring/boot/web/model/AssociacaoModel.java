package com.curso.spring.boot.web.model;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@Table(name="associacao")
public class AssociacaoModel extends AccoesdoSistemaModel{
	
	
	private static final Long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codassociacao;
	@Column(nullable=false)
	private String nomeassociacao;
	@Column(nullable=false)
	private String bairroassociacao;
	@Column(nullable=false)
	private String cidadeassociacao;
	@Column(nullable=false)
	private String emailassociacao;
	@Column(nullable=false)
	private int contactoassociacao;

	
	@OneToMany(mappedBy="associacao", cascade = CascadeType.ALL)
	private List<ViagemModel> viagens;
	public List<ViagemModel> getViagens() {
		return viagens;
	}

	@ManyToMany()
	@JoinTable(name="associacao_rota",
	joinColumns= @JoinColumn(name="associacao_fk"),
	inverseJoinColumns = @JoinColumn(name="rota_fk"))
	private List<RotaModel>rotas;
	
	
	public List<RotaModel> getRotas() {
		return rotas;
	}
	public void setRotas(List<RotaModel> rotas) {
		this.rotas = rotas;
	}

	
	
}
