package com.projetoPC.dev.specs;

import com.projetoPC.dev.dtos.UsuarioDTO;
import com.projetoPC.dev.exceptions.BusinessException;
import com.projetoPC.dev.models.Usuario;
import com.projetoPC.dev.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class UsuarioSpec {
    private static final String MSG_EMAIL = "Usuário já cadastrado com email: %s.";
    private static final String MSG_ID = "Id não pode ser nulo.";
    private static final String MSG_EMAIL_DUPLICADO = "Email já cadastrado.";

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void verificarEmailNulo(Usuario usuario) {
        if (isNull(usuario.getEmail())) throw new BusinessException(MSG_EMAIL_DUPLICADO);
    }

    public void verificarSeExisteUsuarioComEmailDuplicado(Usuario usuario) {
        if (nonNull(usuario)) {
            throw new BusinessException(
                    String.format(MSG_EMAIL, usuario.getEmail()));
        }
    }

    public void verificarCampoIdNulo(Long id) {
        if (isNull(id)) throw new BusinessException(MSG_ID);
    }

    public void verificarEmailEmUso(Usuario usuario, UsuarioDTO usuarioDTO) {
        boolean alterouEmail = !(usuario.getEmail().equals(usuarioDTO.getEmail()));

        if (alterouEmail) {
            boolean encontrouUsuarioComEmailInformado =
                    nonNull(usuarioRepository
                            .findByEmail(usuarioDTO.getEmail()));

            if(encontrouUsuarioComEmailInformado)
                throw new BusinessException(String.format(MSG_EMAIL,
                        usuarioDTO.getEmail()));
        }
    }

}
