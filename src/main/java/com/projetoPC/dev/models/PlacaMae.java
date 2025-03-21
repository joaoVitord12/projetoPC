package com.projetoPC.dev.models;

import com.projetoPC.dev.enums.Modelo;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "placa_mae")
@Getter
@Setter
@NoArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private List<Modelo> modelo;

    @Column(nullable = true)
    private String tipoRamSuportado;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal consumo;

    @ManyToOne
    @JoinColumn(name = "socket_cpu_id", nullable = false)
    private SocketCPU socketCpu;

    public PlacaMae(Long id, String nome, BigDecimal preco, String fabricante, String chipset, Integer qtdSlotsRam, Integer maxRamSuportada, String tipoRamSuportado, BigDecimal consumo, List<Modelo> modelo, SocketCPU socketCpu) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.fabricante = fabricante;
        this.chipset = chipset;
        this.qtdSlotsRam = qtdSlotsRam;
        this.maxRamSuportada = maxRamSuportada;
        this.tipoRamSuportado = tipoRamSuportado;
        this.consumo = consumo;
        this.modelo = modelo;
        this.socketCpu = socketCpu;
    }
}
