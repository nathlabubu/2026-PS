'''
==============================================================
#ARQUIVO    : pet.py
#Disciplina : progrmação de sistemas (2026-ps)
#Aula       : aula 20 - por que POO? 
#Autor      : Nathaly 
#Conceitos  : Classe, objeto, atributos, métodos, encapsulamento
# Atividade : Classe pet 
=============================================================
'''

class Pet:
    def __init__(self, nome, especie, idade, raca, peso, vacinado):
        self.nome = nome
        self.especie = especie
        self.idade = idade
        self.raca = raca
        self.peso = peso
        self.vacinado = vacinado
        self.hospedado = False

    def exibir_dados(self):
        print(f"\n--- Dados do Pet: {self.nome} ---")
        print(f"Espécie: {self.especie}")
        print(f"Raça: {self.raca}")
        print(f"Idade: {self.idade} anos")
        print(f"Peso: {self.peso}kg")
        print(f"Vacinado: {'Sim' if self.vacinado else 'Não'}")
        print(f"Hospedado: {'Sim' if self.hospedado else 'Não'}")

    def registrar_entrada(self):
        if self.hospedado:
            print(f"Aviso: {self.nome} já está hospedado.")
        else:
            self.hospedado = True
            print(f"{self.nome} entrou no hotel.")

    def registrar_saida(self):
        if not self.hospedado:
            print(f"Aviso: {self.nome} não está no hotel.")
        else:
            self.hospedado = False
            print(f"{self.nome} saiu do hotel.")

    def calcular_diaria(self):
        if self.idade <= 3:
            return 50.00
        elif 4 <= self.idade <= 10:
            return 60.00
        else:
            return 75.00

    def verificar_vacinacao(self):
        if self.vacinado:
            print("Vacinação em dia.")
        else:
            print("Atenção: vacinação pendente.")

    def atualizar_peso(self, novo_peso):
        self.peso = novo_peso
        print(f"Peso de {self.nome} atualizado para {self.peso}kg.")

    def emitir_resumo(self):
        diaria = self.calcular_diaria()
        print("-" * 30)
        print(f"RESUMO: {self.nome} ({self.especie})")
        print(f"Raça: {self.raca} | Peso: {self.peso}kg")
        print(f"Status: {'Hospedado' if self.hospedado else 'Fora'}")
        print(f"Diária: R$ {diaria:.2f}")
        print("-" * 30)

# Testes
pet1 = Pet("Rex", "Gato", 2, "Gato de pelo curto americano", 4.2, True)
pet2 = Pet("Pitty", "cachorro", 2, "american bully", 12.5, True)
pet3 = Pet("Ghidorah", "Cachorro", 2, "Vira-lata", 18.0, False)

pet1.exibir_dados()
pet1.registrar_entrada()
pet1.emitir_resumo()

pet2.exibir_dados()
pet2.atualizar_peso(12.5)
pet3.verificar_vacinacao()