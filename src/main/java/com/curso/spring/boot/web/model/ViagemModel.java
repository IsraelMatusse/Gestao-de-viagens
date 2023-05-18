package com.curso.spring.boot.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence. *;
@Data
@Entity(name="viagem")
public class ViagemModel extends AccoesdoSistemaModel{


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
	@ManyToOne
	private AssociacaoModel associacao;
	@ManyToMany
	@JoinTable(name="viagem_viajante",
	joinColumns= @JoinColumn(name="viagem_fk"),
	inverseJoinColumns = @JoinColumn(name="viajante_fk"))
	private List<ViajanteModel> viajante;
	@ManyToOne()
	private TransporteModel transporte;

	
}
