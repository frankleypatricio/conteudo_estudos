#                             Operações em comum dos objetos do tipo sequência

# x in s	True caso um item de s seja igual a x, senão False
# s + t Concatenação de s e t
# n * s Adiciona s a si mesmo n vezes
# s[i] Acessa o valor guardado na posição i da sequência
# s[i:j] Acessa os valores da posição i até j
# s[i:j:k] Acessa os valores da posição i até j, com passo k
# len(s) Comprimento de s
# min(s) Menor valor de s
# max(s) Maior valor de s
# s.count(x) Número total de ocorrência de x em s

#LISTAS
vogais = []
vogais.append('a')
vogais.append('e')
vogais.append('i')
vogais.append('o')
vogais.append('u')

frutas = ["maça", "banana", "uva", "mamão", "maça"]
notas = [8.7, 5.2, 10, 3.5]

#                                LIST COMPREHENSION (COMPREENSÕES DE LISTA)
# - Esse tipo de técnica é utilizada quando, dada uma sequência, deseja-se criar uma nova sequência,
# porém com as informações originais transformadas ou filtradas por um critério (um padrão de entrada).

linguagens = ["Python", "Java", "JavaScript", "C", "C#", "C++", "Swift", "Go", "Kotlin"]
#linguagens = '''Python Java JavaScript C C# C++ Swift Go Kotlin'''.split() # Essa sintaxe produz o mesmo resultado que a linha 1
print("Antes da listcomp = ", linguagens)
linguagens = [item.lower() for item in linguagens] # Salva cada item da lista na variável item, coloca em minúsculo e volta pra lista
print("\nDepois da listcomp = ", linguagens)
# A listcomp é uma forma pythônica de escrever um for

linguagens = '''Python Java JavaScript C C# C++ Swift Go Kotlin'''.split()
print("Antes da listcomp = ", linguagens)
for i, item in enumerate(linguagens): # PARECE UMA FORMA DE ESCREVER UM FOR TRADICIONAL
    linguagens[i] = item.lower()
print("\nDepois da listcomp = ", linguagens)

# Listcomp para construir uma lista que contém somente as linguagens que possuem "Java" no texto
linguagens = '''Python Java JavaScript C C# C++ Swift Go Kotlin'''.split()
linguagens_java = [item for item in linguagens if "Java" in item]
print(linguagens_java)

#                                      FUNÇÕES MAP() E FILTER()
# A função map() é utilizada para aplicar uma determinada função em cada item de um objeto iterável.
# Para que essa transformação seja feita, a função map() exige que sejam passados dois parâmetros:
# a função e o objeto iterável

# Exemplo 1
print("Exemplo 1")
linguagens = '''Python Java JavaScript C C# C++ Swift Go Kotlin'''.split()
nova_lista = map(lambda x: x.lower(), linguagens) #Passando cada item de linguagens para minúsculo e colocando dentro da nova_lista
print(f"A nova lista é = {nova_lista}\n")
nova_lista = list(nova_lista) # Convertendo objeto pra lista (map retorna um objeto iterável)
print(f"Agora sim, a nova lista é = {nova_lista}")

# Exemplo 2
print("\n\nExemplo 2")
numeros = [0, 1, 2, 3, 4, 5]
quadrados = list(map(lambda x: x*x, numeros)) # Já fazendo a conversando e usando o map
print(f"Lista com o número elevado a ele mesmo = {quadrados}\n")

# A função filter() tem as mesmas características da função map(), mas,
# em vez de usarmos uma função para transformar os valores da lista, nós a usamos para filtrar

numeros  = list(range(0, 21))
numeros_pares = list(filter(lambda x: x % 2 == 0, numeros)) # Filtrando valores pares
print(numeros_pares)

#                                             TUPLAS
# As tuplas também são estruturas de dados do grupo de objetos do tipo sequência.
# A grande diferença entre listas e tuplas é que as primeiras são mutáveis, razão pela qual, com elas,
# conseguimos fazer atribuições a posições específicas: por exemplo, lista[2] = 'maça'.
# Por sua vez, nas tuplas isso não é possível, uma vez que são objetos imutáveis.

vogais = ('a', 'e', 'i', 'o', 'u')
print(f"Tipo do objeto vogais = {type(vogais)}")
for p, x in enumerate(vogais):
    print(f"Posição = {p}, valor = {x}")

#                                        OBJETOS DO TIPO SET
# Um objeto do tipo set habilita operações matemáticas de conjuntos, tais como: união, intersecção,
# diferenteça, etc. Esse tipo de estrutura pode ser usado, portanto, em testes de associação e remoção de
# valores duplicados de uma sequência

vogais_1 = {'aeiou'} # sem uso do construtor
print(type(vogais_1), vogais_1)
vogais_2 = set('aeiouaaaaaa') # construtor com string
print(type(vogais_2), vogais_2)
vogais_3 = set(['a', 'e', 'i', 'o', 'u']) # construtor com lista
print(type(vogais_3), vogais_3)
vogais_4 = set(('a', 'e', 'i', 'o', 'u')) # construtor com tupla
print(type(vogais_4), vogais_4)
print(set('banana'))
# O construtor interpreta como um iterável e cria um conjunto em que cada caractere é um elemento,
# eliminando valores duplicados.

#                                         OBJETOS DO TIPO MAPPING
# As estruturas de dados que possuem um mapeamento entre uma chave e um valor são consideradas objetos
# do tipo mapping. Em Python, o objeto que possui essa propriedade é o dict (dicionário). Uma vez que esse
# objeto é mutável,  conseguimos atribuir um novo valor a uma chave já existente.

# Exemplo 1 - Criação de dicionário vazio, com atribuição posterior de chave e valor 
dici_1 = {}
dici_1['nome'] = "João"
dici_1['idade'] = 30
# Exemplo 2 - Criação de dicionário usando um par elementos na forma, chave : valor
dici_2 = {'nome': 'João', 'idade': 30}
# Exemplo 3 - Criação de dicionário com uma lista de tuplas. Cada tupla representa um par chave : valor
dici_3 = dict([('nome', "João"), ('idade', 30)])
# Exemplo 4 - Criação de dicionário com a função built-in zip() e duas listas, uma com as chaves, outra com os valores.
dici_4 = dict(zip(['nome', 'idade'], ["João", 30]))
print(dici_1 == dici_2 == dici_3 == dici_4) # Testando se as diferentes construções resultamo em objetos iguais.

