package com.banco.cadastro;

import com.banco.cadastro.enums.TipoCliente;

public class ClienteFisica extends Cliente {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String dataNascimento;
    private TipoCliente tipoCliente;
    private String cpfConjuge;

    public ClienteFisica(String email, String telefone, Endereco endereco, String nome, String sobrenome, String cpf, String dataNascimento, TipoCliente tipoCliente, String cpfConjuge) {
        super(email, telefone, endereco);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.tipoCliente = tipoCliente;
        this.cpfConjuge = cpfConjuge;
    }

    @Override
    public String getNomeOuNomeFantasia() {
        return nome;
    }

    @Override
    public String getNomeCompeltoOuRazaoSocial() {
        return nome + " " + sobrenome;
    }

    @Override
    public String getCpfOuCnpj() {
        return cpf;
    }

    @Override
    public String getDataNascimentoOuDataAbertura() {
        return dataNascimento;
    }

    @Override
    public TipoCliente getEstadoCivilOuTipoSociedade() {
        return tipoCliente;
    }

    @Override
    public String getCpfConjugeOuCnpjSocio() {
        return cpfConjuge;
    }
}
