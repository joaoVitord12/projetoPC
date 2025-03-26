package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.GpuDTO;
import com.projetoPC.dev.dtos.GpuDTO;
import com.projetoPC.dev.exceptions.BusinessException;
import com.projetoPC.dev.models.Gpu;
import com.projetoPC.dev.models.Gpu;
import com.projetoPC.dev.models.SocketCPU;
import com.projetoPC.dev.repositories.GpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GpuService {
    
    private static final String MSG_GPU = "GPU não encontrado";

    @Autowired private GpuRepository gpuRepository;

    public GpuDTO cadastrarGpu(GpuDTO gpuDTO) {
        Gpu gpu = convertToEntity(gpuDTO);
        return convertToDTO(gpuRepository.save(gpu));
    }

    public GpuDTO atualizarGpu(GpuDTO gpuDTO){
        Gpu gpu = gpuRepository.findById(gpuDTO.getId()).orElseThrow(() ->
                new BusinessException(MSG_GPU));

        gpu = convertToEntity(gpuDTO);
        return convertToDTO(gpuRepository.save(gpu));
    }

    public void deletarGpu(Long id){
        Gpu gpu = gpuRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_GPU));
        gpuRepository.delete(gpu);
    }

    public List<GpuDTO> listarGpus( ) {
        List<Gpu> gpus = gpuRepository.findAll();
        return gpus.stream().map(this::convertToDTO).toList();
    }

    public GpuDTO buscarGpuPorId(Long id) {
        Gpu gpu = gpuRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_GPU));
        return convertToDTO(gpu);
    }

    public GpuDTO convertToDTO(Gpu gpu) {
        GpuDTO gpuDTO = new GpuDTO(
                gpu.getId(),
                gpu.getNome(),
                gpu.getPreco(),
                gpu.getConsumo(),
                gpu.getFabricante(),
                gpu.getMemoriaVRAM(),
                gpu.getBarramento(),
                gpu.getTipoMemoria()
        );
        return gpuDTO;
    }

    public Gpu convertToEntity(GpuDTO gpuDTO) {
        Gpu gpu = new Gpu(
                gpuDTO.getId(),
                gpuDTO.getNome(),
                gpuDTO.getPreco(),
                gpuDTO.getConsumo(),
                gpuDTO.getFabricante(),
                gpuDTO.getMemoriaVRAM(),
                gpuDTO.getBarramento(),
                gpuDTO.getTipoMemoria()
        );
        return gpu;
    }
}
