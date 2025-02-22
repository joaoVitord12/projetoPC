package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "placas_mae")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlacaMae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String soqueteCpu;

    @Column(nullable = false)
    private int quantidadeSlotRam;

    @Column(nullable = false, length = 50)
    private String compatibilidadeGpu;

    @Column(nullable = false, length = 50)
    private String formato;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private double preco;
}
