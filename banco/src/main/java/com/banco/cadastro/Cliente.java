package com.banco.cadastro;

import com.banco.cadastro.enums.TipoCliente;

public abstract class Cliente {

    private String email;
    private String telefone;
    private Endereco endereco;

    public Cliente(String email, String telefone, Endereco endereco) {
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public abstract String getNomeOuNomeFantasia();

    public abstract String getNomeCompeltoOuRazaoSocial();

    public abstract String getCpfOuCnpj();

    public abstract String getDataNascimentoOuDataAbertura();

    public abstract TipoCliente getEstadoCivilOuTipoSociedade();

    public abstract String getCpfConjugeOuCnpjSocio();

}
