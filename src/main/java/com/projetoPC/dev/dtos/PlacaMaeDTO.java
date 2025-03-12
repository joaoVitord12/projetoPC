package com.projetoPC.dev.dtos;

import com.projetoPC.dev.models.SocketCPU;
import com.projetoPC.dev.models.Modelo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PlacaMaeDTO {

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

    @NotNull(message = "O chipset não pode estar em branco")
    @Size(min = 2, max = 50, message = "O chipset deve ter entre 2 e 50 caracteres")
    private String chipset;

    @NotNull(message = "A quantidade de slots de RAM não pode estar em branco")
    @Positive(message = "A quantidade de slots de RAM deve ser um valor positivo")
    private Integer qtdSlotsRam;

    @NotNull(message = "A quantidade de slots de RAM suportadas não pode estar em branco")
    @Positive(message = "A quantidade de slots de RAM suportadas deve ser um valor positivo")
    private Integer maxRamSuportada;

    @NotBlank(message = "O tipo de RAM suportado não pode estar em branco")
    @Size(min = 2, max = 50, message = "O tipo de RAM suportado deve ter entre 2 e 50 caracteres")
    private String tipoRamSuportado;

    @NotNull(message = "A quantidade de energia não pode estar em branco")
    @Positive(message = "A quantidade de energia deve ser um valor positivo")
    private BigDecimal consumo;

    private Modelo modelo;

    @NotNull(message = "O socket da CPU não pode estar em branco")
    private SocketCPU socketCpu;

    public PlacaMaeDTO(){}

    public PlacaMaeDTO(Long id, String nome, BigDecimal preco, String fabricante, String chipset, Integer qtdSlotsRam, Integer maxRamSuportada, String tipoRamSuportado, BigDecimal consumo, SocketCPU socketCpu, Modelo modelo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.fabricante = fabricante;
        this.chipset = chipset;
        this.qtdSlotsRam = qtdSlotsRam;
        this.maxRamSuportada = maxRamSuportada;
        this.tipoRamSuportado = tipoRamSuportado;
        this.consumo = consumo;
        this.socketCpu = socketCpu;
        this.modelo = modelo;
    }
}