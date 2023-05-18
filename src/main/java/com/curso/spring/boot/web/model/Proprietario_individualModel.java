package com.curso.spring.boot.web.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="proprietario_individual")
public class Proprietario_individualModel extends AccoesdoSistemaModel{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long codproprietarioindividual;
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
	private Double anonascimento;
	@ManyToOne
	private GeneroModel genero;
	@ManyToOne
	private DocumentoIdentificacaoModel documentoIdentificacaoModel;
	
}
