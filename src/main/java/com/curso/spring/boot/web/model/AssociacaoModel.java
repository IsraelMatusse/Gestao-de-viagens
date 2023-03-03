package com.curso.spring.boot.web.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="associacao")
public class AssociacaoModel implements Serializable{
	
	
	private static final Long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codassociacao;
	private String nomeassociacao;
	private String bairroassociacao;
	private String cidadeassociacao;
	private String emailassociacao;
	private Double contactoassociacao;
	public Long getCodassociacao() {
		return codassociacao;
	}
	public void setCodassociacao(Long cod_associacao) {
		this.codassociacao = cod_associacao;
	}
	public String getNomeassociacao() {
		return nomeassociacao;
	}
	public void setNomeassociacao(String nome_associacao) {
		this.nomeassociacao = nome_associacao;
	}
	public String getBairroassociacao() {
		return bairroassociacao;
	}
	public void setBairroassociacao(String bairro_associacao) {
		this.bairroassociacao = bairro_associacao;
	}
	public String getCidadeassociacao() {
		return cidadeassociacao;
	}
	public void setCidadeassociacao(String cidade_associacao) {
		this.cidadeassociacao = cidade_associacao;
	}
	public String getEmailassociacao() {
		return emailassociacao;
	}
	public void setEmailassociacao(String email_associacao) {
		this.emailassociacao = email_associacao;
	}
	public Double getContactoassociacao() {
		return contactoassociacao;
	}
	public void setContacto_associacao(Double contacto_associacao) {
		this.contactoassociacao = contacto_associacao;
	}
	
	@OneToMany(mappedBy="associacao", cascade=CascadeType.REMOVE)
	private List<ViagemModel> viagens;
	public List<ViagemModel> getViagens() {
		return viagens;
	}
	public void setViagens(List<ViagemModel> viagens) {
		this.viagens = viagens;
	}
	public void setContactoassociacao(Double contactoassociacao) {
		this.contactoassociacao = contactoassociacao;
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
