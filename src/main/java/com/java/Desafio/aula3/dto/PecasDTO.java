package com.java.Desafio.aula3.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class PecasDTO {

    private Long id;

    private Integer parteNumber;

    private String nomeDaPeca;

    private String descricao;

    private String ativo;
}
