package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.ComponentesDTO;
import com.projetoPC.dev.services.ComponentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/componentes")
public class ComponentesControllers {

    @Autowired ComponentesService componentesService;

    @PostMapping
    public ResponseEntity<ComponentesDTO> cadastrarComponentes(@RequestBody ComponentesDTO componentesDTO) {
        return ResponseEntity.ok(componentesService.cadastrarComponentes(componentesDTO));
    }
}
