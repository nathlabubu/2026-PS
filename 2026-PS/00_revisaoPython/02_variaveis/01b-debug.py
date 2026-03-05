# Arquivo: 01b-debug.py
# ATENÇÃO Este código cóntem 4 erros propositais. Encontre e corrija todos! 

# "imput" estava escrito errado → correto é "input"
nome = input("Digite o nome do aluno: ")

nota1 = float(input("Digite a nota 1: "))
nota2 = float(input("Digite a nota 2: "))

# :Cálculo da média estava incorreto (faltavam parênteses)
# Antes: media = nota1 + nota2 / 2
# Isso dividia apenas a nota2 por 2
# Correto: somar primeiro e depois dividir por 2
media = (nota1 + nota2) / 2

if media >= 6.0:
    situacao = "✅ Aprovado"
elif media >= 4.0:
    situacao = "⚠️ Recuperação"
else:
    situacao = "❌ Reprovado"

# "pront" estava escrito errado correto é "print"
#  Havia uma barra "\" solta na string ( \ Situação )
# O correto é apenas separar normalmente com "|"
print(f"Aluno: {nome} | Média: {media:.2f} | Situação: {situacao}")