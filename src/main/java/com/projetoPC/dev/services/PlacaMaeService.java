package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.PlacaMaeDTO;
import com.projetoPC.dev.dtos.SocketCpuDTO;
import com.projetoPC.dev.exceptions.BusinessException;
import com.projetoPC.dev.models.PlacaMae;
import com.projetoPC.dev.models.SocketCPU;
import com.projetoPC.dev.repositories.PlacaMaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacaMaeService {

    private static final String MSG_PLACAMAE = "Placa mãe não encontrado";

    @Autowired private PlacaMaeRepository placaMaeRepository;

    @Autowired private SocketCpuService socketCpuService;

    public PlacaMaeDTO cadastrarPlacaMae(PlacaMaeDTO placaMaeDTO) {
        return convertToDTO(placaMaeRepository.save(convertToEntity(placaMaeDTO)));
    }

    public PlacaMaeDTO atualizarPlacaMae(PlacaMaeDTO placaMaeDTO) {
        PlacaMae placaMae = placaMaeRepository.findById(placaMaeDTO.getId()).orElseThrow(() ->
                new BusinessException(MSG_PLACAMAE));
        placaMae = convertToEntity(placaMaeDTO);
        return convertToDTO( placaMaeRepository.save(placaMae));
    }

    public void deletarPlacaMae(Long id) {
        PlacaMae placaMae = placaMaeRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_PLACAMAE));
        placaMaeRepository.delete(placaMae);
    }

    public List<PlacaMaeDTO> listarPlacaMaes() {
        List<PlacaMae> placaMaes = placaMaeRepository.findAll();
        return placaMaes.stream().map(this::convertToDTO).toList();
    }

    public PlacaMaeDTO buscarPlacaMaePorId(Long id) {
        PlacaMae placaMae = placaMaeRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_PLACAMAE));
        return convertToDTO(placaMae);
    }

    public PlacaMaeDTO buscarPlacaMaePorNome(String nome) {
        PlacaMae placaMae = placaMaeRepository.findByNome(nome);
        return convertToDTO(placaMae);
    }

    public PlacaMaeDTO convertToDTO(PlacaMae placaMae) {
        SocketCpuDTO socketCpuDTO = socketCpuService.convertToDTO(placaMae.getSocketCpu());

        PlacaMaeDTO placaMaeDTO = new PlacaMaeDTO(
                placaMae.getId(),
                placaMae.getNome(),
                placaMae.getPreco(),
                placaMae.getFabricante(),
                placaMae.getChipset(),
                placaMae.getQtdSlotsRam(),
                placaMae.getMaxRamSuportada(),
                placaMae.getTipoRamSuportado(),
                placaMae.getConsumo(),
                placaMae.getModelo(),
                socketCpuDTO
                );

        return placaMaeDTO;
    }

    public PlacaMae convertToEntity(PlacaMaeDTO placaMaeDTO) {
        SocketCPU socketCpu = socketCpuService.convertToEntity(placaMaeDTO.getSocketCpuDTO());

        PlacaMae placaMae = new PlacaMae(
                placaMaeDTO.getId(),
                placaMaeDTO.getNome(),
                placaMaeDTO.getPreco(),
                placaMaeDTO.getFabricante(),
                placaMaeDTO.getChipset(),
                placaMaeDTO.getQtdSlotsRam(),
                placaMaeDTO.getMaxRamSuportada(),
                placaMaeDTO.getTipoRamSuportado(),
                placaMaeDTO.getConsumo(),
                placaMaeDTO.getModelo(),
                socketCpu
        );
        return placaMae;
    }

}
