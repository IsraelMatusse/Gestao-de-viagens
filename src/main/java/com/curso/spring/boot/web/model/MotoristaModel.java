package com.curso.spring.boot.web.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Data
@Entity(name="motorista")

public class MotoristaModel extends AccoesdoSistemaModel {

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
	@Column(nullable=false)
	private String BI;
	private String nrcarta;
	private String nivelcarta;
	@OneToOne
	private TransporteModel transporte;

	@ManyToOne
	private GeneroModel genero;
	@ManyToOne
	private DocumentoIdentificacaoModel documentoIdentificacaoModel;
}
