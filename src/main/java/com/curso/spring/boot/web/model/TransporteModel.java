package com.curso.spring.boot.web.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity(name="transporte")
@Data
public class TransporteModel {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long codtransporte;
    public Long getCodtransporte() {
        return codtransporte;
    }
    public void setCodtransporte(Long codtransporte) {
        this.codtransporte = codtransporte;
    }
    @Column(nullable=false)
    private String matricula;
    @Column(nullable=false)
    private String cor;
    @Column(nullable=false)
    private String marca;
    @Column(nullable=false)
    private String modelo;
    @Column(nullable=false)
    private Long lotacao;
    @Column(nullable=false)
    private Long pesobruto;
    @Column(nullable=false)
    private String tipo;
    @Column(nullable=false)
    private Long anofabrico;
    @Column(nullable=false)
    private Long quilometragem;
    @Column(nullable=false)
    private String combustivel;
    @Column(nullable=false)
    private String nrmotor;
    @Column(nullable=false)
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

    @ManyToOne(cascade = CascadeType.DETACH)
    private RotaModel rota;
    public RotaModel getRota() {
        return rota;
    }
    public void setRota(RotaModel rota) {
        this.rota = rota;
    }




}
