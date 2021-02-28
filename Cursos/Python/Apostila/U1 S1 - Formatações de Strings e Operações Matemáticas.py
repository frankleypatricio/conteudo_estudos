# ---------------------------------- < Cálculo de quatidade de peças mensais > ------------------------------------

c = 200 # valor da constante

# mes = int(input("Digite o mês que deseja saber o resultado: ") - Também funciona (até melhor kk)
mes = input("Digite o mês que deseja saber o resultado: ") # Função para captura o mês que o cliente digitar
mes = int(mes) # Não esqueça de converter para numérico o valor captura pela função input()

r = c * mes # Equação do primeiro grau, também chamada função do primeiro grau ou de função linear.

print(f"A quantidade de peças para o mês {mes} será {r}") # Aparentemente esse " f " é um definitivo pra usar algo tipo índices do C#

# ---------------------------------- < Formas de formatação de saída de texto > ------------------------------------
nome = input("Digite um nome: ")
print(nome)



# Modo 1 - usando formatadores de caracteres (igual na linguagem C) para imprimir variável e texto
print("Olá %s, bem vindo a disciplina de programação. Parabéns pelo seu primeiro hello world" % (nome))

# Modo 2 - usando a função format() para imprimir variável e texto
print("Olá {}, bem vindo a disciplina de programação. Parabéns pelo seu primeiro hello world".format(nome))

# Modo 3 - usando strings formatadas
print(f"Olá {nome}, bem vindo a disciplina de programação. Parabéns pelo seu primeiro hello world")

# ----------------------------------------- < Operações matemáticas > ---------------------------------------------

# x + y - soma de x e y
# x - y - Diferença de x e y
# x * y - Produto de x e y
# x / y - Quociente de x e y
# x // y - Parte inteira do quociente de x e y
# x % y - Resto de x / y
# abs(x) - Valor absoluto de x
# pow(x, y) - x elevado a y
# x ** y - x elevado a y