# FUNÇÕES
result=90
def somar(*n): # * antes da var é chamado de argumento arbitrário (o params do C#)
    result=0
    for i in n:
        result+=i
    return result
print(f"{somar(1,2,3,4,5)}")

def padrao(p="Padrão"): # Função com um valor padrão já embutido
    print(p)
padrao("Não Padrão")
padrao()

# LAMBDA (FUNÇÕES ANÔNIMAS)
subtrair=lambda n1,n2:n1-n2 # Atribuindo a uma var
print(f"{subtrair(5,3)}")
print(f"{(lambda a,b:a+b)(5,5)}") # Sem atribuir a uma var