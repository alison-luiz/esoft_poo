package com.banco.modulos;

import com.banco.cadastro.Cliente;
import com.banco.modulos.enums.TipoConta;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    private String agencia;
    private String numeroConta;
    private Double saldo;
    private TipoConta tipoConta;
    private Boolean contaConjunta;
    private List<Cliente> titulares = new ArrayList<>();
    private List<Transacao> transacoes = new ArrayList<>();

    public Conta() {
    }

    public Conta(String agencia, String numeroConta, Double saldo, TipoConta tipoConta, Boolean contaConjunta, List<Cliente> titulares) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.contaConjunta = contaConjunta;
        this.titulares = titulares;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public Boolean getContaConjunta() {
        return contaConjunta;
    }

    public List<Cliente> getTitulares() {
        return titulares;
    }
}
