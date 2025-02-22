package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "componentes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Componentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false)
    private int potenciaConsumida;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false, length = 100)
    private String fabricante;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private double tamanho;

    @Column(nullable = true, length = 50)
    private String socketCpu;

    @Column(nullable = true, length = 50)
    private String pciCompatibilidade;
}
