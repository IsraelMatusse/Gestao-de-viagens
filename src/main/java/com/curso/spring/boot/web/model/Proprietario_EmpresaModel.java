package com.curso.spring.boot.web.model;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name="proprietario_empresa")
@Table(name = "proprietario_empresa")
public class Proprietario_EmpresaModel extends AccoesdoSistemaModel{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long codproprietarioemepresa;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String bairro;
	@Column(nullable=false)
	private String cidade;
	@Column(nullable=false)
	private String tipolicenca;
	@Column(nullable=false)
	private String provincia;
//	@OneToMany(mappedBy="proprietario_empresa")
//	private List<TransporteModel> transporte= new ArrayList<>();

	@Column(nullable=false)
	private Double nuit;
	@Column(nullable=false)
	private String alvara;
	@Column(nullable=false)
	private Long anocriacao;
	@ManyToOne
	private DocumentoIdentificacaoModel documentoIdentificacaoModel;
}
