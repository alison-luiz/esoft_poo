package com.banco.aplication;

import com.banco.aplication.enums.TipoConta;
import com.banco.pessoa.PessoaFisica;
import com.banco.pessoa.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class Conta extends Extrato {

    private String agencia;
    private String conta;
    private Double saldo;
    private TipoConta tipoConta;
    private Boolean conjunta;
    private List<PessoaFisica> pessoaFisicas;
    private List<PessoaJuridica> pessoaJuridicas;
    private List<Extrato> extrato = new ArrayList<>();

    public Conta() {
    }

    public Conta(List<Extrato> extrato) {
        if (extrato != null) {
            this.extrato = extrato;
        }
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

    public String getAgencia() {
        return agencia;
    }

    public String getConta() {
        return conta;
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

    public Boolean getConjunta() {
        return conjunta;
    }

    public List<PessoaFisica> getPessoaFisicas() {
        return pessoaFisicas;
    }

    public List<PessoaJuridica> getPessoaJuridicas() {
        return pessoaJuridicas;
    }

    public List<Extrato> getExtrato() {
        return extrato;
    }

    public void setExtrato(List<Extrato> extrato) {
        this.extrato = extrato;
    }

}
