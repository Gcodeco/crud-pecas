package com.java.Desafio.aula3.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MensagemEnum {

    EXCLUSAO ("Registro Excluido Com Sucesso."),
    ALTERACAO ("Registro Alterado Com Sucesso."),
    INCLUSAO ("Registro Incluso Com Sucesso.");

    @Getter
    private String value;
}
