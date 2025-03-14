package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.PlacaMaeDTO;
import com.projetoPC.dev.services.PlacaMaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/placa-mae")
public class PlacaMaeController {

    @Autowired PlacaMaeService placaMaeService;

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
