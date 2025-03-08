package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cpus")
public class CPUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private BigDecimal preco;
    private String fabricante;

    @ManyToOne
    @JoinColumn(name = "socket_id", nullable = false) // Referência ao soquete
    private SocketCPU socket;

    private Integer nucleos;
    private Integer threads;
    private BigDecimal potenciaConsumida;
}
