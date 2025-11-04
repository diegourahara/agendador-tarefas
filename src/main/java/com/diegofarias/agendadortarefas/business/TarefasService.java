package com.diegofarias.agendadortarefas.business;

import com.diegofarias.agendadortarefas.business.dto.TarefasDTO;
import com.diegofarias.agendadortarefas.business.mapper.TarefasConverter;
import com.diegofarias.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.diegofarias.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.diegofarias.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.diegofarias.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO tarefasDTO) {
        String email = jwtUtil.extractUsername(token.substring(7));

        tarefasDTO.setDataCriacao(LocalDateTime.now());
        tarefasDTO.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        tarefasDTO.setEmailUsuario(email);

        TarefasEntity tarefasEntity = tarefasConverter.paraTarefasEntity(tarefasDTO);

        return tarefasConverter.paraTarefasDTO(
                tarefasRepository.save(tarefasEntity)
        );
    }

}