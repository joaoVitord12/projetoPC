package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

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
    private String nome;

    @Column(nullable = false)
    private int potencia;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false, length = 20)
    private String efficiencyRating;
}
