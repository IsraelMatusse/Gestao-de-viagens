package com.curso.spring.boot.web.model;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="proprietario_empresa")
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
	@OneToMany(mappedBy="proprietario", cascade = CascadeType.ALL)
	private List<TransporteModel> transporte;
	@Column(nullable=false)
	private Double nuit;
	@Column(nullable=false)
	private String alvara;
	@Column(nullable=false)
	private Long anocriacao;
	@ManyToOne
	private DocumentoIdentificacaoModel documentoIdentificacaoModel;
}
