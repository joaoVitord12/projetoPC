package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.CpuDTO;
import com.projetoPC.dev.services.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cpus")
public class CpuController {
    
    @Autowired
    private CpuService cpuService;

    @GetMapping
    public ResponseEntity<List<CpuDTO>> listarCpus() {
        List<CpuDTO> list = cpuService.listarCpus();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CpuDTO> buscarCpuPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cpuService.buscarCpuPorId(id));
    }

    @PostMapping
    public ResponseEntity<CpuDTO> cadastrarCpu(@RequestBody CpuDTO cpuDTO) {
        return ResponseEntity.ok(cpuService.cadastrarCpu(cpuDTO));
    }

    @PutMapping
    public ResponseEntity<CpuDTO> atualizarCpu(@RequestBody CpuDTO cpuDTO) {
        return ResponseEntity.ok(cpuService.atualizarCpu(cpuDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCpu(@PathVariable Long id) {
        cpuService.deletarCpu(id);
        return ResponseEntity.noContent().build();
    }
}
