package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.SocketCpuDTO;
import com.projetoPC.dev.dtos.UsuarioDTO;
import com.projetoPC.dev.models.SocketCPU;
import com.projetoPC.dev.models.Usuario;
import com.projetoPC.dev.repositories.SocketCpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocketCpuService {

    @Autowired SocketCpuRepository socketCpuRepository;

    public SocketCpuDTO cadastrarSocketCpu(SocketCpuDTO socketCpuDTO) {
        SocketCPU socketCpu = convertToEntity(socketCpuDTO);
        return convertToDTO(socketCpuRepository.save(socketCpu));
    }

    public SocketCpuDTO atualizarSocketCpu(SocketCpuDTO socketCpuDTO) {
        SocketCPU socketCpu = socketCpuRepository.findById(socketCpuDTO.getId()).orElseThrow(() ->
                new IllegalArgumentException("Socket CPU não encontrado com o ID: " + socketCpuDTO.getId()));
        socketCpu = convertToEntity(socketCpuDTO);
        socketCpuRepository.save(socketCpu);
        return convertToDTO(socketCpu);
    }

    public void deletarSocketCpu(Long id) {
        SocketCPU socketCpu = socketCpuRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Socket CPU não encontrado com o ID: " + id));
        socketCpuRepository.delete(socketCpu);
    }

    public SocketCpuDTO buscarSocketCpuPorId(Long id) {
        SocketCPU socketCpu = socketCpuRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Socket CPU não encontrado com o ID: " + id));
        return convertToDTO(socketCpu);
    }

    public List<SocketCpuDTO> listarSocketCpus() {
        List<SocketCPU> socketCpus = socketCpuRepository.findAll();
        return socketCpus.stream().map(this::convertToDTO).toList();
    }

    public SocketCPU convertToEntity(SocketCpuDTO socketCpuDTO){
        SocketCPU socketCPU = new SocketCPU();
        socketCPU.setId(socketCpuDTO.getId());
        socketCPU.setNome(socketCpuDTO.getNome());
        socketCPU.setDescricao(socketCpuDTO.getDescricao());
        return socketCPU;
    }

    public SocketCpuDTO convertToDTO(SocketCPU socketCpu){
        SocketCpuDTO socketCpuDTO = new SocketCpuDTO();
        socketCpuDTO.setId(socketCpu.getId());
        socketCpuDTO.setNome(socketCpu.getNome());
        socketCpuDTO.setDescricao(socketCpu.getDescricao());
        return socketCpuDTO;
    }



}
