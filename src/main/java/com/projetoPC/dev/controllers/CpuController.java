package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.CpuDTO;
import com.projetoPC.dev.services.CpuService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cpus")
public class CpuController {

    @Autowired
    CpuService cpuService;

    @PostMapping
    public ResponseEntity<CpuDTO> cadastrarCpu(@RequestBody CpuDTO cpuDTO) {
        return ResponseEntity.ok(cpuService.cadastrarCpu(cpuDTO));
    }

    @PostMapping("/{id}")
    public ResponseEntity<CpuDTO> atualizarCpu(@RequestBody CpuDTO cpuDTO, @PathVariable Long id) {
        return ResponseEntity.ok(cpuService.atualizarCpu(cpuDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCpu(@PathVariable Long id) {
        cpuService.deletarCpu(id);
        return ResponseEntity.noContent().build();
    }
}
