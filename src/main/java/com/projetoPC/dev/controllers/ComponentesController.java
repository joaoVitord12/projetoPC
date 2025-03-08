package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.ComponentesDTO;
import com.projetoPC.dev.services.ComponentesService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/componentes")
public class ComponentesController {

    @Autowired
    ComponentesService componentesService;

    @PostMapping
    public ResponseEntity<ComponentesDTO> cadastrarComponentes(@RequestBody ComponentesDTO componentesDTO) {
        return ResponseEntity.ok(componentesService.cadastrarComponentes(componentesDTO));
    }

    @GetMapping
    public ResponseEntity<List<ComponentesDTO>> listarComponentes() {
        return ResponseEntity.ok(componentesService.listarComponentes());
    }

}
