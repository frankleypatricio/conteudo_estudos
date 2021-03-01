try:
    print(x)
except NameError: # Exception definida
    print("X não definido")
except: # Exception não definida
    print("Erro desconhecido")
finally: # Exibe independende do erro
    print("Fim do Try Except")

x=10
try:
    print(x)
except NameError:
    print("X não definido")
else: # Se não der erro, exibe
    print("Tudo Certo")

x=int(input("Digite: "))
if not type(x) is int:
    raise Exception("X deve ser do tipo inteiro") # Gera uma exceção

try:
    if x<10 :
        raise Exception("X deve ser menor maior que 10") # Gera uma exceção
except:
    print("Erro desconhecido")
else:
    print("Tudo Certo")
finally:
    print("Fim do Programa")