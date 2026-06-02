"""
==============================================================
ARQUIVO    : hotel_pets.py
Disciplina : Programação de Sistemas (2026-PS)
Projeto    : Hotel para Pets V3.6 (Versão Final Redonda)
Autor      : Nathaly
==============================================================
"""
import json
import os

ARQUIVO_JSON = "2026-PS/02_poo/hotel_pets_json/pets.json"


class Pet:
    def __init__(self, nome, especie, peso, altura, nome_dono, telefone_dono, data_nascimento, vacinado, hospedado=False):
        self.nome = nome
        self.especie = especie
        self.peso = peso
        self.altura = altura
        self.nome_dono = nome_dono
        self.telefone_dono = telefone_dono
        self.data_nascimento = data_nascimento
        self.vacinado = vacinado
        self.hospedado = hospedado

    def exibir_dados(self):
        print("\n--- Dados do Pet ---")
        print(f"Nome: {self.nome}")
        print(f"Espécie: {self.especie}")
        print(f"Data de Nasc.: {self.data_nascimento}")
        print(f"Peso: {self.peso} kg")
        print(f"Altura: {self.altura} m")
        print(f"Dono: {self.nome_dono}")
        print(f"Telefone do Dono: {self.telefone_dono}")
        print(f"Vacinado: {'Sim' if self.vacinado else 'Não'}")
        print(f"Hospedado: {'Sim' if self.hospedado else 'Não'}")

    def registrar_entrada(self):
        if self.hospedado:
            print(f"{self.nome} já está hospedado.")
        else:
            self.hospedado = True
            print(f"{self.nome} entrou no hotel.")

    def registrar_saida(self):
        if not self.hospedado:
            print(f"{self.nome} não está hospedado.")
        else:
            self.hospedado = False
            print(f"{self.nome} saiu do hotel.")

    def para_dicionario(self):
        return {
            "nome": self.nome,
            "especie": self.especie,
            "peso": self.peso,
            "altura": self.altura,
            "nome_dono": self.nome_dono,
            "telefone_dono": self.telefone_dono,
            "data_nascimento": self.data_nascimento,
            "vacinado": self.vacinado,
            "hospedado": self.hospedado
        }

    @staticmethod
    def criar_de_dicionario(dados):
        return Pet(
            dados["nome"],
            dados["especie"],
            dados["peso"],
            dados["altura"],
            dados["nome_dono"],
            dados["telefone_dono"],
            dados["data_nascimento"],
            dados["vacinado"],
            dados["hospedado"]
        )


def salvar_pets(lista_pets):
    lista_dicionarios = []

    for pet in lista_pets:
        lista_dicionarios.append(pet.para_dicionario())

    with open(ARQUIVO_JSON, "w", encoding="utf-8") as arquivo:
        json.dump(lista_dicionarios, arquivo, ensure_ascii=False, indent=4)

    print("Dados salvos com sucesso em pets.json!")


def carregar_pets():
    if not os.path.exists(ARQUIVO_JSON):
        return []

    try:
        with open(ARQUIVO_JSON, "r", encoding="utf-8") as arquivo:
            lista_dicionarios = json.load(arquivo)

        lista_pets = []

        for dados in lista_dicionarios:
            try:
                pet = Pet.criar_de_dicionario(dados)
                lista_pets.append(pet)
            except KeyError:
                # Proteção ativa: ignora dados velhos sem quebrar o sistema
                continue

        return lista_pets

    except json.JSONDecodeError:
        return []


def cadastrar_pet(lista_pets):
    print("\n--- Cadastro de Pet ---")

    nome = input("Nome do pet: ")
    especie = input("Espécie: ")
    data_nascimento = input("Data de nascimento (dd/mm/aaaa): ")
    peso = float(input("Peso (kg): "))
    altura = float(input("Altura (metros - ex: 0.45): "))
    nome_dono = input("Nome do dono: ")
    telefone_dono = input("Telefone do dono: ")

    resposta = input("O pet está vacinado? (s/n): ").lower()
    vacinado = resposta == "s"

    pet = Pet(nome, especie, peso, altura, nome_dono, telefone_dono, data_nascimento, vacinado)
    lista_pets.append(pet)

    print("Pet cadastrado com sucesso!")


def listar_pets(lista_pets):
    print("\n--- Lista de Pets ---")

    if not lista_pets:
        print("Nenhum pet cadastrado.")
        return False

    for i, pet in enumerate(lista_pets, 1):
        print(f"\nDono {i}:")
        pet.exibir_dados()
    return True


def menu():
    pets = carregar_pets()

    while True:
        print("\n========= HOTEL PARA PETS =========")
        print("1 - Cadastrar pet")
        print("2 - Listar pets")
        print("3 - Registrar entrada")
        print("4 - Registrar saída")
        print("5 - Salvar dados")
        print("0 - Sair")
        opcao = input("Escolha uma opção: ")

        if opcao == "1":
            cadastrar_pet(pets)

        elif opcao == "2":
            listar_pets(pets)

        elif opcao == "3":
            if listar_pets(pets):
                numero = int(input("Número do dono: "))
                if 1 <= numero <= len(pets):
                    pets[numero - 1].registrar_entrada()
                else:
                    print("Número inválido.")

        elif opcao == "4":
            if listar_pets(pets):
                numero = int(input("Número do dono: "))
                if 1 <= numero <= len(pets):
                    pets[numero - 1].registrar_saida()
                else:
                    print("Número inválido.")

        elif opcao == "5":
            salvar_pets(pets)

        elif opcao == "0":
            salvar_pets(pets)
            print("Sistema encerrado.")
            break

        else:
            print("Opção inválida.")


if __name__ == "__main__":
    menu()