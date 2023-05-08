package com.curso.spring.boot.web.DTO.ViagemDTO;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ViagemActualizarDTO {

    private Long codviagem;
    @Column(nullable=false)
    private String destino_viagem;
    @Column(nullable=false)
    private String saida;
    @Column(nullable=false)
    private String prev_chegada;
    @Column(nullable=false)
    private String chaveviagem;
}
