package com.projetoPC.dev.specs;

import com.projetoPC.dev.dtos.SocketCpuDTO;
import com.projetoPC.dev.dtos.UsuarioDTO;
import com.projetoPC.dev.exceptions.BusinessException;
import com.projetoPC.dev.models.SocketCPU;
import com.projetoPC.dev.models.Usuario;
import com.projetoPC.dev.repositories.SocketCpuRepository;
import com.projetoPC.dev.services.SocketCpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class SocketCpuSpec {

    private static final String MSG_ID = "Id não pode ser nulo.";
    private static final String MSG_NOME = "Nome já cadastrado.";

    @Autowired private SocketCpuRepository socketCpuRepository;

    public void verificarIdNulo(Long id) {
        if (isNull(id)) throw new BusinessException(MSG_ID);
    }

    public void verificarNomeDuplicado(SocketCPU socketCpu) {
        if (nonNull(socketCpu)) {
            throw new BusinessException("Nome já cadastrado.");
        }
    }

    public void verificarNomeEmUso(SocketCPU socketCPU, SocketCpuDTO socketCpuDTO) {
        boolean alterouNome = !(socketCPU.getNome().equals(socketCpuDTO.getNome()));

        if (alterouNome) {
            boolean encontrouUsuarioComNomeInformado =
                    nonNull(socketCpuRepository
                            .findByNome(socketCpuDTO.getNome()));

            if(encontrouUsuarioComNomeInformado)
                throw new BusinessException(String.format(MSG_NOME,
                        socketCpuDTO.getNome()));
        }
    }
}
