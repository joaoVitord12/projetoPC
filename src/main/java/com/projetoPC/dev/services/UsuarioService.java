package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.UsuarioDTO;
import com.projetoPC.dev.models.Usuario;
import com.projetoPC.dev.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        return convertToDTO(usuarioRepository.save(usuario));
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioRepository.findById(usuarioDTO.getId()).orElseThrow(() ->
                new IllegalArgumentException("Usuário não encontrado com o ID: " + usuarioDTO.getId()));
        usuario = convertToEntity(usuarioDTO);
        usuarioRepository.save(usuario);
        return convertToDTO(usuario);
    }

    public void deletarUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Usuário não encontrado com o ID: " + id));
        usuarioRepository.delete(usuario);
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
