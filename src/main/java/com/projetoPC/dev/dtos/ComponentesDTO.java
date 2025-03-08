package com.projetoPC.dev.dtos;

import com.projetoPC.dev.models.SocketCPU;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ComponentesDTO {

    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O tipo não pode estar em branco")
    @Size(min = 2, max = 50, message = "O tipo deve ter entre 2 e 50 caracteres")
    private String tipo;

    @NotBlank(message = "A quantidade de potencia consumida não pode estar em branco")
    @Size(min = 2, max = 50, message = "A quantidade de potencia consumida deve ter entre 2 e 50 caracteres")
    private BigDecimal potenciaConsumida;

    @NotBlank(message = "O preco não pode estar em branco")
    @Size(min = 2, max = 50, message = "O preco deve ter entre 2 e 50 caracteres")
    private BigDecimal preco;

    @NotBlank(message = "O fabricante não pode estar em branco")
    @Size(min = 2, max = 100, message = "O fabricante deve ter entre 2 e 100 caracteres")
    private String fabricante;

    @NotBlank(message = "A descrição não pode estar em branco")
    @Size(min = 2, max = 50, message = "A descrição deve ter entre 2 e 50 caracteres")
    private String descricao;

    @NotBlank(message = "O tamanho não pode estar em branco")
    @Size(min = 2, max = 50, message = "O tamanho deve ter entre 2 e 50 caracteres")
    private String tamanho;


    @NotBlank(message = "O pciCompatibilidade não pode estar em branco")
    @Size(min = 2, max = 50, message = "O pciCompatibilidade deve ter entre 2 e 50 caracteres")
    private String pciCompatibilidade;

    private SocketCPU socketCpu;

    public ComponentesDTO(){}

}
