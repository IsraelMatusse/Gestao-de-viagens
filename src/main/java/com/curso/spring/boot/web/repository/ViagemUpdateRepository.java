package com.curso.spring.boot.web.repository;

import com.curso.spring.boot.web.model.ViagemModel;
import org.springframework.stereotype.Repository;
import com.curso.spring.boot.web.DTO.ViagemDTO.ViagemActualizarDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Repository
@Mapper(componentModel = "spring")
public interface ViagemUpdateRepository {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void editarviagem( ViagemActualizarDTO viagemActualizarDTO , @MappingTarget ViagemModel entity);
}
