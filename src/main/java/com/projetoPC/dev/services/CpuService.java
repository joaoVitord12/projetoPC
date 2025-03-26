package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.CpuDTO;
import com.projetoPC.dev.dtos.SocketCpuDTO;
import com.projetoPC.dev.exceptions.BusinessException;
import com.projetoPC.dev.models.Cpu;
import com.projetoPC.dev.models.SocketCPU;
import com.projetoPC.dev.repositories.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpuService {

    private static final String MSG_CPU = "CPU não encontrado";

    @Autowired private CpuRepository cpuRepository;
    
    @Autowired private SocketCpuService socketCpuService;

    public CpuDTO cadastrarCpu(CpuDTO cpuDTO) {
        return convertToDTO(cpuRepository.save(convertToEntity(cpuDTO)));
    }

    public CpuDTO atualizarCpu(CpuDTO cpuDTO) {
        Cpu cpu = cpuRepository.findById(cpuDTO.getId()).orElseThrow(() ->
                new BusinessException(MSG_CPU));
        cpu = convertToEntity(cpuDTO);
        return convertToDTO( cpuRepository.save(cpu));
    }

    public void deletarCpu(Long id) {
        Cpu cpu = cpuRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_CPU));
        cpuRepository.delete(cpu);
    }

    public List<CpuDTO> listarCpus() {
        List<Cpu> cpus = cpuRepository.findAll();
        return cpus.stream().map(this::convertToDTO).toList();
    }

    public CpuDTO buscarCpuPorId(Long id) {
        Cpu cpu = cpuRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_CPU));
        return convertToDTO(cpu);
    }

    public CpuDTO convertToDTO(Cpu cpu) {
        SocketCpuDTO socketCpuDTO = socketCpuService.convertToDTO(cpu.getSocketCpu());

        CpuDTO cpuDTO = new CpuDTO(
                cpu.getId(),
                cpu.getNome(),
                cpu.getPreco(),
                cpu.getConsumo(),
                cpu.getFabricante(),
                socketCpuDTO,
                cpu.getNucleos(),
                cpu.getThreads()
        );
        return cpuDTO;
    }

    public Cpu convertToEntity(CpuDTO cpuDTO) {
        SocketCPU socketCpu = socketCpuService.convertToEntity(cpuDTO.getSocketCpuDTO());

        Cpu cpu = new Cpu(
                cpuDTO.getId(),
                cpuDTO.getNome(),
                cpuDTO.getPreco(),
                cpuDTO.getConsumo(),
                cpuDTO.getFabricante(),
                socketCpu,
                cpuDTO.getNucleos(),
                cpuDTO.getThreads()
        );
        return cpu;
    }
}
