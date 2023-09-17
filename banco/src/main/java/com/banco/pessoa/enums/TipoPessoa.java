package com.banco.pessoa.enums;

public enum TipoPessoa {

        FISICA("Física"),
        JURIDICA("Jurídica");

        private String tipoPessoa;

        TipoPessoa(String tipoPessoa) {
            this.tipoPessoa = tipoPessoa;
        }
}
