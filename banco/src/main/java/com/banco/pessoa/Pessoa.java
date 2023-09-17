package com.banco.pessoa;

import com.banco.pessoa.enums.EstadoCivil;

public interface Pessoa {

    String getNomeOuNomeFantasia();
    String getNomeCompeltoOuRazaoSocial();
    String getDocumento();
    String getTipoPessoa();
    Endereco getEndereco();
    String getTelefone();
    String getEmail();

}
