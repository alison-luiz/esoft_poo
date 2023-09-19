package com.banco;

import com.banco.cadastro.Cliente;
import com.banco.cadastro.enums.TipoCliente;
import com.banco.modulos.Conta;
import com.banco.modulos.Transacao;
import com.banco.modulos.enums.TipoConta;
import com.banco.cadastro.Endereco;
import com.banco.cadastro.ClienteFisica;
import com.banco.modulos.enums.TipoTransacao;
import com.banco.services.AbrirContaService;
import com.banco.services.FinanciamentoService;
import com.banco.services.TransacaoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BancoApp {
    public static void main(String[] args) {

        // Construtores padrão
        AbrirContaService abrirConta = new AbrirContaService();
        TransacaoService transacao = new TransacaoService();



        // Criando uma conta-corrente para pessoa fisica (Alison)
        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        ClienteFisica clienteAlison = new ClienteFisica("alison@gmail.com", "(11) 1234-5678", enderecoAlison, "Alison", "Silva", "123.456.789-10", "01/01/2000", TipoCliente.FISICA, null);

        List<Cliente> titularesContaAlison = new ArrayList<>(Arrays.asList(clienteAlison));

        Conta contaAlison = abrirConta.abrirContaFisica(titularesContaAlison, TipoConta.CORRENTE, 0.0);

        System.out.println();
        System.out.println("Criando conta-corrente para Alison");
        System.out.println("============================================================");
        System.out.println("Titular(es): " + contaAlison.getTitulares().get(0).getNomeCompeltoOuRazaoSocial());
        System.out.println("Agencia: " + contaAlison.getAgencia());
        System.out.println("Conta: " + contaAlison.getNumeroConta());
        System.out.println("Saldo: " + contaAlison.getSaldo());
        System.out.println("============================================================");
        System.out.println();



        // Criando uma conta-corrente para pessoa fisica conjunta (José e Maria)
        Endereco enderecoJoseMaria = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        ClienteFisica clienteJose = new ClienteFisica("jose@gmail.com", "(11) 1234-5678", enderecoJoseMaria, "Jose", "Silva", "123.456.789-10", "01/01/2000", TipoCliente.FISICA, "123.456.789-11");

        ClienteFisica clienteMaria = new ClienteFisica("maria@gmail.com", "(11) 1234-5678", enderecoJoseMaria, "Maria", "Silva", "123.456.789-11", "01/01/2000", TipoCliente.FISICA, "123.456.789-10");

        List<Cliente> titularesContaJoseMaria = new ArrayList<>(Arrays.asList(clienteJose, clienteMaria));

        Conta contaJoseMaria = abrirConta.abrirContaFisicaConjunta(titularesContaJoseMaria, TipoConta.CORRENTE, 20.0);

        System.out.println();
        System.out.println("Criando conta-corrente conjunta para Jose e Maria");
        System.out.println("============================================================");
        System.out.println("Titular(es): " + contaJoseMaria.getTitulares().get(0).getNomeCompeltoOuRazaoSocial() + " e " + contaJoseMaria.getTitulares().get(1).getNomeCompeltoOuRazaoSocial());
        System.out.println("Agencia: " + contaJoseMaria.getAgencia());
        System.out.println("Conta: " + contaJoseMaria.getNumeroConta());
        System.out.println("Saldo: " + contaJoseMaria.getSaldo());
        System.out.println("============================================================");
        System.out.println();



        // Realizando um deposito na conta corrente (Alison)
        System.out.println();
        System.out.println("Realizando um deposito na conta-corrente (Alison)");
        System.out.println("============================================================");
        System.out.println("Saldo conta Alison antes do deposito: " + contaAlison.getSaldo());

        Transacao depositarAlison100 = new Transacao(1, 100.0, TipoTransacao.DEPOSITO, "17/09/2023");
        Transacao depositarAlison30000 = new Transacao(2, 30000.0, TipoTransacao.DEPOSITO, "17/09/2023");
        transacao.deposito(contaAlison, depositarAlison100);
        transacao.deposito(contaAlison, depositarAlison30000);

        System.out.println("Saldo Alison depois do deposito: " + contaAlison.getSaldo());
        System.out.println("============================================================");
        System.out.println();



        // Realizando uma transferencia entre contas (Alison para Jose)
        System.out.println();
        System.out.println("Realizando uma transferencia entre contas (Alison para Jose)");
        System.out.println("============================================================");
        System.out.println("Saldo Alison antes da transferencia: " + contaAlison.getSaldo());
        System.out.println("Saldo Jose antes da transferencia: " + contaJoseMaria.getSaldo());
        System.out.println();

        Transacao transferirAlison50 = new Transacao(3, 50.0, TipoTransacao.TRANSFERENCIA, "18/09/2023");
        transacao.transferencia(contaAlison, contaJoseMaria, transferirAlison50);

        System.out.println();
        System.out.println("Saldo Alison depois da transferencia: " + contaAlison.getSaldo());
        System.out.println("Saldo Jose depois da transferencia: " + contaJoseMaria.getSaldo());
        System.out.println("============================================================");
        System.out.println();



        // Extrato das transações da conta Alison
        System.out.println();
        System.out.println("Extrato da conta Alison:");
        System.out.println("============================================================");
        contaAlison.getTransacoes().forEach(transacaoContaAlison -> {
            System.out.println(transacaoContaAlison.getDataTransacao() + " " + transacaoContaAlison.getTipoTransacao().getDescricao() + " " + " " + transacaoContaAlison.getValorTransacao());
        });
        System.out.println("Saldo atual da conta R$ " + contaAlison.getSaldo());
        System.out.println("============================================================");
        System.out.println();

        System.out.println();
        System.out.println("Extrato da conta Jose e Maria:");
        System.out.println("============================================================");
        contaJoseMaria.getTransacoes().forEach(transacoesContaJoseMaria -> {
            System.out.println(transacoesContaJoseMaria.getDataTransacao() + " " + transacoesContaJoseMaria.getTipoTransacao().getDescricao() + " " + " " + transacoesContaJoseMaria.getValorTransacao());
        });
        System.out.println("Saldo atual da conta R$ " + contaJoseMaria.getSaldo());
        System.out.println("============================================================");
        System.out.println();

        System.out.println();
        System.out.println("Extrato da conta Alison por data: 18/09/2023");
        System.out.println("============================================================");
        contaAlison.getTransacoesPorData("18/09/2023").forEach(transacaoContaAlison -> {
            System.out.println(transacaoContaAlison.getDataTransacao() + " " + transacaoContaAlison.getTipoTransacao().getDescricao() + " " + " " + transacaoContaAlison.getValorTransacao());
        });
        System.out.println("Saldo atual da conta R$ " + contaAlison.getSaldo());
        System.out.println("============================================================");



        // Realizar o financiamento de 50.000,00 para conta-corrente Alison
        System.out.println();
        System.out.println("Realizar o financiamento de 50.000,00 para conta-corrente Alison");
        System.out.println("============================================================");

        FinanciamentoService financiamentoAlison50k = new FinanciamentoService();
        financiamentoAlison50k.novoFinanciamento(contaAlison, 50000.0, 12, 0.05);

        System.out.println();
        System.out.println("Numero do financiamento............: " + contaAlison.getFinanciamentos().get(0).getNumeroFinanciamento());
        System.out.println("Valor do financiamento.............: R$ " + contaAlison.getFinanciamentos().get(0).getValorFinanciamento());
        System.out.println("Valor da parcela...................: R$ " + contaAlison.getFinanciamentos().get(0).getValorParcela());
        System.out.println("Quantidade de parcelas.............: " + contaAlison.getFinanciamentos().get(0).getQuantidadeParcelas());
        System.out.println("Taxa de juros......................: " + contaAlison.getFinanciamentos().get(0).getTaxaJuros() + "%");
        System.out.println("Valor total de juros...............: R$ " + contaAlison.getFinanciamentos().get(0).getValorTotalJuros());
        System.out.println("Valor total do financiamento.......: R$ " + contaAlison.getFinanciamentos().get(0).getValorTotalFinanciamento());
        System.out.println("Quantidade de parcelas pagas.......: " + contaAlison.getFinanciamentos().get(0).getQuantidadeParcelasPagas());
        System.out.println("Valor total pago...................: R$ " + contaAlison.getFinanciamentos().get(0).getValorTotalPago());
        System.out.println("Valor restante a pagar.............: R$ " + contaAlison.getFinanciamentos().get(0).getValorRestanteAPagar());
        System.out.println();

        System.out.println("============================================================");
        System.out.println();



        // Realizar o pagamento de 5 parcelas do financiamento de 50.000,00 para conta-corrente Alison
        System.out.println();
        System.out.println("Realizar o pagamento de 5 parcelas do financiamento de 50.000,00 para conta-corrente Alison");
        System.out.println("============================================================");

        FinanciamentoService pagarParcelasAlison50k = new FinanciamentoService();
        pagarParcelasAlison50k.pagarParcelasDoFinanciamento(contaAlison, contaAlison.getFinanciamentos().get(0).getNumeroFinanciamento(), "5");

        System.out.println();
        System.out.println("Numero do financiamento............: " + contaAlison.getFinanciamentos().get(0).getNumeroFinanciamento());
        System.out.println("Valor do financiamento.............: R$ " + contaAlison.getFinanciamentos().get(0).getValorFinanciamento());
        System.out.println("Valor da parcela...................: R$ " + contaAlison.getFinanciamentos().get(0).getValorParcela());
        System.out.println("Quantidade de parcelas.............: " + contaAlison.getFinanciamentos().get(0).getQuantidadeParcelas());
        System.out.println("Taxa de juros......................: " + contaAlison.getFinanciamentos().get(0).getTaxaJuros() + "%");
        System.out.println("Valor total de juros...............: R$ " + contaAlison.getFinanciamentos().get(0).getValorTotalJuros());
        System.out.println("Valor total do financiamento.......: R$ " + contaAlison.getFinanciamentos().get(0).getValorTotalFinanciamento());
        System.out.println("Quantidade de parcelas pagas.......: " + contaAlison.getFinanciamentos().get(0).getQuantidadeParcelasPagas());
        System.out.println("Valor total pago...................: R$ " + contaAlison.getFinanciamentos().get(0).getValorTotalPago());
        System.out.println("Valor restante a pagar.............: R$ " + contaAlison.getFinanciamentos().get(0).getValorRestanteAPagar());
        System.out.println();

        System.out.println("============================================================");
        System.out.println();


    }
}