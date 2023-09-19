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
        conta.setSaldo(conta.getSaldo() + valorFinanciado);

        System.out.println("Financiamento de R$ " + valorFinanciado + " realizado com sucesso!");
        System.out.println("Valor do financiamento depositado na conta: R$ " + valorFinanciado);
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

    public void pagarParcelasDoFinanciamento(Conta conta, String numeroFinanciamento, String quantidadeDeParcelasAPagar) {
        Financiamento financiamento = conta.getFinanciamentoPeloNumero(numeroFinanciamento);

        double saldoDaConta = conta.getSaldo();
        double valorTotalDasParcelasAPagar = financiamento.getValorParcela() * Double.parseDouble(quantidadeDeParcelasAPagar);

        if (valorTotalDasParcelasAPagar > saldoDaConta) throw new RuntimeException("Saldo insuficiente para pagar as parcelas do financiamento");

        conta.setSaldo(saldoDaConta - valorTotalDasParcelasAPagar);
        financiamento.setQuantidadeParcelasPagas(financiamento.getQuantidadeParcelasPagas() + Integer.parseInt(quantidadeDeParcelasAPagar));
        financiamento.setValorTotalPago(financiamento.getValorTotalPago() + valorTotalDasParcelasAPagar);
        financiamento.setValorRestanteAPagar(financiamento.getValorRestanteAPagar() - valorTotalDasParcelasAPagar);

        System.out.println("Parcelas pagas com sucesso!");
    }

}
