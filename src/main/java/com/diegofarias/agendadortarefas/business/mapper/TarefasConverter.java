package com.diegofarias.agendadortarefas.business.mapper;

import com.diegofarias.agendadortarefas.business.dto.TarefasDTO;
import com.diegofarias.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    @Mapping(source = "dataEvento", target = "dataEvento")
    TarefasEntity paraTarefasEntity(TarefasDTO tarefasDTO);

    TarefasDTO paraTarefasDTO(TarefasEntity tarefasEntity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTO> tarefasDTOS);

    List<TarefasDTO> paraListaTarefasDTO(List<TarefasEntity> tarefasEntities);

}