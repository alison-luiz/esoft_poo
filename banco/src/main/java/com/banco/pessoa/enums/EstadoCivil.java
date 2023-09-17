package com.banco.pessoa.enums;

public enum EstadoCivil {

    SOLTEIRO("Solteiro(a)"),
    CASADO("Casado(a)");

    private String descricao;

    EstadoCivil(String descricao) {
        this.descricao = descricao;
    }

}
