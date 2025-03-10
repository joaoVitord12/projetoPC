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
@AllArgsConstructor
public class Fonte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private BigDecimal preco;

    @Column(nullable = false, length = 50)
    private String fabricante;

    @Column(nullable = false)
    private Integer potencia;

    @Column(nullable = true, length = 50)
    private Integer efficiencyRating;
    }
