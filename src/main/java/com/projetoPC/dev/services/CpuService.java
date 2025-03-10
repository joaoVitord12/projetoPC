package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.CpuDTO;
import com.projetoPC.dev.dtos.UsuarioDTO;
import com.projetoPC.dev.models.Cpu;
import com.projetoPC.dev.repositories.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CpuService {

    @Autowired CpuRepository cpuRepository;

    public CpuDTO cadastrarCpu(CpuDTO cpuDTO) {
        Cpu cpu = convertToEntity(cpuDTO);
        return convertToDTO(cpuRepository.save(cpu));
    }

    public CpuDTO atualizarCpu(CpuDTO cpuDTO) {
        Cpu cpu = cpuRepository.findById(cpuDTO.getId()).orElseThrow(() ->
                new IllegalArgumentException("CPU não encontrado com o ID: " + cpuDTO.getId()));
        cpu = convertToEntity(cpuDTO);
        cpuRepository.save(cpu);
        return convertToDTO(cpu);
    }

    public void deletarCpu(Long id) {
        Cpu cpu = cpuRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("CPU não encontrado com o ID: " + id));
        cpuRepository.delete(cpu);
    }

    public CpuDTO convertToDTO(Cpu cpu) {
        CpuDTO cpuDTO = new CpuDTO();
        cpuDTO.setId(cpu.getId());
        cpuDTO.setNome(cpu.getNome());
        cpuDTO.setFabricante(cpu.getFabricante());
        return cpuDTO;
    }

    public Cpu convertToEntity(CpuDTO cpuDTO) {
        Cpu cpu = new Cpu();
        cpu.setId(cpuDTO.getId());
        cpu.setNome(cpuDTO.getNome());
        cpu.setFabricante(cpuDTO.getFabricante());
        return cpu;
    }
}
