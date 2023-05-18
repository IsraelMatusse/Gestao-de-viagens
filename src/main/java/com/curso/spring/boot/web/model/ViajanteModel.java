package com.curso.spring.boot.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Data
@Entity(name="viajante")

public class ViajanteModel extends AccoesdoSistemaModel {


	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String apelido;
	@Column(nullable=false)
	private Long anonascimento;
	@Column(nullable=false)
	private String bairro;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String cidade;
	@Column(nullable=false)
	private String provincia ;
	@ManyToMany
	@JoinTable(name="viagem_viajante",
	joinColumns= @JoinColumn(name="viajante_fk"),
	inverseJoinColumns = @JoinColumn(name="viagem_fk"))
	private List<ViagemModel> viagem;
	@ManyToOne
	private GeneroModel genero;
	@ManyToOne
	private DocumentoIdentificacaoModel documentoIdentificacaoModel;
	


}
