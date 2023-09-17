package com.banco.pessoa;

import com.banco.pessoa.enums.EstadoCivil;
import com.banco.pessoa.enums.TipoPessoa;
import com.banco.pessoa.enums.TipoSociedade;

public class PessoaJuridica implements Pessoa {

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String inscricaoEstadual;
    private String email;
    private String telefone;
    private Endereco endereco;
    private TipoSociedade tipoSociedade;
    private String cnpjSocio;

    @Override
    public String getNomeOuNomeFantasia() {
        return nomeFantasia;
    }

    @Override
    public String getNomeCompeltoOuRazaoSocial() {
        return razaoSocial;
    }

    @Override
    public String getDocumento() {
        return cnpj;
    }

    @Override
    public String getTipoPessoa() {
        return TipoPessoa.JURIDICA.name();
    }

    @Override
    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public TipoSociedade getTipoSociedade() {
        return tipoSociedade;
    }

    public String getCnpjSocio() {
        return cnpjSocio;
    }
}
