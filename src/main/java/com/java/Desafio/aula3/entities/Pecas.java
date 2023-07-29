package com.java.Desafio.aula3.entities;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Pecas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="parte_number")
    private Integer parteNumber;

    @Column(name = "nome_da_peca", length = 50, nullable = false)
    private String nomeDaPeca;

    @Column(name = "descricao", length = 30, nullable = false)
    private String descricao;

    private Boolean  ativo;


}
