package com.banco;

import com.banco.cadastro.Cliente;
import com.banco.cadastro.enums.TipoCliente;
import com.banco.modulos.Conta;
import com.banco.modulos.enums.TipoConta;
import com.banco.cadastro.Endereco;
import com.banco.cadastro.ClienteFisica;
import com.banco.services.AbrirContaService;
import com.banco.services.TransacaoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BancoApp {
    public static void main(String[] args) {

        // Construtores padrão
        AbrirContaService abrirConta = new AbrirContaService();
        TransacaoService transacao = new TransacaoService();



        // Criando uma conta corrente para pessoa fisica (Alison)
        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        ClienteFisica clienteAlison = new ClienteFisica("alison@gmail.com", "(11) 1234-5678", enderecoAlison, "Alison", "Silva", "123.456.789-10", "01/01/2000", TipoCliente.FISICA, null);

        List<Cliente> titularesContaAlison = new ArrayList<>(Arrays.asList(clienteAlison));

        Conta contaAlison = abrirConta.abrirContaFisica(titularesContaAlison, TipoConta.CORRENTE, 0.0);

        System.out.println();
        System.out.println("============================================================");
        System.out.println("Titular(es): " + contaAlison.getTitulares().get(0).getNomeCompeltoOuRazaoSocial());
        System.out.println("Agencia: " + contaAlison.getAgencia());
        System.out.println("Conta: " + contaAlison.getNumeroConta());
        System.out.println("Saldo: " + contaAlison.getSaldo());
        System.out.println("============================================================");
        System.out.println();



        // Criando uma conta corrente para pessoa fisica conjunta (José e Maria)
        Endereco enderecoJoseMaria = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        ClienteFisica clienteJose = new ClienteFisica("jose@gmail.com", "(11) 1234-5678", enderecoJoseMaria, "Jose", "Silva", "123.456.789-10", "01/01/2000", TipoCliente.FISICA, "123.456.789-11");

        ClienteFisica clienteMaria = new ClienteFisica("maria@gmail.com", "(11) 1234-5678", enderecoJoseMaria, "Maria", "Silva", "123.456.789-11", "01/01/2000", TipoCliente.FISICA, "123.456.789-10");

        List<Cliente> titularesContaJoseMaria = new ArrayList<>(Arrays.asList(clienteJose, clienteMaria));

        Conta contaJoseMaria = abrirConta.abrirContaFisicaConjunta(titularesContaJoseMaria, TipoConta.CORRENTE, 20.0);

        System.out.println();
        System.out.println("============================================================");
        System.out.println("Titular(es): " + contaJoseMaria.getTitulares().get(0).getNomeCompeltoOuRazaoSocial() + " e " + contaJoseMaria.getTitulares().get(1).getNomeCompeltoOuRazaoSocial());
        System.out.println("Agencia: " + contaJoseMaria.getAgencia());
        System.out.println("Conta: " + contaJoseMaria.getNumeroConta());
        System.out.println("Saldo: " + contaJoseMaria.getSaldo());
        System.out.println("============================================================");
        System.out.println();



//        // Realizando um deposito na conta corrente (Alison)
//        System.out.println("Saldo conta Alison antes do deposito: " + contaAlison.getSaldo());
//
//        Transacao depositarAlison100 = new Transacao(1, 100.0, TipoTransacao.DEPOSITO, "17/09/2023");
//        Transacao depositarAlison200 = new Transacao(2, 200.0, TipoTransacao.DEPOSITO, "17/09/2023");
//        transacao.deposito(contaAlison, depositarAlison100);
//        transacao.deposito(contaAlison, depositarAlison200);
//
//        System.out.println("Saldo Alison depois do deposito: " + contaAlison.getSaldo());
//        System.out.println("=================================");
//
//        // Realizando uma transferencia entre contas (Alison para Jose)
//        System.out.println("Saldo Alison antes da transferencia: " + contaAlison.getSaldo());
//        System.out.println("Saldo Jose antes da transferencia: " + contaJoseMaria.getSaldo());
//
//        Transacao transferirAlison50 = new Transacao(3, 50.0, TipoTransacao.TRANSFERENCIA, "17/09/2023");
//        transacao.transferencia(contaAlison, contaJoseMaria, transferirAlison50);
//
//        System.out.println("Saldo Alison depois da transferencia: " + contaAlison.getSaldo());
//        System.out.println("Saldo Jose depois da transferencia: " + contaJoseMaria.getSaldo());
//        System.out.println("=================================");
//
//        // Realizando uma transferencia entre contas (Jose para Alison)
//        System.out.println("Saldo Jose antes da transferencia: " + contaJoseMaria.getSaldo());
//        System.out.println("Saldo Alison antes da transferencia: " + contaAlison.getSaldo());
//
//        Transacao transferirJose30 = new Transacao(4, 30.0, TipoTransacao.TRANSFERENCIA, "18/09/2023");
//        transacao.transferencia(contaJoseMaria, contaAlison, transferirJose30);
//
//        System.out.println("Saldo Jose depois da transferencia: " + contaJoseMaria.getSaldo());
//        System.out.println("Saldo Alison depois da transferencia: " + contaAlison.getSaldo());
//        System.out.println("=================================");
//
//        // Criando uma conta poupanca para pessoa fisica (Com saldo menor que 50,00)
//        Endereco enderecoPoupanca = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");
//        PessoaFisica poupanca = new PessoaFisica("Alison", "Silva", "123.456.789-10", "01/01/2000", "alison@gmail.com", "(11) 1234-5678", enderecoPoupanca, EstadoCivil.SOLTEIRO, null);
//        Conta contaPoupanca = abrirConta.abrirContaFisica(poupanca, TipoConta.POUPANCA, 0.0);
//        System.out.println("=================================");
//
//        // Extrato das transações da conta Alison
//        System.out.println("Extrato da conta Alison:");
//        contaAlison.getExtrato().forEach(extrato -> {
//            System.out.println(extrato.getDataTransacao() + " " + extrato.getTipoTransacao().getDescricao() + " " + " " + extrato.getValorTransacao());
//        });
//        System.out.println("Saldo atual da conta R$ " + contaAlison.getSaldo());
//        System.out.println("=================================");
//
//        // Extrato das transações da conta Jose e Maria
//        System.out.println("Extrato da conta Jose e Maria:");
//        contaJoseMaria.getExtrato().forEach(extrato -> {
//            System.out.println(extrato.getDataTransacao() + " " + extrato.getTipoTransacao().getDescricao() + " " + " " + extrato.getValorTransacao());
//        });
//        System.out.println("Saldo atual da conta R$ " + contaJoseMaria.getSaldo());
//        System.out.println("=================================");

    }
}