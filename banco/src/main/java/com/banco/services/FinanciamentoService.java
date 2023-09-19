package com.banco.services;

import com.banco.modulos.Conta;
import com.banco.modulos.Financiamento;
import com.banco.modulos.enums.GeradorNumeroFinanciamento;

import java.util.List;

public class FinanciamentoService {

    public FinanciamentoService() {
    }

    public void novoFinanciamento(Conta conta, double valorFinanciado, int quantidadeParcelas, double taxaJuros) {

        Financiamento financiamento = criarFinanciamento(valorFinanciado, quantidadeParcelas, taxaJuros);

        List<Financiamento> financiamentos = conta.getFinanciamentos();

        financiamentos.add(financiamento);

        conta.setFinanciamentos(financiamentos);

        System.out.println("Financiamento de R$ " + valorFinanciado + " realizado com sucesso!");

    }

    private Financiamento criarFinanciamento(double valorFinanciado, int quantidadeParcelas, double taxaJuros) {
        String numeroFinanciamento = GeradorNumeroFinanciamento.GeradorNumeroFinanciamento();
        double valorParcela = calcularValorParcela(valorFinanciado, quantidadeParcelas, taxaJuros);
        double valorTotalJuros = valorParcela * quantidadeParcelas - valorFinanciado;
        double valorTotalFinanciamento = valorFinanciado + valorTotalJuros;

        return new Financiamento(numeroFinanciamento, valorFinanciado, valorParcela, quantidadeParcelas, taxaJuros, valorTotalJuros, valorTotalFinanciamento, 0, 0.0, valorTotalFinanciamento);
    }

    private double calcularValorParcela(double valorFinanciado, int quantidadeParcelas, double taxaJuros) {
        double valorParcela = valorFinanciado / quantidadeParcelas;
        double valorJuros = valorParcela * taxaJuros;
        return valorParcela + valorJuros;
    }

}
