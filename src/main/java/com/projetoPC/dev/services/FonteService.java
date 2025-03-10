package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.FonteDTO;
import com.projetoPC.dev.models.Fonte;
import com.projetoPC.dev.repositories.FonteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FonteService {

    @Autowired FonteRepository fonteRepository;

    public FonteDTO cadastrarFonte(FonteDTO fonteDTO) {
        Fonte fonte = convertToEntity(fonteDTO);
        return convertToDTO(fonteRepository.save(fonte));
    }

    public FonteDTO atualizarFonte(FonteDTO fonteDTO) {
        Fonte fonte = fonteRepository.findById(fonteDTO.getId()).orElseThrow(() ->
                new IllegalArgumentException("Fonte não encontrado com o ID: " + fonteDTO.getId()));
        fonte = convertToEntity(fonteDTO);
        fonteRepository.save(fonte);
        return convertToDTO(fonte);
    }

    public void deletarFonte(Long id) {
        Fonte fonte = fonteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Fonte não encontrado com o ID: " + id));
        fonteRepository.delete(fonte);
    }


    public FonteDTO convertToDTO(Fonte fonte) {
        FonteDTO fonteDTO = new FonteDTO();
        fonteDTO.setId(fonte.getId());
        fonteDTO.setFabricante(fonte.getFabricante());
        fonteDTO.setPotencia(fonte.getPotencia());
        fonteDTO.setEfficiencyRating(fonte.getEfficiencyRating());
        return fonteDTO;
    }

    public Fonte convertToEntity(FonteDTO fonteDTO) {
        Fonte fonte = new Fonte();
        fonte.setId(fonteDTO.getId());
        fonte.setFabricante(fonteDTO.getFabricante());
        fonte.setPotencia(fonteDTO.getPotencia());
        fonte.setEfficiencyRating(fonteDTO.getEfficiencyRating());
        return fonte;
    }
}
