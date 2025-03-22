package com.projetoPC.dev.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class MemoriaRamDTO {

    private Long id;


    private String nome;

    private BigDecimal preco;

    private String fabricante;

    private Integer capacidade;

    private Integer frequencia;

    private String tipo;

    private Integer consumo;

}
