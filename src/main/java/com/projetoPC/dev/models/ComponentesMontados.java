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
    @JoinColumn(name = "id_montagem", nullable = false)
    private Montagem montagem;

    @ManyToOne
    @JoinColumn(name = "id_componente", nullable = false)
    private Componentes componente;
}
