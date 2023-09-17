package com.banco.services;

import com.banco.aplication.Conta;
import com.banco.aplication.Extrato;
import com.banco.aplication.Transacao;
import com.banco.aplication.enums.TipoTransacao;

public class TransacaoService extends Transacao {

    public TransacaoService() {
        super();
    }

    public void deposito(Conta conta, Transacao transacao) {

        if (transacao.getTipoTransacao() != TipoTransacao.DEPOSITO) {
            System.out.println("Tipo de transação inválida!");
            return;
        }

        conta.setSaldo(conta.getSaldo() + transacao.getValorTransacao());

        Extrato extrato = new Extrato(conta, transacao);

        System.out.println("Depósito realizado com sucesso!");

    }

    public void transferencia(Conta origem, Conta destino, Transacao transacao) {

        if (transacao.getTipoTransacao() != TipoTransacao.TRANSFERENCIA) {
            System.out.println("Tipo de transação inválida!");
            return;
        }

        if (origem.getSaldo() < transacao.getValorTransacao()) {
            System.out.println("Saldo insuficiente!");
            return;
        }

        origem.setSaldo(origem.getSaldo() - transacao.getValorTransacao());
        destino.setSaldo(destino.getSaldo() + transacao.getValorTransacao());

        Extrato extrato = new Extrato(origem, transacao);

        System.out.println("Transferência realizada com sucesso!");

    }

}
