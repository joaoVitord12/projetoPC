package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "fontes")
@Getter
@Setter
@NoArgsConstructor
public class Fonte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String nome;

    @Column(nullable = false, length = 100)
    private BigDecimal preco;

    @Column(nullable = false, length = 50)
    private String fabricante;

    @Column(nullable = false)
    private Integer potencia;

    @Column(nullable = true, length = 50)
    private Integer efficiencyRating;

    public Fonte (Long id, BigDecimal preco, String fabricante, Integer potencia, Integer efficiencyRating, String nome) {
        this.id = id;
        this.preco = preco;
        this.fabricante = fabricante;
        this.potencia = potencia;
        this.efficiencyRating = efficiencyRating;
        this.nome = nome;
    }
}
