package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.MemoriaRamDTO;
import com.projetoPC.dev.services.MemoriaRamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memoria-ram")
public class MemoriaRamController {

    @Autowired private MemoriaRamService memoriaRamService;

    @GetMapping
    public ResponseEntity<List<MemoriaRamDTO>> listarMemoriaRams() {
        List<MemoriaRamDTO> list = memoriaRamService.listarMemoriaRams();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemoriaRamDTO> buscarMemoriaRamPorId(@PathVariable Long id) {
        return ResponseEntity.ok(memoriaRamService.buscarMemoriaRamPorId(id));
    }

    @PostMapping
    public ResponseEntity<MemoriaRamDTO> cadastrarMemoriaRam(@RequestBody MemoriaRamDTO memoriaRamDTO) {
        return ResponseEntity.ok(memoriaRamService.cadastrarMemoriaRam(memoriaRamDTO));
    }

    @PutMapping
    public ResponseEntity<MemoriaRamDTO> atualizarMemoriaRam(@RequestBody MemoriaRamDTO memoriaRamDTO) {
        return ResponseEntity.ok(memoriaRamService.atualizarMemoriaRam(memoriaRamDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMemoriaRam(@PathVariable Long id) {
        memoriaRamService.deletarMemoriaRam(id);
        return ResponseEntity.noContent().build();
    }
}
