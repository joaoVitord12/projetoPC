package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.MemoriaRamDTO;
import com.projetoPC.dev.services.MemoriaRamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/memoria-ram")
public class MemoriaRamController {

    @Autowired MemoriaRamService memoriaRamService;

    @PostMapping
    public ResponseEntity<MemoriaRamDTO> cadastrarMemoriaRam(@RequestBody MemoriaRamDTO memoriaRamDTO) {
        return ResponseEntity.ok(memoriaRamService.cadastrarMemoriaRam(memoriaRamDTO));
    }

    @PutMapping
    public ResponseEntity<MemoriaRamDTO> atualizarMemoriaRam(@RequestBody MemoriaRamDTO memoriaRamDTO) {
        return ResponseEntity.ok(memoriaRamService.atualizarMemoriaRam(memoriaRamDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMemoriaRam(@RequestBody MemoriaRamDTO memoriaRamDTO) {
        memoriaRamService.deletarMemoriaRam(memoriaRamDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
