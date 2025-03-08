package com.projetoPC.dev.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Optional;

@Entity
@Table(name = "componentes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Componentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private Tipo tipo;

    @Column(nullable = false)
    private BigDecimal potenciaConsumida;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false, length = 100)
    private String fabricante;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private String tamanho;

    @Column(nullable = true, length = 50)
    private String pciCompatibilidade;

    @ManyToOne
    @JoinColumn(name = "id_socket_cpu", nullable = false)
    private SocketCPU SocketCpu;


}
