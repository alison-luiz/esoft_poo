package com.banco.modulos.enums;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GeradorContaAleatoria {
    public static String GeradorContaAleatoria() {
        Date dataAtual = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String ano = dateFormat.format(dataAtual).substring(1);

        Random random = new Random();
        Random randomDigito = new Random();
        int numeroAleatorio = random.nextInt(10000);
        int digitoAleatorio = randomDigito.nextInt(10);

        String numeroAleatorioFormatado = String.format("%04d", numeroAleatorio) + "-" + digitoAleatorio;

        return ano + numeroAleatorioFormatado;
    }
}
