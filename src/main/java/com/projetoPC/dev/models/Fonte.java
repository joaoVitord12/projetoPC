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

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private int potencia;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "efficiency_rating", nullable = false)
    private String eficiencia;

    @Column(name = "tipo_cabos", length = 255)
    private String tipoCabos;

    @Column(nullable = false)
    private String modularidade;

    @Column(name = "certificacao", nullable = false)
    private String certificacao;

}
