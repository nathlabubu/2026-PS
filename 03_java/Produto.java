public class Produto {
    // Atributos privados (Encapsulamento)
    private String codigo;
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor Completo
    public Produto(String codigo, String nome, double preco, int quantidade) {
        if (!validarTexto(codigo) || !validarTexto(nome) || !validarNumeroNaoNegativo(preco) || !validarNumeroNaoNegativo(quantidade)) {
            throw new IllegalArgumentException("Dados inválidos para a criação do Produto.");
        }
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // 🧩 Desafio Complementar 1: Construtor alternativo com menos parâmetros
    public Produto(String codigo, String nome) {
        this(codigo, nome, 1.0, 0); // Preço 1.0 e quantidade 0 por padrão
    }

    // --- VALIDAÇÕES MÍNIMAS (Privadas) ---

    // Validação 1 & 2: Campos de texto obrigatórios (não nulos e não vazios)
    private boolean validarTexto(String valor) {
        return valor != null && !valor.trim().isEmpty();
    }

    // Validação 3 & 4: Preço e quantidade não negativos (>= 0)
    private boolean validarNumeroNaoNegativo(double valor) {
        return valor >= 0;
    }

    // --- GETTERS E SETTERS ---

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean setNome(String nome) {
        if (validarTexto(nome)) {
            this.nome = nome;
            return true;
        }
        System.out.println("❌ Alteração recusada: O nome não pode ser vazio.");
        return false;
    }

    public boolean setPreco(double preco) {
        if (validarNumeroNaoNegativo(preco)) {
            this.preco = preco;
            return true;
        }
        System.out.println("❌ Alteração recusada: Preço não pode ser negativo (" + preco + ").");
        return false;
    }

    // --- COMPORTAMENTOS SUGERIDOS ---

    // Comportamento 1: adicionarEstoque
    public boolean adicionarEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("❌ Falha: A quantidade para adicionar deve ser maior que zero.");
            return false;
        }
        this.quantidade += qtd;
        return true;
    }

    // Comportamento 2: removerEstoque
    public boolean removerEstoque(int qtd) {
        if (qtd <= 0 || qtd > this.quantidade) {
            System.out.println("❌ Falha: Operação impossível. Quantidade indisponível no estoque.");
            return false;
        }
        this.quantidade -= qtd;
        return true;
    }

    // Comportamento 3: calcularValorEmEstoque
    public double calcularValorEmEstoque() {
        return this.preco * this.quantidade;
    }

    // 🧩 Desafio Complementar 2: Método que retorna resumo textual do objeto
    public String obterResumo() {
        return String.format("[%s] %s | Preço: R$ %.2f | Qtd: %d | Total em Estoque: R$ %.2f",
                codigo, nome, preco, quantidade, calcularValorEmEstoque());
    }
}