package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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

    @Column(nullable = false)
    private Integer potencia;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false, length = 50)
    private String fabricante;

    @Column(nullable = true, length = 50)
    private String efficiencyRating;
    }
