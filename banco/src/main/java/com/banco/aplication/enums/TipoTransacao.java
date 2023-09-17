package com.banco.aplication.enums;

public enum TipoTransacao {

    DEPOSITO("Depósito"),
    TRANSFERENCIA("Transferência");

    private String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }
}
