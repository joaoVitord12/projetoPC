package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.FonteDTO;
import com.projetoPC.dev.services.FonteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fontes")
public class FonteController {

    @Autowired FonteService fonteService;

    @PostMapping
    public ResponseEntity<FonteDTO> cadastrarFonte(@RequestBody FonteDTO fonteDTO) {
        return ResponseEntity.ok(fonteService.cadastrarFonte(fonteDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FonteDTO> atualizarFonte(@RequestBody FonteDTO fonteDTO, @PathVariable Long id) {
        return ResponseEntity.ok(fonteService.atualizarFonte(fonteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFonte(@PathVariable Long id) {
        fonteService.deletarFonte(id);
        return ResponseEntity.noContent().build();
    }
}
