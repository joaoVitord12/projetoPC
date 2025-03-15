package com.projetoPC.dev.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocketCpuDTO {

    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "A descrição não pode estar em branco")
    @Size(min = 2, max = 100, message = "A descrição deve ter entre 2 e 100 caracteres")
    private String descricao;

}
