import random

#Variáveis da quantidade de cada item do escritório, recebendo valores aleatórios entre 0 e 200
borracha=random.randrange(0,200)
lapis=random.randrange(0,200)
canetaAzul=random.randrange(0,200)
canetaPreta=random.randrange(0,200)
canetaVermelha=random.randrange(0,200)
blocos=random.randrange(0,200)
folhas=random.randrange(0,200)
grampos=random.randrange(0,200)

qtd=0 #Variável para quantidade de itens a serem comprados
i=0 #Variável para percorrer a lista
lista=[] #Variável para a lista de compras

print("> Seu chefe percebeu que alguns itens do escritório estão acabando, então ele o pediu para que verificasse a quantidade de cada um e que fizesse uma lista dos que tenham menos que 100 em estoque.")
print("\n< Itens do escritório >")
print(f"- Borracha: {borracha};")
print(f"- Lápis: {lapis};")
print(f"- Caneta Azul: {canetaAzul};")
print(f"- Caneta Preta: {canetaPreta};")
print(f"- Caneta Vermelha: {canetaVermelha};")
print(f"- Bloco de Anotações: {blocos};")
print(f"- Folha Sulfite: {folhas};")
print(f"- Grampos: {grampos};")

print("\n> Quantos itens você encontrou que estão em falta?")
qtd=int(input())

print("\n> Agora adicione na lista o nome dos itens a serem comprados:")
while i < qtd:
    print(f"< Item {i+1} >")
    lista.append(input())
    i+=1

print("\n< Lista de Compras >")
i=0
for s in lista:
    print(f"{i+1}: {lista[i]}")
    i+=1