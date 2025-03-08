package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "montagens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Montagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDate dataMontagem;

    @Column(nullable = false)
    private BigDecimal custoTotal;

    @Column(nullable = false)
    private BigDecimal voltagemTotal;

    @Column(nullable = false)
    private BigDecimal potenciaFonteRecomendada;

    @Column(nullable = false)
    private BigDecimal consumoEstimadoKwh;

    @ManyToOne
    @JoinColumn(name = "id_fonte", nullable = false)
    private Fonte fonte;

    @ManyToOne
    @JoinColumn(name = "id_placa_mae", nullable = false)
    private PlacaMae placaMae;

    @OneToMany(mappedBy = "montagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComponentesMontados> componentesMontados;
}
