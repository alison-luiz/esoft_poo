package com.banco.aplication.enums;

public enum TipoConta {

    CORRENTE(0),
    POUPANCA(50),
    SALARIO(0);

    private Integer valorMinimoAbertura;

    TipoConta(Integer valorMinimoAbertura) {
        this.valorMinimoAbertura = valorMinimoAbertura;
    }

    public Integer getValorMinimoAbertura() {
        return valorMinimoAbertura;
    }

}
