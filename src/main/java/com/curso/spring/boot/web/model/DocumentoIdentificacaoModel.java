package com.curso.spring.boot.web.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
public class DocumentoIdentificacaoModel extends AccoesdoSistemaModel{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String numeroDocumento;
    @ManyToOne
    private TipoDocumentoModel tipoDocumentofk;
    @ManyToOne
    private UserModel usuariofk;
    private String documentoAnexo;
}
