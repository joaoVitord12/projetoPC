package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "gpu")
@Getter
@Setter
@NoArgsConstructor
public class Gpu {

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

    @Column(nullable = true)
    private Integer memoriaVRAM;

    @Column(nullable = true, length = 50)
    private String tipoMemoria;

    @Column(nullable = true)
    private String barramento;

    public Gpu(Long id, String nome, BigDecimal preco, BigDecimal consumo, String fabricante, Integer memoriaVRAM, String barramento, String tipoMemoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.consumo = consumo;
        this.fabricante = fabricante;
        this.memoriaVRAM = memoriaVRAM;
        this.barramento = barramento;
        this.tipoMemoria = tipoMemoria;
    }
}
