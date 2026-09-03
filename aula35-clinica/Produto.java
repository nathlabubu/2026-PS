/*
* Disciplina: 2026-PS
* Esdudante : Nathaly Vitória de Ananias Fernandes 
* Data      : 2026.08.11
* Projeto   : aula35-clinica
* Arquivo   : Aluno.java
*/

public class Produto {

    // Tarefa 1: Atributos privados (Encapsulamento)
    private int codigo;
    private String nome;
    private double preco;

    // Construtores
    public Produto() {
    }

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Tarefa 5: Sobrecarga de Métodos
    public void alterarPreco(double preco) {
        this.preco = preco;
    }

    // Sobrecarga com cálculo de percentual de desconto
    public void alterarPreco(double preco, double percentualDesconto) {
        double valorDesconto = preco * (percentualDesconto / 100.0);
        this.preco = preco - valorDesconto;
    }

    // Tarefa 4: Método toString() para formatação da listagem
    @Override
    public String toString() {
        return String.format("Código: %d | Nome: %-15s | Preço: R$ %.2f", codigo, nome, preco);
    }
}