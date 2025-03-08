package com.projetoPC.dev.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "O email deve ser válido")
    private String email;

    @NotBlank(message = "A senha não pode estar em branco")
    @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
    private String senha;

    public UsuarioDTO(){}

    public UsuarioDTO(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
