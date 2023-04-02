package com.curso.spring.boot.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="carga")
public class CargaModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codcarga;
	@Column(nullable=false)
	private String designacao;
	@Column(nullable=false)
	private Long peso;
}
