package com.banco.aplication;

import com.banco.aplication.enums.TipoConta;
import com.banco.pessoa.PessoaFisica;
import com.banco.pessoa.PessoaJuridica;

import java.util.List;

public class Conta extends Extrato {

    private String agencia;
    private String conta;
    private Double saldo;
    private TipoConta tipoConta;
    private Boolean conjunta;
    private List<PessoaFisica> pessoaFisicas;
    private List<PessoaJuridica> pessoaJuridicas;

    public Conta() {
    }

    public Conta(String agencia, String conta, Double saldo, TipoConta tipoConta, Boolean conjunta, List<PessoaFisica> pessoaFisicas, List<PessoaJuridica> pessoaJuridicas) {
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.conjunta = conjunta;
        this.pessoaFisicas = pessoaFisicas;
        this.pessoaJuridicas = pessoaJuridicas;
    }

    public Extrato gerarExtrato(Conta conta) {
        return new Extrato(conta, conta.getRegistroTransacao());
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Boolean getConjunta() {
        return conjunta;
    }

    public void setConjunta(Boolean conjunta) {
        this.conjunta = conjunta;
    }

    public List<PessoaFisica> getPessoaFisicas() {
        return pessoaFisicas;
    }

    public void setPessoaFisicas(List<PessoaFisica> pessoaFisicas) {
        this.pessoaFisicas = pessoaFisicas;
    }

    public List<PessoaJuridica> getPessoaJuridicas() {
        return pessoaJuridicas;
    }

    public void setPessoaJuridicas(List<PessoaJuridica> pessoaJuridicas) {
        this.pessoaJuridicas = pessoaJuridicas;
    }
}
