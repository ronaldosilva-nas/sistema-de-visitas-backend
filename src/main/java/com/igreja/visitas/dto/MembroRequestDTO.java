package com.igreja.visitas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MembroRequestDTO {

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Campo telefone é obrigatório.")
    private String telefone;

    @NotBlank(message = "Campo endereço é obrigatório.")
    private String endereco;

    private Integer numero;

    @NotBlank(message = "Campo bairro é obrigatório.")
    private String bairro;

    @NotBlank(message = "Campo cidade é obrigatório.")
    private String cidade;
    
    private String observacao;
}
