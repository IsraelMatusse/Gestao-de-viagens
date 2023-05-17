package com.curso.spring.boot.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public abstract class  AccoesdoSistemaModel {
    private Boolean activo = true;
    @CreatedBy
    @ManyToOne
    private UserModel criadoPor;
    @LastModifiedBy
    @ManyToOne
    private UserModel  actualizadoPor;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private UserModel  apagadoPor;
    @CreationTimestamp
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataActualizacao;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataApagado;
}
