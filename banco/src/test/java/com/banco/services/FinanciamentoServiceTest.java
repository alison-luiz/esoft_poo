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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinanciamentoServiceTest {

    @Test
    public void testFinanciamentoContaCorrenteFisica50k() {

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

        FinanciamentoService financiamentoAlison50k = new FinanciamentoService();

        financiamentoAlison50k.novoFinanciamento(contaAlison, 50000.0, 12, 0.05);

        assertAll("Verificar detalhes do financiamento",
            () -> assertEquals(50000.0, contaAlison.getFinanciamentos().get(0).getValorFinanciamento(), "Valor financiado"),
            () -> assertEquals(12, contaAlison.getFinanciamentos().get(0).getQuantidadeParcelas(), "Quantidade de parcelas"),
            () -> assertEquals(4375.0, contaAlison.getFinanciamentos().get(0).getValorParcela(), "Valor das parcelas")
        );

    }

}
