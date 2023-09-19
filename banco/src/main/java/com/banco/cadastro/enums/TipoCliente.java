package com.banco.cadastro.enums;

public enum TipoCliente {

        FISICA("Física"),
        SOLTEIRO("Solteiro(a)"),
        CASADO("Casado(a)"),
        JURIDICA("Jurídica"),
        UNICO_SOCIO("Unico Socio"),
        SOCIEDADE_SIMPLES("Sociedade Simples");


        private String tipoCliente;

        TipoCliente(String tipoCliente) {
            this.tipoCliente = tipoCliente;
        }
}
