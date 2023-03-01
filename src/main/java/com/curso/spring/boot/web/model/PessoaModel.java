package com.curso.spring.boot.web.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name="pessoa")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class PessoaModel implements Serializable {
 
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long codigo;
	private String nome;
	private String apelido;
	private Long anonascimento;
	private String bairro;
	private String email;
	private String cidade;
	private String provincia ;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public Long getAnonascimento() {
		return anonascimento;
	}
	public void setAnonascimento(Long anonascimento) {
		this.anonascimento = anonascimento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
}
