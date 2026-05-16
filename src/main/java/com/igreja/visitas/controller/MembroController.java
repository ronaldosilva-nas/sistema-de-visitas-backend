package com.igreja.visitas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igreja.visitas.dto.MembroRequestDTO;
import com.igreja.visitas.dto.MembroResponseDTO;
import com.igreja.visitas.service.MembroService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/membros")
public class MembroController {

    private final MembroService membroService;

    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @PostMapping
    public MembroResponseDTO criaMembro(@Valid @RequestBody MembroRequestDTO dto) {
        return membroService.salvar(dto);
    }

    @GetMapping
    public List<MembroResponseDTO> listarMembros() {
        return membroService.buscarTodos();
    }

    @GetMapping("/{id}")
    public MembroResponseDTO buscarMembroById(@PathVariable Long id) {
        return membroService.getMembroById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        membroService.deletar(id);
    }

    @PutMapping("/{id}")
    public MembroResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody MembroRequestDTO dto) {
        return membroService.atualizar(id, dto);
    }
}
