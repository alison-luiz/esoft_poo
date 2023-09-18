import domain.dev.alisonluiz.pessoa.modelo.Pessoa;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Pessoa alison = new Pessoa("Alison Luiz", LocalDate.of(1998, 6, 24));

        System.out.println(alison.getNome());
        System.out.println(alison.getDataNascimento());
        System.out.println(alison.getIdade());

        Pessoa henrique = new Pessoa("Henrique", LocalDate.of(1998, 6, 24), 25);

        System.out.println(henrique.getNome());
        System.out.println(henrique.getDataNascimento());
        System.out.println(henrique.getIdade());

        Pessoa felipe = new Pessoa();

        felipe.setNome("Felipe");
        felipe.setDataNascimento(LocalDate.of(1998, 6, 24));

        System.out.println(felipe.getNome());
        System.out.println(felipe.getDataNascimento());
        System.out.println(felipe.getIdade());

    }
}