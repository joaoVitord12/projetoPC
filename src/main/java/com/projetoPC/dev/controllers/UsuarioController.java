package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.UsuarioDTO;
import com.projetoPC.dev.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuarioDTO));
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
