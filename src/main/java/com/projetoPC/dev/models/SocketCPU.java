package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "socket_cpu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocketCPU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = true)
    private String descricao;
}
