/*
* Disciplina: 2026-PS
* Esdudante : Nathaly Vitória de Ananias Fernandes 
* Data      : 2026.08.11
* Projeto   : aula32-projeto-secretaria
* Arquivo   : Aluno.java
*/

public class Aluno {

    // Nível C: Atributos privados (Encapsulamento)
    private int matricula;
    private String nome;
    private String curso;
    
    // Nível B: Atributo extra integrado à ficha
    private double ira; // Indice de Rendimento Academico

    // Construtor Completo
    public Aluno(int matricula, String nome, String curso, double ira) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.ira = ira;
    }

    // Getters e Setters com Validações
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        if (matricula > 0) {
            this.matricula = matricula;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome.trim();
        }
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        if (curso != null && !curso.trim().isEmpty()) {
            this.curso = curso.trim();
        }
    }

    public double getIra() {
        return ira;
    }

    public void setIra(double ira) {
        if (ira >= 0.0 && ira <= 10.0) {
            this.ira = ira;
        }
    }

    // Nível A: toString() padronizado para enxugar a listagem
    @Override
    public String toString() {
        return String.format("Matrícula: %-6d | Nome: %-20s | Curso: %-15s | IRA: %.2f", 
                matricula, nome, curso, ira);
    }
}