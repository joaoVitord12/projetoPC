package com.projetoPC.dev.dtos;

import com.projetoPC.dev.models.SocketCPU;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CpuDTO {

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

    @NotNull(message = "O campo 'socketCpu' é obrigatório.")
    private SocketCpuDTO socketCpuDTO;

    @Positive(message = "O campo 'nucleos' deve ser um número positivo.")
    private Integer nucleos;

    @Positive(message = "O campo 'threads' deve ser um número positivo.")
    private Integer threads;

    public CpuDTO(Long id, String nome, BigDecimal preco, BigDecimal consumo, String fabricante, SocketCpuDTO socketCpuDTO, Integer nucleos, Integer threads) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.consumo = consumo;
        this.fabricante = fabricante;
        this.socketCpuDTO = socketCpuDTO;
        this.nucleos = nucleos;
        this.threads = threads;
    }
}
