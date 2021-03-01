# import aula34Extern as A34 # Importa o arquivo e define ele como "A34" para ser acessado no programa
import os
from aula34Extern import pessoa # Importando apenas um item da biblioteca (no caso só um arquivo mesmo, não biblioteca kk)

#  A34.imprimir()
print(pessoa['Nome']) # Imprime o jogador importado do Extern
print(dir(os)) # Imprime tudo o que está na biblioteca