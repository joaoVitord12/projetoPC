package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "computador_montagem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComputadorMontagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @OneToMany(mappedBy = "computadorMontagem", cascade = CascadeType.ALL)
    private List<ComponentesMontados> componentes;
}
