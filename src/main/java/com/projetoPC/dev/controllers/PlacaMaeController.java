package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.PlacaMaeDTO;
import com.projetoPC.dev.services.PlacaMaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/placa-mae")
public class PlacaMaeController {

    @Autowired PlacaMaeService placaMaeService;

    public ResponseEntity<PlacaMaeDTO> cadastrarPlacaMae(@RequestBody PlacaMaeDTO placaMaeDTO) {
        return ResponseEntity.ok(placaMaeService.cadastrarPlacaMae(placaMaeDTO));
    }

    public ResponseEntity<PlacaMaeDTO> atualizarPlacaMae(@RequestBody PlacaMaeDTO placaMaeDTO) {
        return ResponseEntity.ok(placaMaeService.atualizarPlacaMae(placaMaeDTO));
    }

    public ResponseEntity<Void> deletarPlacaMae(@RequestBody PlacaMaeDTO placaMaeDTO) {
        placaMaeService.deletarPlacaMae(placaMaeDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
