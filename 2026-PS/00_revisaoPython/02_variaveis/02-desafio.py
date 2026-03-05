"""
Nome: Nathaly Ananias
Disciplina: Programação
Data: 02/03/2026
Descrição: Controle simples de estoque
"""

# -------------------------------
# LISTA DE PRODUTOS
# -------------------------------

produtos = [
    ["Mouse", 3],
    ["Teclado", 10],
    ["Monitor", 25]
]

# -------------------------------
# RELATÓRIO
# -------------------------------

critico = 0
adequado = 0
excesso = 0

print("\nRELATÓRIO DE ESTOQUE\n")

for p in produtos:
    nome = p[0]
    qtd = p[1]

    if qtd < 5:
        situacao = "Crítico"
        critico += 1
    elif qtd <= 20:
        situacao = "Adequado"
        adequado += 1
    else:
        situacao = "Excesso"
        excesso += 1

    print(nome, "-", qtd, "-", situacao)

# -------------------------------
# RESUMO
# -------------------------------

print("\nResumo:")
print("Crítico:", critico)
print("Adequado:", adequado)
print("Excesso:", excesso)

# -------------------------------
# CONSULTAR PRODUTO
# -------------------------------

while True:
    opcao = input("\nQuer consultar um produto? (s/n): ")

    if opcao == "n":
        break

    nome_busca = input("Digite o nome: ")
    achou = False

    for p in produtos:
        if p[0].lower() == nome_busca.lower():
            print("Quantidade:", p[1])
            achou = True
            break

    if not achou:
        print("Produto não encontrado.")

# -------------------------------
# ADICIONAR PRODUTO
# -------------------------------

while True:
    opcao = input("\nQuer adicionar produto? (s/n): ")

    if opcao == "n":
        break

    nome = input("Nome: ")

    try:
        qtd = int(input("Quantidade: "))
        if qtd < 0:
            print("Não pode ser negativo.")
        else:
            produtos.append([nome, qtd])
            print("Adicionado!")
    except:
        print("Digite apenas número.")

# -------------------------------
# MENOR ESTOQUE
# -------------------------------

menor = produtos[0]

for p in produtos:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    if p[1] < menor[1]:
        menor = p

print("\nProduto com menor estoque:")
print(menor[0], "-", menor[1])