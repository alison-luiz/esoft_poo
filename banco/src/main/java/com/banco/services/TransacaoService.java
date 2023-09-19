package com.banco.services;

import com.banco.modulos.Conta;
import com.banco.modulos.Transacao;
import com.banco.modulos.enums.TipoTransacao;

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

        List<Transacao> transacoes = conta.getTransacoes();
        Transacao transacaoNova = new Transacao(transacao.getNumeroTransacao(), transacao.getValorTransacao(), transacao.getTipoTransacao(), transacao.getDataTransacao());
        transacoes.add(transacaoNova);
        conta.setTransacoes(transacoes);

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

        List<Transacao> transacoesOrigem = origem.getTransacoes();
        Transacao transacaoOrigem = new Transacao(transacao.getNumeroTransacao(), transacao.getValorTransacao(), transacao.getTipoTransacao(), transacao.getDataTransacao());
        transacaoOrigem.setValorTransacao(transacao.getValorTransacao() * -1);
        transacoesOrigem.add(transacaoOrigem);
        origem.setTransacoes(transacoesOrigem);

        List<Transacao> transacaosDestino = destino.getTransacoes();
        Transacao transacaoDestino = new Transacao(transacao.getNumeroTransacao(), transacao.getValorTransacao(), transacao.getTipoTransacao(), transacao.getDataTransacao());
        transacaosDestino.add(transacaoDestino);
        destino.setTransacoes(transacaosDestino);

        System.out.println("Transferência de R$ " + transacao.getValorTransacao() + " realizada com sucesso!");

    }

}
