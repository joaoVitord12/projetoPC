package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.ComponentesDTO;
import com.projetoPC.dev.models.Componentes;
import com.projetoPC.dev.models.Tipo;
import com.projetoPC.dev.repositories.ComponentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComponentesService {

    @Autowired
    ComponentesRepository componentesRepository;

    public ComponentesDTO cadastrarComponentes(ComponentesDTO componentesDTO) {
        Componentes componentes = convertToEntity(componentesDTO);
        return convertToDTO(componentesRepository.save(componentes));
    }

    public List<ComponentesDTO> listarComponentes() {
        List<Componentes> componentes = componentesRepository.findAll();
        return componentes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ComponentesDTO convertToDTO(Componentes componentes) {
        ComponentesDTO componentesDTO = new ComponentesDTO();
        componentesDTO.setId(componentes.getId());
        componentesDTO.setNome(componentes.getNome());
        componentesDTO.setTipo(String.valueOf(componentes.getTipo()));
        componentesDTO.setPotenciaConsumida(componentes.getPotenciaConsumida());
        componentesDTO.setPreco(componentes.getPreco());
        componentesDTO.setFabricante(componentes.getFabricante());
        componentesDTO.setDescricao(componentes.getDescricao());
        componentesDTO.setTamanho(componentes.getTamanho());
        componentesDTO.setSocketCpu(componentes.getSocketCpu());
        componentesDTO.setPciCompatibilidade(componentes.getPciCompatibilidade());
        return componentesDTO;
    }

    public Componentes convertToEntity(ComponentesDTO componentesDTO) {
        Componentes componentes = new Componentes();
        componentes.setId(componentesDTO.getId());
        componentes.setNome(componentesDTO.getNome());
        componentes.setTipo(Tipo.valueOf(componentesDTO.getTipo()));
        componentes.setPotenciaConsumida(componentesDTO.getPotenciaConsumida());
        componentes.setPreco(componentesDTO.getPreco());
        componentes.setFabricante(componentesDTO.getFabricante());
        componentes.setDescricao(componentesDTO.getDescricao());
        componentes.setTamanho(componentesDTO.getTamanho());
        componentes.setSocketCpu(componentesDTO.getSocketCpu());
        componentes.setPciCompatibilidade(componentesDTO.getPciCompatibilidade());
        return componentes;
    }
}
