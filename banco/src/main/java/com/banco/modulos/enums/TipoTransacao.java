package com.banco.modulos.enums;

public enum TipoTransacao {

    DEPOSITO("Depósito"),
    TRANSFERENCIA("Transferência"),
    SAQUE("Saque"),
    PAGAMENTO("Pagamento");

    private String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
