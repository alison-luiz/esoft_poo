package domain.dev.alisonluiz.pessoa.modelo;

import java.time.LocalDate;

public class Pessoa {

    protected String nome;
    protected LocalDate dataNascimento;
    protected int idade;

    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idade = calcIdade(dataNascimento);
    }

    public Pessoa(String nome, LocalDate dataNascimento, int idade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
    }

    private int calcIdade(LocalDate dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - dataNascimento.getYear();
        if (dataAtual.getMonthValue() < dataNascimento.getMonthValue()) {
            idade--;
        } else if (dataAtual.getMonthValue() == dataNascimento.getMonthValue()) {
            if (dataAtual.getDayOfMonth() < dataNascimento.getDayOfMonth()) {
                idade--;
            }
        }
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        this.idade = calcIdade(dataNascimento);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
