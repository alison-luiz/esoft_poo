package com.banco.services;

import com.banco.aplication.Conta;
import com.banco.aplication.enums.GeradorContaAleatoria;
import com.banco.aplication.enums.TipoConta;
import com.banco.pessoa.PessoaFisica;
import com.banco.pessoa.PessoaJuridica;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Objects;

public class AbrirContaFisicaService extends Conta {

    public AbrirContaFisicaService() {
    }

    public Conta abrirContaFisica(PessoaFisica pessoaFisica, TipoConta tipoConta, Double saldoInicial) {
        String agencia = "0718";
        String conta = GeradorContaAleatoria.GeradorContaAleatoria();

        if (tipoConta == TipoConta.POUPANCA && saldoInicial < tipoConta.getValorMinimoAbertura()) {
            System.out.println("Saldo inicial insuficiente para abrir uma conta poupança");
            return null;
        }

        Conta contaFisica = new Conta(agencia, conta, saldoInicial, tipoConta, false, List.of(pessoaFisica), null);

        return contaFisica;

    }

    public Conta abrirContaFisicaConjunta(PessoaFisica pessoaFisica, PessoaFisica conjuge, TipoConta tipoConta, Double saldoInicial) {
        if (!Objects.equals(pessoaFisica.getCpfConjuge(), conjuge.getDocumento())) {
            System.out.println("CPF do conjuge não confere");
            return null;
        }

        String agencia = "0718";
        String conta = GeradorContaAleatoria.GeradorContaAleatoria();

        Conta contaFisicaConjunta = new Conta(agencia, conta, saldoInicial, tipoConta, true, List.of(pessoaFisica, conjuge), null);

        return contaFisicaConjunta;

    }

}
