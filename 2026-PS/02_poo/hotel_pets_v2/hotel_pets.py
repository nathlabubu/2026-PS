"""
==============================================================
ARQUIVO    : hotel_pets.py
Disciplina : Programação de Sistemas (2026-PS)
Projeto    : Hotel para Pets V2.0
Autor      : Nathaly
==============================================================
"""
import pickle
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
            print("Vacinação pendente.")
    def atualizar_peso(self, novo_peso):
        self.peso = novo_peso
        print(f"Peso atualizado para {self.peso}kg.")
    def emitir_resumo(self):
        diaria = self.calcular_diaria()
        print("\n" + "=" * 30)
        print(f"RESUMO: {self.nome}")
        print(f"Espécie: {self.especie}")
        print(f"Raça: {self.raca}")
        print(f"Peso: {self.peso}kg")
        print(f"Diária: R$ {diaria:.2f}")
        print(f"Hospedado: {'Sim' if self.hospedado else 'Não'}")
        print("=" * 30)
    def para_linha_txt(self):
        return (
            f"{self.nome};"
            f"{self.especie};"
            f"{self.idade};"
            f"{self.raca};"
            f"{self.peso};"
            f"{self.vacinado};"
            f"{self.hospedado}"
        )

def salvar_em_txt(pets, caminho):
    with open(caminho, "w", encoding="utf-8") as arquivo:
        for pet in pets:
            arquivo.write(pet.para_linha_txt() + "\n")
    print(f"{len(pets)} pet(s) salvo(s) em '{caminho}'.")
def carregar_de_txt(caminho):
    pets = []
    try:

        with open(caminho, "r", encoding="utf-8") as arquivo:

            for linha in arquivo:
                dados = linha.strip().split(";")
                pet = Pet(
                    dados[0],
                    dados[1],
                    int(dados[2]),
                    dados[3],
                    float(dados[4]),
                    dados[5] == "True"
                )

                pet.hospedado = dados[6] == "True"
                pets.append(pet)

    except FileNotFoundError:
        print(f"Arquivo '{caminho}' ainda não existe.")
    return pets
def salvar_em_binario(pets, caminho):
    with open(caminho, "wb") as arquivo:
        pickle.dump(pets, arquivo)
    print(f"{len(pets)} pet(s) salvo(s) em '{caminho}'.")
def carregar_de_binario(caminho):
    try:
        with open(caminho, "rb") as arquivo:
            return pickle.load(arquivo)
    except FileNotFoundError:
        print(f"Arquivo '{caminho}' ainda não existe.")
        return []
def cadastrar_pet(pets):
    print("\n--- Cadastro de Pet ---")
    nome = input("Nome: ")
    especie = input("Espécie: ")
    idade = int(input("Idade: "))
    raca = input("Raça: ")
    peso = float(input("Peso: "))
    vacinado = input("Vacinado? (s/n): ").lower() == "s"
    pet = Pet(nome, especie, idade, raca, peso, vacinado)
    pets.append(pet)
    print("Pet cadastrado com sucesso!")
def listar_pets(pets):
    if not pets:
        print("\nNenhum pet cadastrado.")
        return
    for i, pet in enumerate(pets, start=1):
        print(f"\n[{i}]")
        pet.exibir_dados()
def selecionar_pet(pets):
    listar_pets(pets)
    if not pets:
        return None
    try:
        indice = int(input("\nEscolha o número do pet: ")) - 1
        if 0 <= indice < len(pets):
            return pets[indice]
        else:
            print("Índice inválido.")
            return None
    except ValueError:
        print("Digite um número válido.")
        return None
def buscar_pet(pets):
    busca = input("\nDigite parte do nome: ").lower()
    encontrados = False
    for pet in pets:
        if busca in pet.nome.lower():

            pet.exibir_dados()
            encontrados = True
    if not encontrados:
        print("Nenhum pet encontrado.")
def check_in(pets):
    pet = selecionar_pet(pets)
    if pet:
        pet.registrar_entrada()
def check_out(pets):
    pet = selecionar_pet(pets)
    if pet:
        pet.registrar_saida()
def atualizar_peso_pet(pets):
    pet = selecionar_pet(pets)
    if pet:
        try:

            novo_peso = float(input("Novo peso: "))
            pet.atualizar_peso(novo_peso)

        except ValueError:
            print("Peso inválido.")
def resumo_pet(pets):
    pet = selecionar_pet(pets)
    if pet:
        pet.emitir_resumo()
def relatorio_hospedados(pets):
    print("\n===== PETS HOSPEDADOS =====")
    total = 0
    for pet in pets:
        if pet.hospedado:
            diaria = pet.calcular_diaria()
            print(f"{pet.nome} - R$ {diaria:.2f}")
            total += diaria
    print(f"\nTotal do dia: R$ {total:.2f}")
def menu():
    pets = carregar_de_binario("pets.bin")
    while True:
        print("\n====== HOTEL PETS ======")
        print("1 - Cadastrar pet")
        print("2 - Listar pets")
        print("3 - Buscar pet")
        print("4 - Check-in")
        print("5 - Check-out")
        print("6 - Atualizar peso")
        print("7 - Resumo individual")
        print("8 - Relatório hospedados")
        print("9 - Salvar em .txt")
        print("10 - Salvar em .bin")
        print("0 - Sair")
        opcao = input("Opção: ")
        if opcao == "1":
            cadastrar_pet(pets)
        elif opcao == "2":
            listar_pets(pets)
        elif opcao == "3":
            buscar_pet(pets)
        elif opcao == "4":
            check_in(pets)
        elif opcao == "5":
            check_out(pets)
        elif opcao == "6":
            atualizar_peso_pet(pets)
        elif opcao == "7":
            resumo_pet(pets)
        elif opcao == "8":
            relatorio_hospedados(pets)
        elif opcao == "9":
            salvar_em_txt(pets, "pets.txt")
        elif opcao == "10":
            salvar_em_binario(pets, "pets.bin")
        elif opcao == "0":
            salvar_em_binario(pets, "pets.bin")
            print("Sistema encerrado.")
            break
        else:
            print("Opção inválida.")
if __name__ == "__main__":
    menu()