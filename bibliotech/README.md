# BiblioTech

Sistema de emprestimo de livros para a biblioteca do campus.

## 1. O projeto
Os clientes são: A dona Marli e os alunos
Os problemas são: A dona Marli anota os empréstimos em um caderno e esquece as datas dos empréstimos, e o dos alunos é ir ao balcão da biblioteca para saber se o livro esta disponivel. 
O que o sistema resolve e para quem: O sistema vai automatizar os emprestimos e as devoluções para dona Marli e facilitar para os alunos os emprestimos e devoluções.


## 2. Historias de usuario

| # | Historia de usuario |
|---|---|
| HU01 | Como leitor, quero consultar a disponibilidade de um livro, para saber se posso pega-lo emprestado sem ir ate o balcao. |
| HU02 | Como leitor, quero devolver um livro, para nao ficar com pendencia na biblioteca. |
| HU03 | Como bibliotecaria, quero registrar um emprestimo, para saber quem esta com cada exemplar. |
| HU04 | Como bibliotecaria, quero cadastrar um livro novo, para que ele possa ser encontrado no sistema. |
| HU05 | Como bibliotecaria, quero ver os emprestimos atrasados, para cobrar a devolucao. |

## 3. Requisitos

### Requisitos funcionais

| # | Requisito funcional | Veio da |
|---|---|---|
| RF01 | O sistema deve permitir que a bibliotecaria cadastre um livro no acervo. | HU04 |
| RF02 | O sistema deve permitir que a bibliotecaria cadastre um leitor. | regra de acesso: so quem tem cadastro leva livro |
| RF03 | O sistema deve permitir que o leitor consulte a disponibilidade de um livro. | HU01 |
| RF04 | O sistema deve permitir que a bibliotecaria registre a devolucao de um livro. | HU02 |
| RF05 | O sistema deve permitir que a bibliotecaria registre o emprestimo de um livro. | HU03 |
| RF06 | O sistema deve permitir que o os alunos consultem os livros mais emprestados | HU06 |

### Requisitos nao funcionais

| # | Requisito nao funcional |
|---|---|
| RNF01 | A consulta de disponibilidade deve responder em menos de 3 segundos. |
| RNF02 | Somente usuarios identificados como bibliotecarios podem alterar o acervo. |

## 4. Diagramas (feitos em APS)

### Casos de uso

![Diagrama de casos de uso do BiblioTech](docs/casos-de-uso.svg)

### Classes

![Diagrama de classes do BiblioTech](docs/classes.svg)

## 6. Como executar

No Codespace, dentro da pasta `bibliotech`:
```
javac *.java
java TesteRequisitos
java TelaBiblioteca
```
`TesteRequisitos` confere os requisitos no terminal. `TelaBiblioteca` abre a janela na area de trabalho do Codespace (porta 6080).

## 7. Requisitos e verificacoes

| # | Onde esta no codigo | Como verifico |
|---|---|---|
| RF01 | `Biblioteca.cadastrarLivro()` | TesteRequisitos: 1 verificacao RF01 |
| RF02 | `Biblioteca.cadastrarLeitor()` | TesteRequisitos: 1 verificacao RF02 |
| RF03 | `Biblioteca.buscarLivro()` e `Livro.estaDisponivel()`; area do acervo na janela | TesteRequisitos: 2 verificacoes RF03 |
| RF04 | `Biblioteca.devolver()`, que chama `Emprestimo.registrarDevolucao()`; botao Devolver | TesteRequisitos: 3 verificacoes RF04 |
| RF05 | `Biblioteca.emprestar()`, que chama `Emprestimo.realizarEmprestimo()`; botao Emprestar | TesteRequisitos: 5 verificacoes RF05 |
| RF06 | `Biblioteca.listarEmprestimos()` | TesteRequisitos: sem verificacao |

## 8. O que o BiblioTech ainda nao faz

- HU05: ver os emprestimos atrasados. O emprestimo ainda nao tem prazo.
- RNF02: qualquer pessoa que abre a janela pode emprestar e devolver; nao ha login de bibliotecario.
- Cadastrar livro e leitor pela janela: hoje o cadastro esta no `main` de `TelaBiblioteca`.
- Guardar os dados: ao fechar o programa, os emprestimos se perdem.
## 9. Persistência de Dados (Aula 42)

- **Banco de Dados**: MariaDB / MySQL no ambiente GitHub Codespaces.
- **Conexao.java**: Estabelece a conexão JDBC utilizando as variáveis de ambiente `DB_USER` e `DB_PASSWORD`.
- **LivroDAO.java**: Responsável por realizar operações CRUD na tabela `livros`.
  - `adicionarLivro()`: Insere um novo livro no banco de dados.
  - `atualizarLivro()`: Atualiza título, autor e ano de publicação de um livro por ID.
  - `excluirLivro()`: Remove um registro pelo seu ID.

### Configuração das Variáveis de Ambiente
Para executar localmente, defina as variáveis no terminal antes de rodar o programa:
```bash
export DB_USER="root"
export DB_PASSWORD=""