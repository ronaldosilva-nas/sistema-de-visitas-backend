package com.igreja.visitas.dto;

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

    private String nome;

    private String telefone;

    private String endereco;

    private int numero;

    private String bairro;

    private String cidade;
    
    private String observacao;
}
