package com.banco.aplication;

import com.banco.aplication.enums.TipoTransacao;

public class Extrato {

    private Transacao registroTransacao;

    public Extrato(Transacao transacao) {
        this.registroTransacao = transacao;
    }

    public Extrato() {
        this.registroTransacao = registroTransacao;
    }

    public TipoTransacao getTipoTransacao() {
        return registroTransacao.getTipoTransacao();
    }

    public Double getValorTransacao() {
        return registroTransacao.getValorTransacao();
    }

    public String getDataTransacao() {
        return registroTransacao.getDataTransacao();
    }

    public Integer getNumeroTransacao() {
        return registroTransacao.getNumeroTransacao();
    }

    public Transacao getRegistroTransacao() {
        return registroTransacao;
    }

}
