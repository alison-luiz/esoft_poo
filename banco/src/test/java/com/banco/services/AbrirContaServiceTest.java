package com.banco.services;

import com.banco.cadastro.Cliente;
import com.banco.cadastro.ClienteFisica;
import com.banco.cadastro.Endereco;
import com.banco.cadastro.enums.TipoCliente;
import com.banco.modulos.Conta;
import com.banco.modulos.enums.TipoConta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AbrirContaServiceTest {

    @Test
    public void testAbrirContaCorrentePessoaFisica() {

        AbrirContaService abrirConta = new AbrirContaService();

        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        ClienteFisica clienteAlison = new ClienteFisica("alison@gmail.com", "(11) 1234-5678", enderecoAlison, "Alison", "Silva", "123.456.789-10", "01/01/2000", TipoCliente.FISICA, null);

        List<Cliente> titularesContaAlison = new ArrayList<>(Arrays.asList(clienteAlison));

        Conta contaAlison = abrirConta.abrirContaFisica(titularesContaAlison, TipoConta.CORRENTE, 0.0);

        assertAll("Verificar detalhes da conta",
                () -> assertEquals("Alison Silva", contaAlison.getTitulares().get(0).getNomeCompeltoOuRazaoSocial(), "Nome do titular"),
                () -> assertEquals(0.0, contaAlison.getSaldo(), "Saldo inicial"),
                () -> assertEquals(TipoConta.CORRENTE, contaAlison.getTipoConta(), "Tipo de conta")
        );

    }

    @Test
    public void testAbrirContaPoupancaPessoaFisica() {

        AbrirContaService abrirConta = new AbrirContaService();

        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        ClienteFisica clienteAlison = new ClienteFisica("alison@gmail.com", "(11) 1234-5678", enderecoAlison, "Alison", "Silva", "123.456.789-10", "01/01/2000", TipoCliente.FISICA, null);

        List<Cliente> titularesContaAlison = new ArrayList<>(Arrays.asList(clienteAlison));

        Conta contaAlison = abrirConta.abrirContaFisica(titularesContaAlison, TipoConta.POUPANCA, 50.0);

        assertAll("Verificar detalhes da conta",
                () -> assertEquals("Alison Silva", contaAlison.getTitulares().get(0).getNomeCompeltoOuRazaoSocial(), "Nome do titular"),
                () -> assertEquals(50.0, contaAlison.getSaldo(), "Saldo inicial"),
                () -> assertEquals(TipoConta.POUPANCA, contaAlison.getTipoConta(), "Tipo de conta")
        );

    }

    @Test
    public void testAbrirContaPoupancaPessoaFisicaSemValorMinimo() {

        AbrirContaService abrirConta = new AbrirContaService();

        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");

        ClienteFisica clienteAlison = new ClienteFisica("alison@gmail.com", "(11) 1234-5678", enderecoAlison, "Alison", "Silva", "123.456.789-10", "01/01/2000", TipoCliente.FISICA, null);

        List<Cliente> titularesContaAlison = new ArrayList<>(Arrays.asList(clienteAlison));

        assertThrows(RuntimeException.class, () -> {
            abrirConta.abrirContaFisica(titularesContaAlison, TipoConta.POUPANCA, 30.0);
        });

    }

}
