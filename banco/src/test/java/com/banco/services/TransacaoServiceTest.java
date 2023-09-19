package com.banco.services;

import com.banco.cadastro.Cliente;
import com.banco.cadastro.ClienteFisica;
import com.banco.cadastro.Endereco;
import com.banco.cadastro.enums.TipoCliente;
import com.banco.modulos.Conta;
import com.banco.modulos.Transacao;
import com.banco.modulos.enums.TipoConta;
import com.banco.modulos.enums.TipoTransacao;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransacaoServiceTest {

    @Test
    public void testarDepositoContaCorrentePessoaFisica() {

        AbrirContaService abrirConta = new AbrirContaService();

        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        ClienteFisica clienteAlison = new ClienteFisica("alison@gmail.com", "(11) 1234-5678", enderecoAlison, "Alison", "Silva", "123.456.789-10", "01/01/2000", TipoCliente.FISICA, null);

        List<Cliente> titularesContaAlison = new ArrayList<>(Arrays.asList(clienteAlison));

        Conta contaAlison = abrirConta.abrirContaFisica(titularesContaAlison, TipoConta.CORRENTE, 0.0);

        assertAll("Verificar detalhes da conta",
                () -> assertEquals(0.0, contaAlison.getSaldo(), "Saldo inicial")
        );

        TransacaoService transacao = new TransacaoService();

        Transacao depositarAlison100 = new Transacao(1, 100.0, TipoTransacao.DEPOSITO, "17/09/2023");
        Transacao depositarAlison200 = new Transacao(2, 200.0, TipoTransacao.DEPOSITO, "17/09/2023");
        transacao.deposito(contaAlison, depositarAlison100);
        transacao.deposito(contaAlison, depositarAlison200);

        assertAll("Verificar detalhes da conta",
                () -> assertEquals(300.0, contaAlison.getSaldo(), "Saldo final")
        );

    }

    @Test
    public void testarTransferenciaContaCorrentePessoaFisica() {
        AbrirContaService abrirConta = new AbrirContaService();

        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        ClienteFisica clienteAlison = new ClienteFisica("alison@gmail.com", "(11) 1234-5678", enderecoAlison, "Alison", "Silva", "123.456.789-10", "01/01/2000", TipoCliente.FISICA, null);

        List<Cliente> titularesContaAlison = new ArrayList<>(Arrays.asList(clienteAlison));

        Conta contaAlison = abrirConta.abrirContaFisica(titularesContaAlison, TipoConta.CORRENTE, 50.0);

        assertAll("Verificar detalhes da conta",
                () -> assertEquals(50.0, contaAlison.getSaldo(), "Saldo inicial")
        );


        Endereco enderecoJoseMaria = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        ClienteFisica clienteJose = new ClienteFisica("jose@gmail.com", "(11) 1234-5678", enderecoJoseMaria, "Jose", "Silva", "123.456.789-10", "01/01/2000", TipoCliente.FISICA, "123.456.789-11");

        ClienteFisica clienteMaria = new ClienteFisica("maria@gmail.com", "(11) 1234-5678", enderecoJoseMaria, "Maria", "Silva", "123.456.789-11", "01/01/2000", TipoCliente.FISICA, "123.456.789-10");

        List<Cliente> titularesContaJoseMaria = new ArrayList<>(Arrays.asList(clienteJose, clienteMaria));

        Conta contaJoseMaria = abrirConta.abrirContaFisicaConjunta(titularesContaJoseMaria, TipoConta.CORRENTE, 20.0);

        assertAll("Verificar detalhes da conta",
                () -> assertEquals(20.0, contaJoseMaria.getSaldo(), "Saldo inicial")
        );


        TransacaoService transacao = new TransacaoService();

        Transacao transferirAlison50 = new Transacao(3, 50.0, TipoTransacao.TRANSFERENCIA, "17/09/2023");
        transacao.transferencia(contaAlison, contaJoseMaria, transferirAlison50);

        assertAll("Verificar detalhes da conta",
                () -> assertEquals(0.0, contaAlison.getSaldo(), "Saldo final"),
                () -> assertEquals(70.0, contaJoseMaria.getSaldo(), "Saldo final")
        );

    }

}
