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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Membros", description = "Operações relacionadas ao gerenciamento de membros")
@RestController
@RequestMapping("/membros")
public class MembroController {

    private final MembroService membroService;

    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @Operation(summary = "Criar membro", description = "Adicionar um novo membro no sistema")
    @PostMapping
    public MembroResponseDTO criaMembro(@Valid @RequestBody MembroRequestDTO dto) {
        return membroService.salvar(dto);
    }

    @Operation(summary = "Listar membros", description = "Retorna todos os membros cadastrados")
    @GetMapping
    public List<MembroResponseDTO> listarMembros() {
        return membroService.buscarTodos();
    }

    @Operation(summary = "Buscar membro por ID", description = "Retorna um membro específico por ID")
    @GetMapping("/{id}")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Membro encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Membro não encontrado")
    })
    public MembroResponseDTO buscarMembroById(@PathVariable Long id) {
        return membroService.getMembroById(id);
    }

    @Operation(summary = "Deletar membro", description = "Deleta um membro específico por ID")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        membroService.deletar(id);
    }

    @Operation(summary = "Atualizar membro", description = "Atualiza os dados de um membro pelo ID informado")
    @PutMapping("/{id}")
    public MembroResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody MembroRequestDTO dto) {
        return membroService.atualizar(id, dto);
    }
}
