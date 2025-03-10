package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "componentes_montados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComponentesMontados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "computador_montagem_id", nullable = false)
    private ComputadorMontagem computadorMontagem;

    @ManyToOne
    @JoinColumn(name = "cpu_id")
    private Cpu cpu;

    @ManyToOne
    @JoinColumn(name = "gpu_id")
    private Gpu gpu;

    @ManyToOne
    @JoinColumn(name = "placa_mae_id")
    private PlacaMae placaMae;

    @ManyToOne
    @JoinColumn(name = "fonte_id")
    private Fonte fonte;

    @ManyToOne
    @JoinColumn(name = "ram_id")
    private MemoriaRam memoriaRam;

    private Integer quantidadeRam;
}
