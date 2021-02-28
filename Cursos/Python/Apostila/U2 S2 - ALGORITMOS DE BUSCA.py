import random

# ALGORITMOS DE BUSCAS
nomes = 'João Marcela Sonia Daryl Vernon Eder Mechelle Edan Igor Ethan Reed Travis Hoyt'.split()
print('Marcela' in nomes) # Verifica se a string está na var
print('Roberto' in nomes)

# BUSCA LINEAR (OU BUSCA SEQUENCIAL)
lista = random.sample(range(1000), 50)
print(sorted(lista))
executar_busca_linear(lista, 10)

def executar_busca_linear(lista, valor):
    for elemento in lista: # Vai buscando na lista cada um dos elementos para ver se o valor está lá
        if valor == elemento:
            return True
    return False

# FUNÇÂO INDEX
vogais = 'aeiou'
resultado = vogais.index('e') # Retorna index da string passada, se existir
print(resultado)

# BUSCA BINÁRIA
def executar_busca_binaria(lista, valor):
    minimo = 0
    maximo = len(lista) - 1
    while minimo <= maximo:
        # Encontra o elemento que divide a lista ao meio
        meio = (minimo + maximo) // 2
        # Verifica se o valor procurado está a esquerda ou direita do valor central
        if valor < lista[meio]:
            maximo = meio - 1
        elif valor > lista[meio]:
            minimo = meio + 1
        else:
            return True # Se o valor for encontrado para aqui
    return False # Se chegar até aqui, significa que o valor não foi encontrado

lista = list(range(1, 50))
print(lista)
print('\n',executar_busca_binaria(lista=lista, valor=10))
print('\n', executar_busca_binaria(lista=lista, valor=200))

def procurar_valor(lista, valor):
    minimo = 0
    maximo = len(lista) - 1
    while minimo <= maximo:
        meio = (minimo + maximo) // 2
        if valor < lista[meio]:
            maximo = meio - 1
        elif valor > lista[meio]:
            minimo = meio + 1
        else:
            return meio 
    return None

vogais = ['a', 'e', 'i', 'o', 'u']
resultado = procurar_valor(lista=vogais, valor='z')
if resultado:
    print(f"Valor encontrado an posição {resultado}")
else:
    print("Valor não encontrado")