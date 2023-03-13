package com.curso.spring.boot.web.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="transporte")

public class TransporteModel {

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Long getLotacao() {
		return lotacao;
	}
	public void setLotacao(Long lotacao) {
		this.lotacao = lotacao;
	}
	public Long getPesobruto() {
		return pesobruto;
	}
	public void setPesobruto(Long pesobruto) {
		this.pesobruto = pesobruto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getAnofabrico() {
		return anofabrico;
	}
	public void setAnofabrico(Long anofabrico) {
		this.anofabrico = anofabrico;
	}
	public Long getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(Long quilometragem) {
		this.quilometragem = quilometragem;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getNrmotor() {
		return nrmotor;
	}
	public void setNrmotor(String nrmotor) {
		this.nrmotor = nrmotor;
	}
	public Long getNrportas() {
		return nrportas;
	}
	public void setNrportas(Long nrportas) {
		this.nrportas = nrportas;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codtransporte;
	public Long getCodtransporte() {
		return codtransporte;
	}
	public void setCodtransporte(Long codtransporte) {
		this.codtransporte = codtransporte;
	}

	private String matricula;
	private String cor;
	private String marca;
	private String modelo;
	private Long lotacao;
	private Long pesobruto;
	private String tipo;
	private Long anofabrico;
	private Long quilometragem;
	private String combustivel;
	private String nrmotor;
	private Long nrportas;
	
	

	
	@ManyToOne(cascade = CascadeType.DETACH)
	private AssociacaoModel associacao;
	public AssociacaoModel getAssociacao() {
		return associacao;
	}
	public void setAssociacao(AssociacaoModel associacao) {
		this.associacao = associacao;
	}
	@OneToOne
	private MotoristaModel motorista;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	private ProprietarioModel proprietario;
	public MotoristaModel getMotorista() {
		return motorista;
	}
	public void setMotorista(MotoristaModel motorista) {
		this.motorista = motorista;
	}
	
	public ProprietarioModel getProprietario() {
		return proprietario;
	}
	public void setProprietario(ProprietarioModel proprietario) {
		this.proprietario=proprietario;
}
	
	@OneToMany(mappedBy="transporte", cascade = CascadeType.ALL)
	private List<ViagemModel> viagem;
	public List<ViagemModel> getViagem() {
		return viagem;
	}
	public void setViagem(List<ViagemModel> viagem) {
		this.viagem = viagem;
	}
	

	
}
