package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.PlacaMaeDTO;
import com.projetoPC.dev.models.PlacaMae;
import com.projetoPC.dev.repositories.PlacaMaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacaMaeService {

    @Autowired PlacaMaeRepository placaMaeRepository;

    @Autowired SocketCpuService socketCpuService;

    public PlacaMaeDTO cadastrarPlacaMae(PlacaMaeDTO placaMaeDTO) {
        return convertToDTO(placaMaeRepository.save(convertToEntity(placaMaeDTO)));
    }

    public PlacaMaeDTO atualizarPlacaMae(PlacaMaeDTO placaMaeDTO) {
        PlacaMae placaMae = placaMaeRepository.findById(placaMaeDTO.getId()).orElseThrow(() ->
                new IllegalArgumentException("Placa MAE não encontrado com o ID: " + placaMaeDTO.getId()));
        placaMae = convertToEntity(placaMaeDTO);
        placaMaeRepository.save(placaMae);
        return convertToDTO(placaMae);
    }

    public void deletarPlacaMae(Long id) {
        PlacaMae placaMae = placaMaeRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Placa MAE não encontrado com o ID: " + id));
        placaMaeRepository.delete(placaMae);
    }

    public List<PlacaMaeDTO> listarPlacaMaes() {
        List<PlacaMae> placaMaes = placaMaeRepository.findAll();
        return placaMaes.stream().map(this::convertToDTO).toList();
    }

    public PlacaMaeDTO buscarPlacaMaePorId(Long id) {
        PlacaMae placaMae = placaMaeRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Placa MAE não encontrado com o ID: " + id));
        return convertToDTO(placaMae);
    }

    public PlacaMaeDTO convertToDTO(PlacaMae placaMae) {
        PlacaMaeDTO placaMaeDTO = new PlacaMaeDTO();
        placaMaeDTO.setId(placaMae.getId());
        placaMaeDTO.setNome(placaMae.getNome());
        placaMaeDTO.setPreco(placaMae.getPreco());
        placaMaeDTO.setFabricante(placaMae.getFabricante());
        placaMaeDTO.setChipset(placaMae.getChipset());
        placaMaeDTO.setQtdSlotsRam(placaMae.getQtdSlotsRam());
        placaMaeDTO.setMaxRamSuportada(placaMae.getMaxRamSuportada());
        placaMaeDTO.setTipoRamSuportado(placaMae.getTipoRamSuportado());
        placaMaeDTO.setConsumo(placaMae.getConsumo());

        placaMaeDTO.setModelo(placaMae.getModelo());

        placaMaeDTO.setSocketCpu(placaMae.getSocketCpu());

        return placaMaeDTO;
    }

    public PlacaMae convertToEntity(PlacaMaeDTO placaMaeDTO) {
        PlacaMae placaMae = new PlacaMae();
        placaMae.setNome(placaMaeDTO.getNome());
        placaMae.setPreco(placaMaeDTO.getPreco());
        placaMae.setFabricante(placaMaeDTO.getFabricante());
        placaMae.setChipset(placaMaeDTO.getChipset());
        placaMae.setQtdSlotsRam(placaMaeDTO.getQtdSlotsRam());
        placaMae.setMaxRamSuportada(placaMaeDTO.getMaxRamSuportada());
        placaMae.setTipoRamSuportado(placaMaeDTO.getTipoRamSuportado());
        placaMae.setConsumo(placaMaeDTO.getConsumo());

        placaMae.setSocketCpu(placaMaeDTO.getSocketCpu());

        placaMae.setModelo(placaMaeDTO.getModelo());
        return placaMae;
    }

}
