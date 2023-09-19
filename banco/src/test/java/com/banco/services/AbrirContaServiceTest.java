package com.banco.services;

public class AbrirContaServiceTest {

//    @Test
//    public void testAbrirContaCorrentePessoaFisica() {
//
//        AbrirContaService abrirConta = new AbrirContaService();
//
//        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");
//
//        ClienteFisica alison = new ClienteFisica("Alison", "Silva", "123.456.789-10", "01/01/2000", "alison@gmail.com", "(11) 1234-5678", enderecoAlison, EstadoCivil.SOLTEIRO, null);
//
//        Conta contaAlison = abrirConta.abrirContaFisica(alison, TipoConta.CORRENTE, 0.0);
//
//        String nomeCompleto = "Alison Silva";
//        Double saldo = 0.0;
//        TipoConta tipoConta = TipoConta.CORRENTE;
//
//        Assertions.assertEquals(nomeCompleto, contaAlison.getPessoaFisicas().get(0).getNomeCompeltoOuRazaoSocial());
//        Assertions.assertEquals(saldo, contaAlison.getSaldo());
//        Assertions.assertEquals(tipoConta, contaAlison.getTipoConta());
//
//    }
//
//    @Test
//    public void testAbrirContaPoupancaPessoaFisica() {
//
//        AbrirContaService abrirConta = new AbrirContaService();
//
//        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");
//
//        ClienteFisica alison = new ClienteFisica("Alison", "Silva", "123.456.789-10", "01/01/2000", "alison@gmail.com", "(11) 1234-5678", enderecoAlison, EstadoCivil.SOLTEIRO, null);
//
//        Conta contaAlison = abrirConta.abrirContaFisica(alison, TipoConta.POUPANCA, 50.0);
//
//        String nomeCompleto = "Alison Silva";
//        Double saldo = 50.0;
//        TipoConta tipoConta = TipoConta.POUPANCA;
//
//        Assertions.assertEquals(nomeCompleto, contaAlison.getPessoaFisicas().get(0).getNomeCompeltoOuRazaoSocial());
//        Assertions.assertEquals(saldo, contaAlison.getSaldo());
//        Assertions.assertEquals(tipoConta, contaAlison.getTipoConta());
//
//    }
//
//    @Test
//    public void testAbrirContaPoupancaPessoaFisicaSemValorMinimo() {
//
//        AbrirContaService abrirConta = new AbrirContaService();
//
//        Endereco enderecoAlison = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");
//
//        ClienteFisica alison = new ClienteFisica("Alison", "Silva", "123.456.789-10", "01/01/2000", "alison@gmail.com", "(11) 1234-5678", enderecoAlison, EstadoCivil.SOLTEIRO, null);
//
//        Conta contaAlison = abrirConta.abrirContaFisica(alison, TipoConta.POUPANCA, 0.0);
//
//        Assertions.assertNull(contaAlison);
//
//    }
//
//    @Test
//    public void testAbrirContaCorrentePessoaFisicaEmConjunto() {
//
//        AbrirContaService abrirConta = new AbrirContaService();
//
//        Endereco enderecoJoseMaria = new Endereco("Rua 1", "123", "Centro", "São Paulo", "SP", "12345-123");
//
//        ClienteFisica jose = new ClienteFisica("Jose", "Silva", "123.456.789-10", "01/01/2000", "jose@gmail.com", "(11) 1234-5678", enderecoJoseMaria, EstadoCivil.CASADO, "123.456.789-11");
//        ClienteFisica maria = new ClienteFisica("Maria", "Silva", "123.456.789-11", "01/01/2000", "maria@gmail.com", "(11) 1234-5678", enderecoJoseMaria, EstadoCivil.CASADO, "123.456.789-10");
//
//        Conta contaJoseMaria = abrirConta.abrirContaFisicaConjunta(jose, maria, TipoConta.CORRENTE, 20.0);
//
//        String nomeCompletoJose = "Jose Silva";
//        String nomeCompletoMaria = "Maria Silva";
//
//        Assertions.assertEquals(nomeCompletoJose, contaJoseMaria.getPessoaFisicas().get(0).getNomeCompeltoOuRazaoSocial());
//        Assertions.assertEquals(nomeCompletoMaria, contaJoseMaria.getPessoaFisicas().get(1).getNomeCompeltoOuRazaoSocial());
//
//    }

}
