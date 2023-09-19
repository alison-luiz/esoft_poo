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
    private List<Financiamento> financiamentos = new ArrayList<>();

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

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public List<Transacao> getTransacoesPorData(String dataTranscao) {
        List<Transacao> transacoesPorData = new ArrayList<>();

        for (Transacao transacao : this.transacoes) {
            if (transacao.getDataTransacao().equals(dataTranscao)) {
                transacoesPorData.add(transacao);
            }
        }

        return transacoesPorData;
    }

    public List<Financiamento> getFinanciamentos() {
        return financiamentos;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void setContaConjunta(Boolean contaConjunta) {
        this.contaConjunta = contaConjunta;
    }

    public void setTitulares(List<Cliente> titulares) {
        this.titulares = titulares;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public void setFinanciamentos(List<Financiamento> financiamentos) {
        this.financiamentos = financiamentos;
    }
}
