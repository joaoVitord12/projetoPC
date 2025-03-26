package com.projetoPC.dev.dtos;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class GpuDTO {

    private Long id;

    @NotBlank(message = "O campo 'nome' é obrigatório e não pode estar vazio.")
    @Size(max = 100, message = "O campo 'nome' deve ter no máximo 100 caracteres.")
    private String nome;

    @NotNull(message = "O campo 'preço' é obrigatório.")
    @DecimalMin(value = "0.00", inclusive = false, message = "O campo 'preço' deve ser maior que zero.")
    private BigDecimal preco;

    @NotNull(message = "O campo 'consumo' é obrigatório.")
    @DecimalMin(value = "0.00", inclusive = false, message = "O campo 'consumo' deve ser maior que zero.")
    private BigDecimal consumo;

    @NotBlank(message = "O campo 'fabricante' é obrigatório e não pode estar vazio.")
    @Size(max = 100, message = "O campo 'fabricante' deve ter no máximo 100 caracteres.")
    private String fabricante;

    @PositiveOrZero(message = "O campo 'memoriaVRAM' deve ser um valor positivo ou zero.")
    private Integer memoriaVRAM;

    @Size(max = 50, message = "O campo 'tipoMemoria' deve ter no máximo 50 caracteres.")
    private String tipoMemoria;

    @Size(max = 50, message = "O campo 'barramento' deve ter no máximo 50 caracteres.")
    private String barramento;

    public GpuDTO(Long id, String nome, BigDecimal preco, BigDecimal consumo, String fabricante, Integer memoriaVRAM, String barramento, String tipoMemoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.consumo = consumo;
        this.fabricante = fabricante;
        this.memoriaVRAM = memoriaVRAM;
        this.barramento = barramento;
        this.tipoMemoria = tipoMemoria;
    }
}