package com.projetoPC.dev.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class GpuDTO {

    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotNull(message = "O preço não pode estar em branco")
    @Positive(message = "O preço deve ser um valor positivo")
    private BigDecimal preco;

    @NotNull(message = "A quantidade de energia não pode estar em branco")
    @Positive(message = "A quantidade de energia deve ser um valor positivo")
    private BigDecimal consumo;

    @NotBlank(message = "O fabricante não pode estar em branco")
    @Size(min = 2, max = 100, message = "O fabricante deve ter entre 2 e 100 caracteres")
    private String fabricante;

    @NotNull(message = "A quantidade de VRAM não pode estar em branco")
    @Positive(message = "A quantidade de VRAM deve ser um valor positivo")
    private Integer memoriaVRAM;

    @NotBlank(message = "O tipo de memória não pode estar em branco")
    @Size(min = 2, max = 50, message = "O tipo de memória deve ter entre 2 e 50 caracteres")
    private String tipoMemoria;

    @NotBlank(message = "O barramento ( Versão do PCIE ) não pode estar em branco")
    @Size(min = 2, max = 50, message = "O barramento deve ter entre 2 e 50 caracteres")
    private String barramento;

    public GpuDTO(){}

    public GpuDTO(Long id, String nome, BigDecimal preco, BigDecimal consumo, String fabricante, Integer memoriaVRAM, String tipoMemoria, String barramento) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.consumo = consumo;
        this.fabricante = fabricante;
        this.memoriaVRAM = memoriaVRAM;
        this.tipoMemoria = tipoMemoria;
        this.barramento = barramento;
    }

}
