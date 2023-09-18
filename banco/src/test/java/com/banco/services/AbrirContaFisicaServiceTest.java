package com.banco.services;

import com.banco.aplication.Conta;
import com.banco.aplication.enums.TipoConta;
import com.banco.pessoa.Endereco;
import com.banco.pessoa.PessoaFisica;
import com.banco.pessoa.enums.EstadoCivil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbrirContaFisicaServiceTest {

    @Test
    public void testAbrirContaCorrentePessoaFisica() {

        AbrirContaFisicaService abrirConta = new AbrirContaFisicaService();

        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        PessoaFisica alison = new PessoaFisica("Alison", "Silva", "123.456.789-10", "01/01/2000", "alison@gmail.com", "(11) 1234-5678", enderecoAlison, EstadoCivil.SOLTEIRO, null);

        Conta contaAlison = abrirConta.abrirContaFisica(alison, TipoConta.CORRENTE, 0.0);

        String nomeCompleto = "Alison Silva";
        Double saldo = 0.0;
        TipoConta tipoConta = TipoConta.CORRENTE;

        Assertions.assertEquals(nomeCompleto, contaAlison.getPessoaFisicas().get(0).getNomeCompeltoOuRazaoSocial());
        Assertions.assertEquals(saldo, contaAlison.getSaldo());
        Assertions.assertEquals(tipoConta, contaAlison.getTipoConta());

    }

    @Test
    public void testAbrirContaPoupancaPessoaFisica() {

        AbrirContaFisicaService abrirConta = new AbrirContaFisicaService();

        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        PessoaFisica alison = new PessoaFisica("Alison", "Silva", "123.456.789-10", "01/01/2000", "alison@gmail.com", "(11) 1234-5678", enderecoAlison, EstadoCivil.SOLTEIRO, null);

        Conta contaAlison = abrirConta.abrirContaFisica(alison, TipoConta.POUPANCA, 50.0);

        String nomeCompleto = "Alison Silva";
        Double saldo = 50.0;
        TipoConta tipoConta = TipoConta.POUPANCA;

        Assertions.assertEquals(nomeCompleto, contaAlison.getPessoaFisicas().get(0).getNomeCompeltoOuRazaoSocial());
        Assertions.assertEquals(saldo, contaAlison.getSaldo());
        Assertions.assertEquals(tipoConta, contaAlison.getTipoConta());

    }

    @Test
    public void testAbrirContaPoupancaPessoaFisicaSemValorMinimo() {

        AbrirContaFisicaService abrirConta = new AbrirContaFisicaService();

        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        PessoaFisica alison = new PessoaFisica("Alison", "Silva", "123.456.789-10", "01/01/2000", "alison@gmail.com", "(11) 1234-5678", enderecoAlison, EstadoCivil.SOLTEIRO, null);

        Conta contaAlison = abrirConta.abrirContaFisica(alison, TipoConta.POUPANCA, 0.0);

        Assertions.assertNull(contaAlison);

    }

    @Test
    public void testAbrirContaCorrentePessoaFisicaEmConjunto() {

        AbrirContaFisicaService abrirConta = new AbrirContaFisicaService();

        Endereco enderecoJoseMaria = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        PessoaFisica jose = new PessoaFisica("Jose", "Silva", "123.456.789-10", "01/01/2000", "jose@gmail.com", "(11) 1234-5678", enderecoJoseMaria, EstadoCivil.CASADO, "123.456.789-11");
        PessoaFisica maria = new PessoaFisica("Maria", "Silva", "123.456.789-11", "01/01/2000", "maria@gmail.com", "(11) 1234-5678", enderecoJoseMaria, EstadoCivil.CASADO, "123.456.789-10");

        Conta contaJoseMaria = abrirConta.abrirContaFisicaConjunta(jose, maria, TipoConta.CORRENTE, 20.0);

        String nomeCompletoJose = "Jose Silva";
        String nomeCompletoMaria = "Maria Silva";

        Assertions.assertEquals(nomeCompletoJose, contaJoseMaria.getPessoaFisicas().get(0).getNomeCompeltoOuRazaoSocial());
        Assertions.assertEquals(nomeCompletoMaria, contaJoseMaria.getPessoaFisicas().get(1).getNomeCompeltoOuRazaoSocial());

    }

}
