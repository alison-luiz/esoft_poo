package com.banco.modulos;

public class Financiamento {

    private String numeroFinanciamento;
    private Double valorFinanciamento;
    private Double valorParcela;
    private Integer quantidadeParcelas;
    private Double taxaJuros;
    private Double valorTotalJuros;
    private Double valorTotalFinanciamento;
    private Integer quantidadeParcelasPagas;
    private Double valorTotalPago;
    private Double valorRestanteAPagar;

    public Financiamento() {
    }

    public Financiamento(String numeroFinanciamento, Double valorFinanciamento, Double valorParcela, Integer quantidadeParcelas, Double taxaJuros, Double valorTotalJuros, Double valorTotalFinanciamento, Integer quantidadeParcelasPagas, Double valorTotalPago, Double valorRestanteAPagar) {
        this.numeroFinanciamento = numeroFinanciamento;
        this.valorFinanciamento = valorFinanciamento;
        this.valorParcela = valorParcela;
        this.quantidadeParcelas = quantidadeParcelas;
        this.taxaJuros = taxaJuros;
        this.valorTotalJuros = valorTotalJuros;
        this.valorTotalFinanciamento = valorTotalFinanciamento;
        this.quantidadeParcelasPagas = quantidadeParcelasPagas;
        this.valorTotalPago = valorTotalPago;
        this.valorRestanteAPagar = valorRestanteAPagar;
    }

    public String getNumeroFinanciamento() {
        return numeroFinanciamento;
    }

    public Double getValorFinanciamento() {
        return valorFinanciamento;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

    public Double getValorTotalJuros() {
        return valorTotalJuros;
    }

    public Double getValorTotalFinanciamento() {
        return valorTotalFinanciamento;
    }

    public Integer getQuantidadeParcelasPagas() {
        return quantidadeParcelasPagas;
    }

    public Double getValorTotalPago() {
        return valorTotalPago;
    }

    public Double getValorRestanteAPagar() {
        return valorRestanteAPagar;
    }

    public void setNumeroFinanciamento(String numeroFinanciamento) {
        this.numeroFinanciamento = numeroFinanciamento;
    }

    public void setValorFinanciamento(Double valorFinanciamento) {
        this.valorFinanciamento = valorFinanciamento;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public void setTaxaJuros(Double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public void setValorTotalJuros(Double valorTotalJuros) {
        this.valorTotalJuros = valorTotalJuros;
    }

    public void setValorTotalFinanciamento(Double valorTotalFinanciamento) {
        this.valorTotalFinanciamento = valorTotalFinanciamento;
    }

    public void setQuantidadeParcelasPagas(Integer quantidadeParcelasPagas) {
        this.quantidadeParcelasPagas = quantidadeParcelasPagas;
    }

    public void setValorTotalPago(Double valorTotalPago) {
        this.valorTotalPago = valorTotalPago;
    }

    public void setValorRestanteAPagar(Double valorRestanteAPagar) {
        this.valorRestanteAPagar = valorRestanteAPagar;
    }
}
