package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.GpuDTO;
import com.projetoPC.dev.models.Gpu;
import com.projetoPC.dev.repositories.GpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GpuService {

    @Autowired
    GpuRepository gpuRepository;

    public GpuDTO cadastrarGpu(GpuDTO gpuDTO) {
        Gpu gpu = convertToEntity(gpuDTO);
        return convertToDTO(gpuRepository.save(gpu));
    }

    public GpuDTO atualizarGpu(GpuDTO gpuDTO) {
        Gpu gpu = gpuRepository.findById(gpuDTO.getId()).orElseThrow(() ->
                new IllegalArgumentException("GPU não encontrado com o ID: " + gpuDTO.getId()));
        gpu = convertToEntity(gpuDTO);
        gpuRepository.save(gpu);
        return convertToDTO(gpu);
    }

    public void deletarGpu(Long id) {
        Gpu gpu = gpuRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("GPU não encontrado com o ID: " + id));
        gpuRepository.delete(gpu);
    }

    public GpuDTO convertToDTO(Gpu gpu) {
        GpuDTO gpuDTO = new GpuDTO();
        gpuDTO.setId(gpu.getId());
        gpuDTO.setNome(gpu.getNome());
        gpuDTO.setPreco(gpu.getPreco());
        gpuDTO.setConsumo(gpu.getConsumo());
        gpuDTO.setFabricante(gpu.getFabricante());
        gpuDTO.setMemoriaVRAM(gpu.getMemoriaVRAM());
        gpuDTO.setTipoMemoria(gpu.getTipoMemoria());
        gpuDTO.setBarramento(gpu.getBarramento());
        return gpuDTO;
    }

    public Gpu convertToEntity(GpuDTO gpuDTO) {
        Gpu gpu = new Gpu();
        gpu.setId(gpuDTO.getId());
        gpu.setNome(gpuDTO.getNome());
        gpu.setPreco(gpuDTO.getPreco());
        gpu.setConsumo(gpuDTO.getConsumo());
        gpu.setFabricante(gpuDTO.getFabricante());
        gpu.setMemoriaVRAM(gpuDTO.getMemoriaVRAM());
        gpu.setTipoMemoria(gpuDTO.getTipoMemoria());
        gpu.setBarramento(gpuDTO.getBarramento());
        return gpu;
    }
}
