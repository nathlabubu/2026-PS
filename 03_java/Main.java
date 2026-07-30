public class Main {
    public static void main(String[] args) {
        System.out.println("=== 🎯 SysControl v2.0 — Execução dos Testes Mínimos ===\n");

        // TESTE 1: Criar objetos com dados válidos (usando 'JU' e '18')
        System.out.println("--- 🧪 Teste 1: Criar objeto com dados válidos ---");
        Produto p1 = new Produto("JU-101", "Jumbo Gadget", 180.0, 18);
        Produto p2 = new Produto("JU-102", "Juice Blender", 250.0, 5);
        Produto p3 = new Produto("JU-103", "Just Keyboard"); // Construtor alternativo

        System.out.println("✅ " + p1.obterResumo());
        System.out.println("✅ " + p2.obterResumo());
        System.out.println("✅ " + p3.obterResumo());
        System.out.println();

        // TESTE 2: Tentar atribuir texto vazio a um campo obrigatório
        System.out.println("--- 🧪 Teste 2: Atribuir texto vazio a campo obrigatório ---");
        boolean tentouNomeVazio = p1.setNome("   ");
        System.out.println("Resultado: " + (tentouNomeVazio ? "Aceito" : "Alteração recusada"));
        System.out.println("Estado do objeto: " + p1.obterResumo());
        System.out.println();

        // TESTE 3: Tentar atribuir número negativo a um campo numérico restrito
        System.out.println("--- 🧪 Teste 3: Atribuir número negativo a campo restrito ---");
        boolean tentouPrecoNegativo = p1.setPreco(-18.0);
        System.out.println("Resultado: " + (tentouPrecoNegativo ? "Aceito" : "Alteração recusada"));
        System.out.println("Estado do objeto: " + p1.obterResumo());
        System.out.println();

        // TESTE 4: Executar um comportamento permitido
        System.out.println("--- 🧪 Teste 4: Executar comportamento permitido (adicionarEstoque) ---");
        boolean estoqueAdicionado = p1.adicionarEstoque(10);
        System.out.println("Operação realizada: " + estoqueAdicionado);
        System.out.println("Estado alterado: " + p1.obterResumo());
        System.out.println();

        // TESTE 5: Executar um comportamento impossível
        System.out.println("--- 🧪 Teste 5: Executar comportamento impossível (removerEstoque excedente) ---");
        boolean remocaoFalhou = p1.removerEstoque(100); // Tenta remover 100 de um estoque menor
        System.out.println("Operação realizada: " + remocaoFalhou);
        System.out.println("Estado preservado: " + p1.obterResumo());
        System.out.println();

        // EXIBIÇÃO FINAL
        System.out.println("--- 📋 Estado Final dos Objetos (Via getters / resumo) ---");
        System.out.println(p1.obterResumo());
        System.out.println(p2.obterResumo());
        System.out.println(p3.obterResumo());
    }
}