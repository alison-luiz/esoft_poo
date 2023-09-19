package com.banco.services;

import com.banco.cadastro.Cliente;
import com.banco.modulos.Conta;
import com.banco.modulos.enums.GeradorContaAleatoria;
import com.banco.modulos.enums.TipoConta;

import java.util.List;

public class AbrirContaService extends Conta {

    public AbrirContaService() {
    }

    public Conta abrirContaFisica(List<Cliente> titulares, TipoConta tipoConta, Double saldoInicial) {
        if (saldoInicial < 0) throw new RuntimeException("Saldo inicial não pode ser negativo");

        try {
            String agencia = "0718";
            String numeroConta = GeradorContaAleatoria.GeradorContaAleatoria();

            if (tipoConta == TipoConta.POUPANCA && saldoInicial < tipoConta.getValorMinimoAbertura()) {
                throw new RuntimeException("Saldo inicial insuficiente para abrir uma conta poupança!");
            }

            return new Conta(agencia, numeroConta, saldoInicial, tipoConta, false, titulares);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao abrir conta pessoa fisica");
        }
    }

    public Conta abrirContaFisicaConjunta(List<Cliente> titulares, TipoConta tipoConta, Double saldoInicial) {
        if (saldoInicial < 0) throw new RuntimeException("Saldo inicial não pode ser negativo");

        if (titulares.size() != 2) throw new RuntimeException("Conta conjunta deve ter apenas dois titulares");

        if (titulares.get(0).getCpfConjugeOuCnpjSocio() != titulares.get(1).getCpfOuCnpj()) throw new RuntimeException("CPF do segundo titular nao confere com o cadastrado no primeiro titular");

        try {
            String agencia = "0718";
            String conta = GeradorContaAleatoria.GeradorContaAleatoria();

            if (tipoConta == TipoConta.POUPANCA && saldoInicial < tipoConta.getValorMinimoAbertura()) {
                throw new RuntimeException("Saldo inicial insuficiente para abrir uma conta poupança!");
            }

            return new Conta(agencia, conta, saldoInicial, tipoConta, true, titulares);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao abrir conta fisica conjunta");
        }
    }

}
