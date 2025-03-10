package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.GpuDTO;
import com.projetoPC.dev.services.GpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gpus")
public class GpuController {

    @Autowired GpuService gpuService;

    @PostMapping
    public ResponseEntity<GpuDTO> cadastrarGpu(@RequestBody GpuDTO gpuDTO) {
        return ResponseEntity.ok(gpuService.cadastrarGpu(gpuDTO));
    }

    @PostMapping("/{id}")
    public ResponseEntity<GpuDTO> atualizarGpu(@RequestBody GpuDTO gpuDTO, @org.springframework.web.bind.annotation.PathVariable Long id) {
        return ResponseEntity.ok(gpuService.atualizarGpu(gpuDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarGpu(@RequestBody GpuDTO gpuDTO) {
        gpuService.deletarGpu(gpuDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
