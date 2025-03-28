package com.projetoPC.dev.controllers;

import com.projetoPC.dev.dtos.SocketCpuDTO;
import com.projetoPC.dev.services.SocketCpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socket-cpu")
public class SocketCpuController {

    @Autowired private SocketCpuService socketCpuService;

    @GetMapping
    public ResponseEntity<List<SocketCpuDTO>> listarSocketCpus() {
        List<SocketCpuDTO> list = socketCpuService.listarSocketCpus();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SocketCpuDTO> buscarSocketCpuPorId(@PathVariable Long id) {
        return ResponseEntity.ok(socketCpuService.buscarSocketCpuPorId(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<SocketCpuDTO> buscarSocketCpuPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(socketCpuService.buscarSocketCpuPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<SocketCpuDTO> cadastrarSocketCpu(@RequestBody SocketCpuDTO socketCpuDTO) {
        return ResponseEntity.ok(socketCpuService.cadastrarSocketCpu(socketCpuDTO));
    }

    @PutMapping
    public ResponseEntity<SocketCpuDTO> atualizarSocketCpu(@RequestBody SocketCpuDTO socketCpuDTO) {
        return ResponseEntity.ok(socketCpuService.atualizarSocketCpu(socketCpuDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSocketCpu(@PathVariable Long id) {
        socketCpuService.deletarSocketCpu(id);
        return ResponseEntity.noContent().build();
    }
}
