package com.banco;

import com.banco.aplication.Conta;
import com.banco.aplication.Extrato;
import com.banco.aplication.Transacao;
import com.banco.aplication.enums.TipoConta;
import com.banco.aplication.enums.TipoTransacao;
import com.banco.pessoa.Endereco;
import com.banco.pessoa.PessoaFisica;
import com.banco.pessoa.enums.EstadoCivil;
import com.banco.services.AbrirContaFisicaService;
import com.banco.services.TransacaoService;

import java.util.Date;

public class BancoApp {
    public static void main(String[] args) {

        // Criando uma conta corrente para pessoa fisica
        Endereco endAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");
        PessoaFisica alison = new PessoaFisica("Alison", "Silva", "123.456.789-10", "01/01/2000", "alison@gmail.com", "(11) 1234-5678", endAlison, EstadoCivil.SOLTEIRO, null);
        AbrirContaFisicaService alisonServce = new AbrirContaFisicaService();
        Conta contaAlison = alisonServce.abrirContaFisica(alison, TipoConta.CORRENTE, 0.0);

        System.out.println("Titular: " + contaAlison.getPessoaFisicas().get(0).getNomeCompeltoOuRazaoSocial());
        System.out.println("Agencia: " + contaAlison.getAgencia());
        System.out.println("Conta: " + contaAlison.getConta());
        System.out.println("Saldo: " + contaAlison.getSaldo());
        System.out.println();

        // Criando uma conta corrente para pessoa fisica conjunta
        Endereco endAlisonJhennyfer = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");
        PessoaFisica alisonConjunta = new PessoaFisica("Alison", "Silva", "123.456.789-10", "01/01/2000", "alison@gmail.com", "(11) 1234-5678", endAlisonJhennyfer, EstadoCivil.CASADO, "123.456.789-11");
        PessoaFisica jhennyferConjunta = new PessoaFisica("Jhennyfer", "Silva", "123.456.789-11", "01/01/2000", "jhennyfer@gmail.com", "(11) 1234-5678", endAlisonJhennyfer, EstadoCivil.CASADO, "123.456.789-10");
        AbrirContaFisicaService alisonJhennyferService = new AbrirContaFisicaService();
        Conta contaAlisonJhennyfer = alisonJhennyferService.abrirContaFisicaConjunta(alisonConjunta, jhennyferConjunta, TipoConta.CORRENTE, 20.0);

        System.out.println("Titulares: " + contaAlisonJhennyfer.getPessoaFisicas().get(0).getNomeCompeltoOuRazaoSocial() + " e " + contaAlisonJhennyfer.getPessoaFisicas().get(1).getNomeCompeltoOuRazaoSocial());
        System.out.println("Agencia: " + contaAlisonJhennyfer.getAgencia());
        System.out.println("Conta: " + contaAlisonJhennyfer.getConta());
        System.out.println("Saldo: " + contaAlisonJhennyfer.getSaldo());
        System.out.println();

        // Realizando um deposito na conta corrente
        System.out.println("Saldo Alison antes do deposito: " + contaAlison.getSaldo());

        TransacaoService transacaoAlison = new TransacaoService();
        Transacao depositarAlison100 = new Transacao(1, 100.0, TipoTransacao.DEPOSITO, "17/09/2023");
        transacaoAlison.deposito(contaAlison, depositarAlison100);

        System.out.println("Saldo Alison depois do deposito: " + contaAlison.getSaldo());
        System.out.println();

        // Realizando uma transferencia entre contas (Alison para AlisonJhennyfer)
        System.out.println("Saldo Alison antes da transferencia: " + contaAlison.getSaldo());
        System.out.println("Saldo Alison e Jhennyfer antes da transferencia: " + contaAlisonJhennyfer.getSaldo());

        TransacaoService transacaoAlisonJhennyfer = new TransacaoService();
        Transacao transferirAlison50 = new Transacao(1, 50.0, TipoTransacao.TRANSFERENCIA, "17/09/2023");
        transacaoAlisonJhennyfer.transferencia(contaAlison, contaAlisonJhennyfer, transferirAlison50);

        System.out.println("Saldo Alison depois da transferencia: " + contaAlison.getSaldo());
        System.out.println("Saldo Alison e Jhennyfer depois da transferencia: " + contaAlisonJhennyfer.getSaldo());
        System.out.println();

        // Criando uma conta poupanca para pessoa fisica (Com saldo menor que 50,00)
        Endereco endPoup = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");
        PessoaFisica poupanca = new PessoaFisica("Alison", "Silva", "123.456.789-10", "01/01/2000", "alison@gmail.com", "(11) 1234-5678", endPoup, EstadoCivil.SOLTEIRO, null);
        AbrirContaFisicaService poupancaervce = new AbrirContaFisicaService();
        Conta contaPoupanca = alisonServce.abrirContaFisica(poupanca, TipoConta.POUPANCA, 0.0);

        System.out.println(contaAlison.gerarExtrato(contaAlison).toString());

    }
}