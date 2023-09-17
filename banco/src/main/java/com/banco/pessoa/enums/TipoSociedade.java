package com.banco.pessoa.enums;

public enum TipoSociedade {

    UNICO_SOCIO("Unico Socio"),
    SOCIEDADE_SIMPLES("Sociedade Simples");

    private String descricao;

    TipoSociedade(String descricao) {
        this.descricao = descricao;
    }

}
