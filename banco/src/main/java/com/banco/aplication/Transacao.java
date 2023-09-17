package com.banco.aplication;

import com.banco.aplication.enums.TipoTransacao;

public class Transacao extends Conta {

    private Integer numeroTransacao;
    private Double valorTransacao;
    private TipoTransacao tipoTransacao;
   private String dataTransacao;

    public Transacao() {
    }

    public Transacao(Integer numeroTransacao, Double valorTransacao, TipoTransacao tipoTransacao, String dataTransacao) {
        this.numeroTransacao = numeroTransacao;
        this.valorTransacao = valorTransacao;
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
    }

    public Integer getNumeroTransacao() {
        return numeroTransacao;
    }

    public void setNumeroTransacao(Integer numeroTransacao) {
        this.numeroTransacao = numeroTransacao;
    }

    public Double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(Double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
