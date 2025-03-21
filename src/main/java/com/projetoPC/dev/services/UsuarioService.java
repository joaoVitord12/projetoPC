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

    @Autowired UsuarioSpec usuarioSpec;

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
                new BusinessException("Usuário não encontrado com o ID: " + id));
        usuarioRepository.delete(usuario);
    }

    public List<UsuarioDTO> listarUsuarios( ) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(this::convertToDTO).toList();
    }

    public UsuarioDTO buscarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() ->
                new BusinessException("Usuário não encontrado com o ID: " + id));
        return convertToDTO(usuario);
    }

    public UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setSenha(usuario.getSenha());
        return usuarioDTO;
    }

    public Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        return usuario;
    }
}
