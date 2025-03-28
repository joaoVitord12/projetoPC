package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.GpuDTO;
import com.projetoPC.dev.services.GpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gpu")
public class GpuController {
    
    @Autowired
    private GpuService gpuService;

    @GetMapping
    public ResponseEntity<List<GpuDTO>> listarGpus() {
        List<GpuDTO> list = gpuService.listarGpus();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GpuDTO> buscarGpuPorId(@PathVariable Long id) {
        return ResponseEntity.ok(gpuService.buscarGpuPorId(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<GpuDTO> buscarGpuPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(gpuService.buscarGpuPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<GpuDTO> cadastrarGpu(@RequestBody GpuDTO gpuDTO) {
        return ResponseEntity.ok(gpuService.cadastrarGpu(gpuDTO));
    }

    @PutMapping
    public ResponseEntity<GpuDTO> atualizarGpu(@RequestBody GpuDTO gpuDTO) {
        return ResponseEntity.ok(gpuService.atualizarGpu(gpuDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGpu(@PathVariable Long id) {
        gpuService.deletarGpu(id);
        return ResponseEntity.noContent().build();
    }
}
