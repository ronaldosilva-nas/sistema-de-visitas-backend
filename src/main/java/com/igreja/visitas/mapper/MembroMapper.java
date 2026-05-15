package com.igreja.visitas.mapper;

import org.springframework.stereotype.Component;

import com.igreja.visitas.dto.MembroRequestDTO;
import com.igreja.visitas.dto.MembroResponseDTO;
import com.igreja.visitas.model.Membro;

@Component
public class MembroMapper {

    public Membro toEntity(MembroRequestDTO dto) {
        
        return Membro.builder()
            .nome(dto.getNome())
            .telefone(dto.getTelefone())
            .endereco(dto.getEndereco())
            .numero(dto.getNumero())
            .bairro(dto.getBairro())
            .cidade(dto.getCidade())
            .observacao(dto.getObservacao())
            .build();
    }

    public MembroResponseDTO toResponseDTO(Membro membro) {

        return MembroResponseDTO.builder()
            .id(membro.getId())
            .nome(membro.getNome())
            .telefone(membro.getTelefone())
            .endereco(membro.getEndereco())
            .numero(membro.getNumero())
            .bairro(membro.getBairro())
            .cidade(membro.getCidade())
            .observacao(membro.getObservacao())
            .visitado(membro.getVisitado())
            .dataCadastro(membro.getDataCadastro())
            .build();

    }

    public void updateEntity(MembroRequestDTO dto, Membro membro) {

        membro.setNome(dto.getNome());
        membro.setTelefone(dto.getTelefone());
        membro.setEndereco(dto.getEndereco());
        membro.setBairro(dto.getBairro());
        membro.setNumero(dto.getNumero());
        membro.setCidade(dto.getCidade());
        membro.setObservacao(dto.getObservacao());

    }
}
