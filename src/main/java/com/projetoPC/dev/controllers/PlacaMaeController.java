package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.PlacaMaeDTO;
import com.projetoPC.dev.services.PlacaMaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/placa-mae")
public class PlacaMaeController {

    @Autowired private PlacaMaeService placaMaeService;

    @GetMapping
    public ResponseEntity<List<PlacaMaeDTO>> listarPlacaMaes() {
        List<PlacaMaeDTO> list = placaMaeService.listarPlacaMaes();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlacaMaeDTO> buscarPlacaMaePorId(@PathVariable Long id) {
        return ResponseEntity.ok(placaMaeService.buscarPlacaMaePorId(id));
    }

    @GetMapping("nome")
    public ResponseEntity<PlacaMaeDTO> buscarPlacaMaePorNome(@RequestParam String nome) {
        return ResponseEntity.ok(placaMaeService.buscarPlacaMaePorNome(nome));
    }

    @PostMapping
    public ResponseEntity<PlacaMaeDTO> cadastrarPlacaMae(@RequestBody PlacaMaeDTO placaMaeDTO) {
        return ResponseEntity.ok(placaMaeService.cadastrarPlacaMae(placaMaeDTO));
    }

    @PutMapping
    public ResponseEntity<PlacaMaeDTO> atualizarPlacaMae(@RequestBody PlacaMaeDTO placaMaeDTO) {
        return ResponseEntity.ok(placaMaeService.atualizarPlacaMae(placaMaeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPlacaMae(@PathVariable Long id) {
        placaMaeService.deletarPlacaMae(id);
        return ResponseEntity.noContent().build();
    }


}
