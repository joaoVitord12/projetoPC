package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.MemoriaRamDTO;
import com.projetoPC.dev.dtos.SocketCpuDTO;
import com.projetoPC.dev.models.MemoriaRam;
import com.projetoPC.dev.models.SocketCPU;
import com.projetoPC.dev.repositories.MemoriaRamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoriaRamService {

    @Autowired private MemoriaRamRepository memoriaRamRepository;

    @Autowired private SocketCpuService socketCpuService;

    public MemoriaRamDTO cadastrarMemoriaRam(MemoriaRamDTO memoriaRamDTO) {
        return convertToDTO(memoriaRamRepository.save(convertToEntity(memoriaRamDTO)));
    }

    public MemoriaRamDTO atualizarMemoriaRam(MemoriaRamDTO memoriaRamDTO) {
        MemoriaRam memoriaRam = memoriaRamRepository.findById(memoriaRamDTO.getId()).orElseThrow(() ->
                new IllegalArgumentException("Placa MAE não encontrado com o ID: " + memoriaRamDTO.getId()));
        memoriaRam = convertToEntity(memoriaRamDTO);
        memoriaRamRepository.save(memoriaRam);
        return convertToDTO(memoriaRam);
    }

    public void deletarMemoriaRam(Long id) {
        MemoriaRam memoriaRam = memoriaRamRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Placa MAE não encontrado com o ID: " + id));
        memoriaRamRepository.delete(memoriaRam);
    }

    public List<MemoriaRamDTO> listarMemoriaRams() {
        List<MemoriaRam> memoriaRams = memoriaRamRepository.findAll();
        return memoriaRams.stream().map(this::convertToDTO).toList();
    }

    public MemoriaRamDTO buscarMemoriaRamPorId(Long id) {
        MemoriaRam memoriaRam = memoriaRamRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Placa MAE não encontrado com o ID: " + id));
        return convertToDTO(memoriaRam);
    }

    public MemoriaRamDTO convertToDTO(MemoriaRam memoriaRam) {
        MemoriaRamDTO memoriaRamDTO = new MemoriaRamDTO(
                memoriaRam.getId(),
                memoriaRam.getNome(),
                memoriaRam.getPreco(),
                memoriaRam.getFabricante(),
                memoriaRam.getChipset(),
                memoriaRam.getQtdSlotsRam(),
                memoriaRam.getMaxRamSuportada(),
                memoriaRam.getTipoRamSuportado(),
                memoriaRam.getConsumo(),
                memoriaRam.getModelo(),
                socketCpuDTO
                );

        return memoriaRamDTO;
    }

    public MemoriaRam convertToEntity(MemoriaRamDTO memoriaRamDTO) {
        MemoriaRam memoriaRam = new MemoriaRam(
                memoriaRamDTO.getId(),
                memoriaRamDTO.getNome(),
                memoriaRamDTO.getPreco(),
                memoriaRamDTO.getFabricante(),
                memoriaRamDTO.getChipset(),
                memoriaRamDTO.getQtdSlotsRam(),
                memoriaRamDTO.getMaxRamSuportada(),
                memoriaRamDTO.getTipoRamSuportado(),
                memoriaRamDTO.getConsumo(),
                memoriaRamDTO.getModelo(),
                socketCpu
        );
        return memoriaRam;
    }

}
