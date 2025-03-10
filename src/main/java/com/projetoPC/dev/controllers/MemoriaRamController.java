package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.MemoriaRamDTO;
import com.projetoPC.dev.services.MemoriaRamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/memoria-ram")
public class MemoriaRamController {

    @Autowired MemoriaRamService memoriaRamService;

    public ResponseEntity<MemoriaRamDTO> cadastrarMemoriaRam(@RequestBody MemoriaRamDTO memoriaRamDTO) {
        return ResponseEntity.ok(memoriaRamService.cadastrarMemoriaRam(memoriaRamDTO));
    }

    public ResponseEntity<MemoriaRamDTO> atualizarMemoriaRam(@RequestBody MemoriaRamDTO memoriaRamDTO) {
        return ResponseEntity.ok(memoriaRamService.atualizarMemoriaRam(memoriaRamDTO));
    }

    public ResponseEntity<Void> deletarMemoriaRam(@RequestBody MemoriaRamDTO memoriaRamDTO) {
        memoriaRamService.deletarMemoriaRam(memoriaRamDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
