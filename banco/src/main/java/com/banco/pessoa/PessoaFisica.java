package com.banco.pessoa;

import com.banco.pessoa.enums.EstadoCivil;
import com.banco.pessoa.enums.TipoPessoa;

import java.util.Date;

public class PessoaFisica implements Pessoa {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private String telefone;
    private Endereco endereco;
    private EstadoCivil estadoCivil;
    private String cpfConjuge;

    public PessoaFisica(String nome, String sobrenome, String cpf, String dataNascimento, String email, String telefone, Endereco endereco, EstadoCivil estadoCivil, String cpfConjuge) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
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
    public String getDocumento() {
        return cpf;
    }

    @Override
    public String getTipoPessoa() {
        return TipoPessoa.FISICA.name();
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

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public String getCpfConjuge() {
        return cpfConjuge;
    }
}
