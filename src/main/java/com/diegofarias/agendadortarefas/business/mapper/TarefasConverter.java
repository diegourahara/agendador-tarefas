package com.diegofarias.agendadortarefas.business.mapper;

import com.diegofarias.agendadortarefas.business.dto.TarefasDTO;
import com.diegofarias.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefasEntity(TarefasDTO tarefasDTO);

    TarefasDTO paraTarefasDTO(TarefasEntity tarefasEntity);

}