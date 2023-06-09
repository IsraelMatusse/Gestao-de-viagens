package com.curso.spring.boot.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
@Data
@Entity(name="viajante")

public class ViajanteModel extends PessoaModel {

	
	
	@ManyToMany
	@JoinTable(name="viagem_viajante",
	joinColumns= @JoinColumn(name="viajante_fk"),
	inverseJoinColumns = @JoinColumn(name="viagem_fk"))
	private List<ViagemModel> viagem;


	


}
