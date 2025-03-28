package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.FonteDTO;
import com.projetoPC.dev.services.FonteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fonte")
public class FonteController {

    @Autowired private FonteService fonteService;

    @GetMapping
    public ResponseEntity<List<FonteDTO>> listarFontes() {
        List<FonteDTO> list = fonteService.listarFontes();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FonteDTO> buscarFontePorId(@PathVariable Long id) {
        return ResponseEntity.ok(fonteService.buscarFontePorId(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<FonteDTO> buscarFontePorNome(@RequestParam String nome) {
        return ResponseEntity.ok(fonteService.buscarFontePorNome(nome));
    }

    @PostMapping
    public ResponseEntity<FonteDTO> cadastrarFonte(@RequestBody FonteDTO fonteDTO) {
        return ResponseEntity.ok(fonteService.cadastrarFonte(fonteDTO));
    }

    @PutMapping
    public ResponseEntity<FonteDTO> atualizarFonte(@RequestBody FonteDTO fonteDTO) {
        return ResponseEntity.ok(fonteService.atualizarFonte(fonteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFonte(@PathVariable Long id) {
        fonteService.deletarFonte(id);
        return ResponseEntity.noContent().build();
    }
}
