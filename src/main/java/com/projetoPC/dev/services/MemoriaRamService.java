package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.MemoriaRamDTO;
import com.projetoPC.dev.dtos.SocketCpuDTO;
import com.projetoPC.dev.dtos.MemoriaRamDTO;
import com.projetoPC.dev.exceptions.BusinessException;
import com.projetoPC.dev.models.MemoriaRam;
import com.projetoPC.dev.models.SocketCPU;
import com.projetoPC.dev.models.MemoriaRam;
import com.projetoPC.dev.repositories.MemoriaRamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoriaRamService {
    private static final String MSG_MEMORIARAM = "GPU não encontrado";
    
    @Autowired private MemoriaRamRepository memoriaRamRepository;
    
    public MemoriaRamDTO cadastrarMemoriaRam(MemoriaRamDTO memoriaRamDTO) {
        MemoriaRam memoriaRam = convertToEntity(memoriaRamDTO);
        return convertToDTO(memoriaRamRepository.save(memoriaRam));
    }

    public MemoriaRamDTO atualizarMemoriaRam(MemoriaRamDTO memoriaRamDTO){
        MemoriaRam memoriaRam = memoriaRamRepository.findById(memoriaRamDTO.getId()).orElseThrow(() ->
                new BusinessException(MSG_MEMORIARAM));
        
        memoriaRam = convertToEntity(memoriaRamDTO);
        return convertToDTO(memoriaRamRepository.save(memoriaRam));
    }

    public void deletarMemoriaRam(Long id){
        MemoriaRam memoriaRam = memoriaRamRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_MEMORIARAM));
        memoriaRamRepository.delete(memoriaRam);
    }

    public List<MemoriaRamDTO> listarMemoriaRams( ) {
        List<MemoriaRam> memoriaRams = memoriaRamRepository.findAll();
        return memoriaRams.stream().map(this::convertToDTO).toList();
    }

    public MemoriaRamDTO buscarMemoriaRamPorId(Long id) {
        MemoriaRam memoriaRam = memoriaRamRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_MEMORIARAM));
        return convertToDTO(memoriaRam);
    }

    public MemoriaRamDTO convertToDTO (MemoriaRam memoriaRam) {
        MemoriaRamDTO memoriaRamDTO = new MemoriaRamDTO(
                memoriaRam.getId(),
                memoriaRam.getNome(),
                memoriaRam.getPreco(),
                memoriaRam.getFabricante(),
                memoriaRam.getCapacidade(),
                memoriaRam.getFrequencia(),
                memoriaRam.getTipo()
        );
        return memoriaRamDTO;
    }

    public MemoriaRam convertToEntity(MemoriaRamDTO memoriaRamDTO) {
        MemoriaRam memoriaRam = new MemoriaRam(
                memoriaRamDTO.getId(),
                memoriaRamDTO.getNome(),
                memoriaRamDTO.getPreco(),
                memoriaRamDTO.getFabricante(),
                memoriaRamDTO.getCapacidade(),
                memoriaRamDTO.getFrequencia(),
                memoriaRamDTO.getTipo()
        );
        return memoriaRam;
    }
}
