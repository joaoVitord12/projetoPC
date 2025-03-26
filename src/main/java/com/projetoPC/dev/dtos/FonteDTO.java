package com.projetoPC.dev.dtos;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class FonteDTO {

    private Long id;

    @NotNull(message = "O campo 'preço' é obrigatório.")
    @DecimalMin(value = "0.00", inclusive = false, message = "O campo 'preço' deve ser maior que zero.")
    private BigDecimal preco;

    @NotBlank(message = "O campo 'fabricante' é obrigatório e não pode estar vazio.")
    @Size(max = 50, message = "O campo 'fabricante' deve ter no máximo 50 caracteres.")
    private String fabricante;

    @NotNull(message = "O campo 'potência' é obrigatório.")
    @Positive(message = "O campo 'potência' deve ser um número positivo.")
    private Integer potencia;

    @PositiveOrZero(message = "O campo 'efficiencyRating' deve ser um valor positivo ou zero.")
    private Integer efficiencyRating;

    public FonteDTO(Long id, BigDecimal preco, String fabricante, Integer potencia, Integer efficiencyRating) {
        this.id = id;
        this.preco = preco;
        this.fabricante = fabricante;
        this.potencia = potencia;
        this.efficiencyRating = efficiencyRating;
    }
}
