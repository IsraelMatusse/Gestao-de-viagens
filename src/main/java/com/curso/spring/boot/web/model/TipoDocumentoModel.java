package com.curso.spring.boot.web.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
public class TipoDocumentoModel extends AccoesdoSistemaModel{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long codtipodocumento;
    private String designacao;
}
