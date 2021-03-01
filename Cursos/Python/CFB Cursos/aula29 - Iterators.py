nomes=["Lucas", "Ana", "Diego", "Beatriz", "Julia"]
iterator=iter(nomes) # Criando um iterator

while iterator:
    try:
        print(next(iterator))
    except StopIteration: # Excessão de fim do iterator
        print("Fim da Lista")
        break