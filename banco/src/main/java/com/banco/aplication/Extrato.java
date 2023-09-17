package com.banco.aplication;

public class Extrato {

    private Transacao registroTransacao;

    public Extrato() {
    }

    public Extrato(Conta conta, Transacao transacao) {
        this.registroTransacao = transacao;
    }

    protected Transacao getRegistroTransacao() {
        return registroTransacao;
    }
}
