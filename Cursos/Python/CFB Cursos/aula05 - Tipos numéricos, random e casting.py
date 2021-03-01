import random #importando biblioteca do ramdom

# Conversão de typecast
inteiro=10
decimal=10.5
complexo=5j

x=10
x+=int(decimal) #Converte pra int (aparentemente o cast segue essa regra: tipo da var + () - float(), type(), str())

print("Valor: "+str(inteiro)+" / Tipo: "+str(type(inteiro))) #str() - converte em string (isso é o cast de python)
print("Valor: "+str(decimal)+" / Tipo: "+str(type(decimal)))
print("Valor: "+str(complexo)+" / Tipo: "+str(type(complexo)))

print("\nValor: "+str(x)+" / Tipo: "+str(type(x)))

# Valores aleatórios
aleatorio=random.randrange(0,100)
print("\nValor aleatório: "+str(aleatorio))

ramdomArray=[ # List/Array
    random.randrange(0,100),
    random.randrange(0,100),
    random.randrange(0,100),
    random.randrange(0,100),
    random.randrange(0,100)
]

for i in ramdomArray:
    print(f"Valor aleatório do array: {i}")