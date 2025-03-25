package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "memoria_ram")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemoriaRam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String nome;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false, length = 100)
    private String fabricante;

    @Column(nullable = false)
    private Integer capacidade;

    @Column(nullable = false)
    private Integer frequencia;

    @Column(nullable = false, length = 10)
    private String tipo;

}
