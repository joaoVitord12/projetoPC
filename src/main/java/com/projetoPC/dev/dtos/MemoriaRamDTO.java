package com.projetoPC.dev.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class MemoriaRamDTO {


    @NotNull(message = "O ID não pode ser nulo")
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres")
    private String nome;

    @NotNull(message = "O preço é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero")
    private BigDecimal preco;

    @NotBlank(message = "O fabricante é obrigatório")
    @Size(max = 255, message = "O fabricante deve ter no máximo 255 caracteres")
    private String fabricante;

    @NotNull(message = "A capacidade é obrigatória")
    @Min(value = 1, message = "A capacidade deve ser no mínimo 1")
    private Integer capacidade;

    @NotNull(message = "A frequência é obrigatória")
    @Min(value = 1, message = "A frequência deve ser no mínimo 1")
    private Integer frequencia;

    @NotBlank(message = "O tipo é obrigatório")
    @Size(max = 50, message = "O tipo deve ter no máximo 50 caracteres")
    private String tipo;

    public MemoriaRamDTO(Long id, String nome, BigDecimal preco, String fabricante, Integer capacidade, Integer frequencia, String tipo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.fabricante = fabricante;
        this.capacidade = capacidade;
        this.frequencia = frequencia;
        this.tipo = tipo;
    }
}
