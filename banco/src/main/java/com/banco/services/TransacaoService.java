package com.banco.services;

import com.banco.aplication.Conta;
import com.banco.aplication.Extrato;
import com.banco.aplication.Transacao;
import com.banco.aplication.enums.TipoTransacao;

import java.util.List;

public class TransacaoService extends Transacao {

    public TransacaoService() {
    }

    public void deposito(Conta conta, Transacao transacao) {

        if (transacao.getTipoTransacao() != TipoTransacao.DEPOSITO) {
            System.out.println("Tipo de transação inválida!");
            return;
        }

        conta.setSaldo(conta.getSaldo() + transacao.getValorTransacao());

        Extrato extrato = new Extrato(transacao);
        conta.getExtrato().add(extrato);

        System.out.println("Depósito de R$ " + transacao.getValorTransacao() + " realizado com sucesso!");

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

        Extrato extratoOrigem = new Extrato(transacao);
        origem.getExtrato().add(extratoOrigem);

        Extrato extratoDestino = new Extrato(transacao);
        destino.getExtrato().add(extratoDestino);

        System.out.println("Transferência de R$ " + transacao.getValorTransacao() + " realizada com sucesso!");

    }

}
