package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.SocketCpuDTO;
import com.projetoPC.dev.exceptions.BusinessException;
import com.projetoPC.dev.models.SocketCPU;
import com.projetoPC.dev.repositories.SocketCpuRepository;
import com.projetoPC.dev.specs.SocketCpuSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocketCpuService {

    private static final String MSG_SOCKETCPU = "Socket CPU não encontrado";

    @Autowired private SocketCpuRepository socketCpuRepository;

    @Autowired private SocketCpuSpec socketCpuSpec;

    public SocketCpuDTO cadastrarSocketCpu(SocketCpuDTO socketCpuDTO) {
        SocketCPU socketCpuNome = socketCpuRepository.findByNome(socketCpuDTO.getNome());
        socketCpuSpec.verificarNomeDuplicado(socketCpuNome);

        SocketCPU socketCpu = convertToEntity(socketCpuDTO);
        return convertToDTO(socketCpuRepository.save(socketCpu));
    }

    public SocketCpuDTO atualizarSocketCpu(SocketCpuDTO socketCpuDTO) {
        socketCpuSpec.verificarIdNulo(socketCpuDTO.getId());

        SocketCPU socketCpu = socketCpuRepository.findById(socketCpuDTO.getId()).orElseThrow(() ->
                new BusinessException(MSG_SOCKETCPU));

        socketCpuSpec.verificarNomeEmUso(socketCpu, socketCpuDTO);

        socketCpu = convertToEntity(socketCpuDTO);
        socketCpuRepository.save(socketCpu);
        return convertToDTO(socketCpu);
    }

    public void deletarSocketCpu(Long id) {
        SocketCPU socketCpu = socketCpuRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_SOCKETCPU));
        socketCpuRepository.delete(socketCpu);
    }

    public SocketCpuDTO buscarSocketCpuPorId(Long id) {
        SocketCPU socketCpu = socketCpuRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_SOCKETCPU));
        return convertToDTO(socketCpu);
    }

    public List<SocketCpuDTO> listarSocketCpus() {
        List<SocketCPU> socketCpus = socketCpuRepository.findAll();
        return socketCpus.stream().map(this::convertToDTO).toList();
    }

    public SocketCPU convertToEntity(SocketCpuDTO socketCpuDTO){
        SocketCPU socketCPU = new SocketCPU(
                socketCpuDTO.getId(),
                socketCpuDTO.getNome(),
                socketCpuDTO.getDescricao()
        );
        return socketCPU;
    }

    public SocketCpuDTO convertToDTO(SocketCPU socketCpu){
        SocketCpuDTO socketCpuDTO = new SocketCpuDTO(
            socketCpu.getId(),
            socketCpu.getNome(),
            socketCpu.getDescricao()
        );
        return socketCpuDTO;
    }
}
