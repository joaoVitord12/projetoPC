package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.FonteDTO;
import com.projetoPC.dev.exceptions.BusinessException;
import com.projetoPC.dev.models.Fonte;
import com.projetoPC.dev.repositories.FonteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FonteService {

    private static final String MSG_FONTE = "Fonte não encontrado";

    @Autowired
    private FonteRepository fonteRepository;

    public FonteDTO cadastrarFonte(FonteDTO fonteDTO) {
        return convertToDTO(fonteRepository.save(convertToEntity(fonteDTO)));
    }

    public FonteDTO atualizarFonte(FonteDTO fonteDTO) {
        Fonte fonte = fonteRepository.findById(fonteDTO.getId()).orElseThrow(() ->
                new BusinessException(MSG_FONTE));

        fonte = convertToEntity(fonteDTO);
        return convertToDTO(fonteRepository.save(fonte));
    }

    public void deletarFonte(Long id) {
        Fonte fonte = fonteRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_FONTE));
        fonteRepository.delete(fonte);
    }

    public List<FonteDTO> listarFontes() {
        List<Fonte> fontes = fonteRepository.findAll();
        return fontes.stream().map(this::convertToDTO).toList();
    }

    public FonteDTO buscarFontePorId(Long id) {
        Fonte fonte = fonteRepository.findById(id).orElseThrow(() ->
                new BusinessException(MSG_FONTE));
        return convertToDTO(fonte);
    }

    public FonteDTO buscarFontePorNome(String nome) {
        Fonte fonte = fonteRepository.findByNome(nome);
        return convertToDTO(fonte);
    }

    public FonteDTO convertToDTO(Fonte fonte) {
        FonteDTO fonteDTO = new FonteDTO(
                fonte.getId(),
                fonte.getPreco(),
                fonte.getFabricante(),
                fonte.getPotencia(),
                fonte.getEfficiencyRating(),
                fonte.getNome()
        );
        return fonteDTO;
    }

    public Fonte convertToEntity(FonteDTO fonteDTO) {
        Fonte fonte = new Fonte(
                fonteDTO.getId(),
                fonteDTO.getPreco(),
                fonteDTO.getFabricante(),
                fonteDTO.getPotencia(),
                fonteDTO.getEfficiencyRating(),
                fonteDTO.getNome()
        );
        return fonte;
    }
}
