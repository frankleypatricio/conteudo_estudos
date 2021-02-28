# Operadores Relacionais em Python
# a < b - O valor de a é menor que b?
# a <= b - O valor de a é menor OU igual que b?
# a > b - O valor de a é maior que b?
# a >= b - O valor de a é maior OU igual que b?
# a == b - O valor de a é igual ao de b?
# a != b - O valor de a é diferente do valor de b?
# a is b - O valor de a é idêntico ao valor de b?
# a is not b - O valor de a não é idêntico ao valor de b?

a = 10
b = 5

# if else tradicional
if a < b:
    print("a é menor do que b")
    r = a + b
    print(r)
else:
    print("a é maior do que b")
    r = a - b
    print(r)

# if, else if, else
codigo_compra = 5111

if codigo_compra == 5222:
    print("Compra à vista.")
elif codigo_compra == 5333: # Isso é um else if
    print("Compra à prazo no boleto.")
elif codigo_compra == 5444:
    print("Compra à prazo no cartão.")
else:
    print("Código não cadastrado")

# ESTRUTURAS LÓGICAS EM PYTHON: AND, OR, NOT
qtde_faltas = int(input("Digite a quantidade de faltas: "))
media_final = float(input("Digite a média final: "))

if qtde_faltas <= 5 and media_final >= 7:
    print("Aluno aprovado!")
else:
    print("Aluno reprovado!")

# Obs: not tem uma prioridade mais baixa que os operadores relacionais.
# Portanto, not a == b é interpretado como: not (a == b) e a == not b gera um erro de sintaxe. 
# Obs2: Assim como as operações matemáticas possuem ordem de precedência, as operações booleanas
# também têm. Essa prioridade obedece à seguinte ordem: not primeiro, and em seguida e or por último.

d = 15
e = 9
f = 9
print(e == f or d < e and d < f)
print((e == f or d < e) and d < f )

#Estrutura de repetição while e for

numero = 1
while numero != 0:
    numero = int(input("Digite um número: "))
    if numero % 2 == 0:
        print("Número par!")
    else:
        print("Número ímpar!")

nome = "Guido"
for c in nome:
    print(c)
# Exibindo letra e posição da mesma na string
for i, c in enumerate(nome):
    print(f"Posição = {i}, valor = {c}")

# CONTROLE DE REPETIÇÃO COM RANGE, BREAK E CONTINUE
for x in range(5): # Isso faz o for contar de 0 à 5 (range() pode ser usado passando o início e fim e também o incremento(range(1,5) / range(0,8,2)))
    print(x)

# Continue: podemos pular a execução de alguns códigos com o continue
disciplina = "Linguagem de programação"
for c in disciplina:
    if c == 'a':
        continue # Pula execução do if
    else:
        print(c)
        break # Qubra execução do for

linguagens = '''Python Java JavaScript C C# C++ Swift Go Kotlin'''.split()
print("Antes da listcomp = ", linguagens)
for i, item in enumerate(linguagens): # PARECE UMA FORMA DE ESCREVER UM FOR TRADICIONAL
    linguagens[i] = item.lower()
print("\nDepois da listcomp = ", linguagens)
