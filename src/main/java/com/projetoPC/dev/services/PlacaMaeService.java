package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.PlacaMaeDTO;
import com.projetoPC.dev.models.PlacaMae;
import com.projetoPC.dev.repositories.PlacaMaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlacaMaeService {

    @Autowired
    PlacaMaeRepository placaMaeRepository;

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

}
