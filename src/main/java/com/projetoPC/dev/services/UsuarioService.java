package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.UsuarioDTO;
import com.projetoPC.dev.exceptions.BusinessException;
import com.projetoPC.dev.models.Usuario;
import com.projetoPC.dev.repositories.UsuarioRepository;
import com.projetoPC.dev.specs.UsuarioSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private static final String MSG_USUARIO = "Usuário não encontrado";

    @Autowired private UsuarioRepository usuarioRepository;

    @Autowired private UsuarioSpec usuarioSpec;

    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioEmail = usuarioRepository.findByEmail(usuarioDTO.getEmail());
        usuarioSpec.verificarSeExisteUsuarioComEmailDuplicado(usuarioEmail);

        Usuario usuario = convertToEntity(usuarioDTO);
        return convertToDTO(usuarioRepository.save(usuario));
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO){
        usuarioSpec.verificarCampoIdNulo(usuarioDTO.getId());

        Usuario usuario = usuarioRepository.findById(usuarioDTO.getId()).orElseThrow(() ->
                new BusinessException(MSG_USUARIO));

        usuarioSpec.verificarEmailEmUso(usuario, usuarioDTO);

        usuario = convertToEntity(usuarioDTO);
        return convertToDTO(usuarioRepository.save(usuario));
    }

    public void deletarUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_USUARIO));
        usuarioRepository.delete(usuario);
    }

    public List<UsuarioDTO> listarUsuarios( ) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(this::convertToDTO).toList();
    }

    public UsuarioDTO buscarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_USUARIO));
        return convertToDTO(usuario);
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return convertToDTO(usuario);
    }

    public UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
        );
        return usuarioDTO;
    }

    public Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(
                usuarioDTO.getId(),
                usuarioDTO.getNome(),
                usuarioDTO.getEmail(),
                usuarioDTO.getSenha()
        );
        return usuario;
    }
}