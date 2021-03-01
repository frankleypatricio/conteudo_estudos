#Aula 63 - Variáveis em Python

var1="Var 1" #Essa variável é global porque está em escopo global

def teste(): #Declara uma função
    global var1 # Preciso "redeclarar" como global para usar variáveis de fora do escopo
    print(f"Dentro: {var1}")
    var1="Var 1 Parte 2"
    var2="Var 2" #Essa variável é local porque está no escopo da função sem o indicador global
    global var3 #O indicador global diz que a variável é global
    var3="Var 3" #Variáveis com o indicador global devem ser iniciadas na próxima linha
    print(f"Dentro: {var2}")

teste() #Chama a função

print(f"Fora: {var1}")
#print(var2) - Retorna erro, pois essa variável é local da função
print(f"Fora: {var3}")