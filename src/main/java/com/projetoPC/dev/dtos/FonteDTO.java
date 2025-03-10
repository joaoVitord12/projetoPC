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
public class FonteDTO {

    private Long id;


    @NotBlank(message = "O nome da fabricante não pode estar em branco")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String fabricante;

    @NotNull(message = "A quantidade de energia não pode estar em branco")
    @Positive(message = "O preço deve ser um valor positivo")
    private BigDecimal preco;

    @NotNull(message = "A quantidade de potencia não pode estar em branco")
    @Positive(message = "A quantidade de potencia deve ser um valor positivo")
    private Integer potencia;

    private Integer efficiencyRating;

    public FonteDTO(){}

    public FonteDTO(Long id, String nome, BigDecimal preco, String fabricante, Integer potencia, Integer efficiencyRating) {
        this.id = id;
        this.fabricante = fabricante;
        this.preco = preco;
        this.potencia = potencia;
        this.efficiencyRating = efficiencyRating;
    }
}
