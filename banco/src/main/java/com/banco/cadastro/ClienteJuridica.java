package com.banco.cadastro;

import com.banco.cadastro.enums.TipoCliente;

public class ClienteJuridica extends Cliente {

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String dataAbertura;
    private TipoCliente tipoCliente;
    private String cnpjSocio;

    public ClienteJuridica(String email, String telefone, Endereco endereco, String razaoSocial, String nomeFantasia, String cnpj, String dataAbertura, TipoCliente tipoCliente, String cnpjSocio) {
        super(email, telefone, endereco);
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.dataAbertura = dataAbertura;
        this.tipoCliente = tipoCliente;
        this.cnpjSocio = cnpjSocio;
    }

    @Override
    public String getNomeOuNomeFantasia() {
        return nomeFantasia;
    }

    @Override
    public String getNomeCompeltoOuRazaoSocial() {
        return razaoSocial;
    }

    @Override
    public String getCpfOuCnpj() {
        return cnpj;
    }

    @Override
    public String getDataNascimentoOuDataAbertura() {
        return dataAbertura;
    }

    @Override
    public TipoCliente getEstadoCivilOuTipoSociedade() {
        return tipoCliente;
    }

    @Override
    public String getCpfConjugeOuCnpjSocio() {
        return cnpjSocio;
    }
}
