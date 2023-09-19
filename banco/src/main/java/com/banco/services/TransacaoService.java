package com.banco.services;

import com.banco.modulos.Conta;
import com.banco.modulos.Transacao;
import com.banco.modulos.enums.TipoTransacao;

public class TransacaoService extends Transacao {

//    public TransacaoService() {
//    }
//
//    public void deposito(Conta conta, Transacao transacao) {
//
//        if (transacao.getTipoTransacao() != TipoTransacao.DEPOSITO) {
//            System.out.println("Tipo de transação inválida!");
//            return;
//        }
//
//        conta.setSaldo(conta.getSaldo() + transacao.getValorTransacao());
//
//        Extrato extrato = new Extrato(transacao);
//        conta.getExtrato().add(extrato);
//
//        System.out.println("Depósito de R$ " + transacao.getValorTransacao() + " realizado com sucesso!");
//
//    }
//
//    public void transferencia(Conta origem, Conta destino, Transacao transacao) {
//
//        if (transacao.getTipoTransacao() != TipoTransacao.TRANSFERENCIA) {
//            System.out.println("Tipo de transação inválida!");
//            return;
//        }
//
//        if (origem.getSaldo() < transacao.getValorTransacao()) {
//            System.out.println("Saldo insuficiente!");
//            return;
//        }
//
//        origem.setSaldo(origem.getSaldo() - transacao.getValorTransacao());
//        destino.setSaldo(destino.getSaldo() + transacao.getValorTransacao());
//
//        Transacao transacaoOrigem = new Transacao(transacao.getNumeroTransacao(), transacao.getValorTransacao()*-1, TipoTransacao.TRANSFERENCIA, transacao.getDataTransacao());
//        transacaoOrigem.getTipoTransacao().setDescricao("Transferência Enviada para " + destino.getPessoaFisicas().get(0).getNomeCompeltoOuRazaoSocial());
//        Extrato extratoOrigem = new Extrato(transacaoOrigem);
//        origem.getExtrato().add(extratoOrigem);
//
//        Transacao transacaoDestino = new Transacao(transacao.getNumeroTransacao(), transacao.getValorTransacao(), TipoTransacao.TRANSFERENCIA, transacao.getDataTransacao());
//        transacaoDestino.getTipoTransacao().setDescricao("Transferência Recebida de " + origem.getPessoaFisicas().get(0).getNomeCompeltoOuRazaoSocial());
//        Extrato extratoDestino = new Extrato(transacaoDestino);
//        destino.getExtrato().add(extratoDestino);
//
//        System.out.println("Transferência de R$ " + transacao.getValorTransacao() + " realizada com sucesso!");
//
//    }

}
