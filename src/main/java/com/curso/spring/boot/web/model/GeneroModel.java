package com.curso.spring.boot.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class GeneroModel extends AccoesdoSistemaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codgenero;
    private String designacao;
    private char gen;
}
