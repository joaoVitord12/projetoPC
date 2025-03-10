package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cpu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cpu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal consumo;

    @Column(nullable = false, length = 100)
    private String fabricante;

    @ManyToOne
    @JoinColumn(name = "socket_cpu_id", nullable = false)
    private SocketCpu socketCpu;

    @Column(nullable = true)
    private Integer nucleos;

    @Column(nullable = true)
    private Integer threads;
}
