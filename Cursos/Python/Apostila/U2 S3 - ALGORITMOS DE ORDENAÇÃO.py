
# MÉTODOS DE ORGANIZAÇÃO DE LISTAS
lista = [10, 4, 1, 15, -3]
lista_ordenada1 = sorted(lista)
lista_ordenada2 = lista.sort()
print('lista = ', lista, '\n')
print('lista_ordenada1 = ', lista_ordenada1)
print('lista_ordenada2 = ', lista_ordenada2)
print('lista = ', lista)

# ALGORITIMOS DE ORDENAÇÃO
lista = [7, 4]
if lista[0] > lista[1]:
    aux = lista[1]
    lista[1] = lista[0]
    lista[0] = aux
print(lista)

lista = [5, -1]
if lista[0] > lista[1]:
    lista[0], lista[1] = lista[1], lista[0] # Não sabia que dava ora adicionar 2 valores dessa forma...
print(lista)

# SELECTION SORT (ORDENAÇÃO POR SELEÇÃO)
# O algoritmo selection sort recebe esse nome, porque faz a ordenação sempre
# escolhendo o menor valor para ocupar uma determinada posição.
def executar_selection_sort(lista):
    n = len(lista)
    for i in range(0, n):
        index_menor = i
        for j in range(i+1, n):
            if lista[j] < lista[index_menor]:
                index_menor = j
        lista[i], lista[index_menor] = lista[index_menor], lista[i]
    return lista
lista = [10, 9, 5, 8, 11, -1, 3]
executar_selection_sort(lista)

# Usamos a função built-in min() para, a cada iteração, encontrar o
# menor valor da sequência e adicioná-lo na lista_ordenada
def executar_selection_sort_2(lista):
    lista_ordenada = []
    while lista:
        minimo = min(lista)
        lista_ordenada.append(minimo)
        lista.remove(minimo)
    return lista_ordenada
lista = [10, 9, 5, 8, 11, -1, 3]
executar_selection_sort_2(lista)

# BUBBLE SORT (ORDENAÇÃO POR "BOLHA")
# O algoritmo bubble sort (algoritmo da bolha) recebe esse nome porque faz a ordenação
# sempre a partir do ínicio da lista, comparando um valor com seu vizinho
# (vai trocando de lugar com o da frente caso seja menor ou maior, depende da forma de ordenação).
def executar_bubble_sort(lista):
    n = len(lista)
    for i in range(n-1):
        for j in range(n-1):
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]
    return lista
lista = [10, 9, 5, 8, 11, -1, 3]
executar_bubble_sort(lista)

# INSERTION SORT (ORDENAÇÃO POR INSERÇÃO)
# O algoritmo insertion sort (algoritmo de inserção) recebe esse nome 
# porque faz a ordenação pela simulação da inserção de novos valores na lista.
# (Insere o valor na lista já ordenando em relação aos já existentes lá)
def executar_insertion_sort(lista):
    n = len(lista)
    for i in range(1, n): # Começa na posição 1, pois o algoritmo parte do princípio de que a lista possui um valor e um novo precisa ser inserido
        valor_inserir = lista[i] 
        j = i - 1
        while j >= 0 and lista[j] > valor_inserir:
            lista[j + 1] = lista[j]
            j -= 1
        lista[j + 1] = valor_inserir
    return lista
lista = [10, 9, 5, 8, 11, -1, 3]
lista = executar_insertion_sort(lista)

# MERGE SORT (ORDENAÇÃO POR JUNÇÃO)
# O algoritmo merge sort recebe esse nome porque faz a ordenação em duas etapas:
# (i) divide a lista em sublistas; e (ii) junta (merge) as sublistas já ordenadas.
# (Divide a lista até conseguir sub-listas de apenas 1 elementos, depois faz o processo
# inverso, porém ordenando e juntando-as novamente)
def executar_merge_sort(lista):
    if len(lista) <= 1: return lista
    else:
        meio = len(lista) // 2
        esquerda = executar_merge_sort(lista[:meio])
        direita = executar_merge_sort(lista[meio:])
        return executar_merge(esquerda, direita)
    
def executar_merge(esquerda, direita):
    sub_lista_ordenada = []
    topo_esquerda, topo_direita = 0, 0
    while topo_esquerda < len(esquerda) and topo_direita < len(direita):
        if esquerda[topo_esquerda] <= direita[topo_direita]:
            sub_lista_ordenada.append(esquerda[topo_esquerda])
            topo_esquerda += 1
        else:
            sub_lista_ordenada.append(direita[topo_direita])
            topo_direita += 1
    sub_lista_ordenada += esquerda[topo_esquerda:]
    sub_lista_ordenada += direita[topo_direita:]
    return sub_lista_ordenada

lista = [10, 9, 5, 8, 11, -1, 3]
executar_merge_sort(lista)