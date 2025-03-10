package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.MemoriaRamDTO;
import com.projetoPC.dev.models.MemoriaRam;
import com.projetoPC.dev.repositories.MemoriaRamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoriaRamService {

    @Autowired MemoriaRamRepository memoriaRamRepository;

    public MemoriaRamDTO cadastrarMemoriaRam(MemoriaRamDTO memoriaRamDTO) {
        return convertToDTO(memoriaRamRepository.save(convertToEntity(memoriaRamDTO)));
    }

    public MemoriaRamDTO atualizarMemoriaRam(MemoriaRamDTO memoriaRamDTO) {
        MemoriaRam memoriaRam = memoriaRamRepository.findById(memoriaRamDTO.getId()).orElseThrow(() ->
                new IllegalArgumentException("Memoria RAM não encontrado com o ID: " + memoriaRamDTO.getId()));
        memoriaRam = convertToEntity(memoriaRamDTO);
        memoriaRamRepository.save(memoriaRam);
        return convertToDTO(memoriaRam);
    }

    public void deletarMemoriaRam(Long id) {
        MemoriaRam memoriaRam = memoriaRamRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Memoria RAM não encontrado com o ID: " + id));
        memoriaRamRepository.delete(memoriaRam);
    }

    public MemoriaRamDTO convertToDTO(MemoriaRam memoriaRam) {
        MemoriaRamDTO memroiaRamDTO = new MemoriaRamDTO();
        memroiaRamDTO.setId(memoriaRam.getId());
        memroiaRamDTO.setNome(memoriaRam.getNome());
        memroiaRamDTO.setPreco(memoriaRam.getPreco());
        memroiaRamDTO.setFabricante(memoriaRam.getFabricante());
        memroiaRamDTO.setCapacidade(memoriaRam.getCapacidade());
        memroiaRamDTO.setFrequencia(memoriaRam.getFrequencia());
        memroiaRamDTO.setTipo(memoriaRam.getTipo());
        memroiaRamDTO.setConsumo(memoriaRam.getConsumo());
        return memroiaRamDTO;
    }

    public MemoriaRam convertToEntity(MemoriaRamDTO memoriaRamDTO) {
        MemoriaRam memroiaRam = new MemoriaRam();
        memroiaRam.setId(memoriaRamDTO.getId());
        memroiaRam.setNome(memoriaRamDTO.getNome());
        memroiaRam.setPreco(memoriaRamDTO.getPreco());
        memroiaRam.setFabricante(memoriaRamDTO.getFabricante());
        memroiaRam.setCapacidade(memoriaRamDTO.getCapacidade());
        memroiaRam.setFrequencia(memoriaRamDTO.getFrequencia());
        memroiaRam.setTipo(memoriaRamDTO.getTipo());
        memroiaRam.setConsumo(memoriaRamDTO.getConsumo());
        return memroiaRam;
    }
}
