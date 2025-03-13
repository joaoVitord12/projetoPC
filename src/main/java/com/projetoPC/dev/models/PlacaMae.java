package com.projetoPC.dev.models;

import com.projetoPC.dev.enums.Modelo;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "placa_mae")
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

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false, length = 100)
    private String fabricante;

    @Column(nullable = false, length = 50)
    private String chipset;

    @Column(nullable = false)
    private Integer qtdSlotsRam;

    @Column(nullable = true)
    private Integer maxRamSuportada;

    @Column(nullable = false)
    private Modelo modelo;

    @Column(nullable = true)
    private String tipoRamSuportado;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal consumo;

    @ManyToOne
    @JoinColumn(name = "socket_cpu_id", nullable = false)
    private SocketCPU socketCpu;
}
