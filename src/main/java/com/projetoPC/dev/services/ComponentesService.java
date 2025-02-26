package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.ComponentesDTO;
import com.projetoPC.dev.models.Componentes;
import com.projetoPC.dev.models.Usuario;
import com.projetoPC.dev.repositories.ComponentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentesService {

    @Autowired ComponentesRepository componentesRepository;

    public ComponentesDTO cadastrarComponentes(ComponentesDTO componentesDTO) {
        Componentes componentes = converterComponentesDTOParaComponentes(componentesDTO);
        componentes = componentesRepository.save(componentes);
        return converterComponentesParaComponentesDTO(componentes);
    }








    public Componentes converterComponentesDTOParaComponentes(ComponentesDTO componentesDTO) {
        Componentes componentes = new Componentes();
        componentes.setNome(componentesDTO.getNome());
        componentes.setTipo(componentesDTO.getTipo());
        componentes.setPotenciaConsumida(componentesDTO.getPotenciaConsumida());
        componentes.setPreco(componentesDTO.getPreco());
        componentes.setFabricante(componentesDTO.getFabricante());
        componentes.setDescricao(componentesDTO.getDescricao());
        componentes.setTamanho(componentesDTO.getTamanho());
        componentes.setSocketCpu(componentesDTO.getSocketCpu());
        componentes.setPciCompatibilidade(componentesDTO.getPciCompatibilidade());
        return componentes;
    }

    public ComponentesDTO converterComponentesParaComponentesDTO(Componentes componentes) {
        ComponentesDTO componentesDTO = new ComponentesDTO();
        componentesDTO.setNome(componentes.getNome());
        componentesDTO.setTipo(componentes.getTipo());
        componentesDTO.setPotenciaConsumida(componentes.getPotenciaConsumida());
        componentesDTO.setPreco(componentes.getPreco());
        componentesDTO.setFabricante(componentes.getFabricante());
        componentesDTO.setDescricao(componentes.getDescricao());
        componentesDTO.setTamanho(componentes.getTamanho());
        componentesDTO.setSocketCpu(componentes.getSocketCpu());
        componentesDTO.setPciCompatibilidade(componentes.getPciCompatibilidade());
        return componentesDTO;
    }
}
