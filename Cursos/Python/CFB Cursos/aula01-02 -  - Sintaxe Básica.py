#Aula 01/02 - Sintaxe Básica

var=10 #Não é fortemente tipada, podendo uma variável receber qualquer tipo de dado, definindo ao atribuir
print(var)
var="String"
print(var)
var=True
print(var); print("; Ever") #A quebra de linha indica o final de um comando, para escrever mais de um em uma linha deve se usar o ;

"""
Comentário de múltiplas linhas
"""

valor=10
if valor>5: #Não necessita de () e deve ter o : no final
    print(str(valor)+" é maior que 5") #O que define o que está dentro do escopo são os espaços (os códigos devem ter a mesma quantidade de espaços)
if(valor>10):
    print(str(valor)+" é maior que 10")
print("Fim do programa")