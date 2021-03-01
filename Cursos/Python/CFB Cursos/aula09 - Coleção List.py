lista=["Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"] #Declarando uma lista de strings
print(lista[2]) #Exibindo item da posição 2
lista[0]="Item 7" #Alterando valor do item na posição 0
print(lista) #Exibindo toda a lista
print(len(lista)) #Tamanho da lista

lista.remove("Item 3") #Removendo item com essa string da lista
print(lista)
