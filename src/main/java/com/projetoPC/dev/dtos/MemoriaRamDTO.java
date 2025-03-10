package com.projetoPC.dev.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MemoriaRamDTO {

    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotNull(message = "O preço não pode estar em branco")
    @Positive(message = "O preço deve ser um valor positivo")
    private BigDecimal preco;

    @NotBlank(message = "O fabricante não pode estar em branco")
    @Size(min = 2, max = 100, message = "O fabricante deve ter entre 2 e 100 caracteres")
    private String fabricante;

    @NotNull(message = "A capacidade não pode estar em branco")
    @Positive(message = "A capacidade deve ser um valor positivo")
    private Integer capacidade;

    @NotNull(message = "A frequência não pode estar em branco")
    @Positive(message = "A frequência deve ser um valor positivo")
    private Integer frequencia;

    @NotBlank(message = "O tipo de memória não pode estar em branco")
    @Size(min = 2, max = 10, message = "O tipo de memória deve ter entre 2 e 10 caracteres")
    private String tipo;

    @NotNull(message = "A quantidade de energia não pode estar em branco")
    @Positive(message = "A quantidade de energia deve ser um valor positivo")
    private Integer consumo;

    public MemoriaRamDTO(){}

    public MemoriaRamDTO(Long id, String nome, BigDecimal preco, String fabricante, Integer capacidade, Integer frequencia, String tipo, Integer consumo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.fabricante = fabricante;
        this.capacidade = capacidade;
        this.frequencia = frequencia;
        this.tipo = tipo;
        this.consumo = consumo;
    }
}


