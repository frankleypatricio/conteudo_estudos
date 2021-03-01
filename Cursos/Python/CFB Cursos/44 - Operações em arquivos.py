path="D:\\htdocs\\Conteúdo das Aulas Python\\Aulas CFB\\arquivo.txt"
# Arquivo + modo de abertura:
# a- append, r- read, w- write,
# x- create (write tb cria se não existir)
# t- text, b- binary
file=open(path,"wt") # Dá pra usar mais de um, no caso está abrindo pra escrita no modo texto
file.write("Teste de escrita de arquivos")
file.close()

file=open(path,"rt")
print(file.read()) # Lê o arquivo todo
# file.readline() - lê linha a linha
print(file.read(10)) # Lê os 10 primeiros caracteres
file.close()
