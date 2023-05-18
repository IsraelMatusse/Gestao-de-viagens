package com.curso.spring.boot.web.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity(name="transporte")
@Data
public class TransporteModel extends AccoesdoSistemaModel{


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
    @OneToOne
    private MotoristaModel motorista;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Proprietario_individualModel proprietarioIndividual;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Proprietario_EmpresaModel proprietarioEmpresa;
    @OneToMany(mappedBy="transporte", cascade = CascadeType.ALL)
    private List<ViagemModel> viagem;
    @ManyToOne(cascade = CascadeType.DETACH)
    private RotaModel rota;




}
