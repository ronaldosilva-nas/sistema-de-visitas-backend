package com.igreja.visitas.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.igreja.visitas.dto.MembroRequestDTO;
import com.igreja.visitas.dto.MembroResponseDTO;
import com.igreja.visitas.exceptions.MembroNotFoundException;
import com.igreja.visitas.mapper.MembroMapper;
import com.igreja.visitas.model.Membro;
import com.igreja.visitas.repository.MembroRepository;

@Service
public class MembroService {

    private final MembroMapper membroMapper;

    private final MembroRepository membroRepository;

    public MembroService(MembroRepository membroRepository, MembroMapper membroMapper) {
        this.membroRepository = membroRepository;
        this.membroMapper = membroMapper;
    }

    public MembroResponseDTO salvar(MembroRequestDTO dto) {
        Membro membro = membroMapper.toEntity(dto);
        Membro salvo = membroRepository.save(membro);
        MembroResponseDTO response = membroMapper.toResponseDTO(salvo);
        return response;
    }

    public Page<MembroResponseDTO> buscarTodos(Pageable pageable) {
        Page<Membro> membros = membroRepository.findAll(pageable);
        return membros.map(membro -> membroMapper.toResponseDTO(membro));
        
        //com lista retornando List<MembroResponseDTO>
        /*List<Membro> membros = membroRepository.findAll();
        List<MembroResponseDTO> response = membros.stream().map(m -> membroMapper.toResponseDTO(m)).toList();
        return response;*/
    }

    public MembroResponseDTO getMembroById(Long id) {
        Membro membro = membroRepository.findById(id).orElseThrow(() -> new MembroNotFoundException("Membro não encontrado"));
        MembroResponseDTO response = membroMapper.toResponseDTO(membro);
        return response;
    }

    public void deletar(Long id) {
        if(!membroRepository.existsById(id)) {
            throw new MembroNotFoundException("Membro não encontrado");
        }
        membroRepository.deleteById(id);
    }

    public MembroResponseDTO atualizar(Long id, MembroRequestDTO dto) {
        Membro existente = membroRepository.findById(id).orElseThrow(() -> new MembroNotFoundException("Membro não encontrado"));
        membroMapper.updateEntity(dto, existente);
        Membro atualizado = membroRepository.save(existente);
        MembroResponseDTO response = membroMapper.toResponseDTO(atualizado);
        return response;
    }
}
