# import moduloXXText - Importação comum
# import moduloXX as apelido - Importação atribuindo um apelido
# from moduloXX import itemA, itemB - Importação de somente funcionalidades específicas de um módulo são carregadas na memória
import math as m
m.sqrt(25)
m.log2(1024)
m.cos(45)

from math import sqrt, log2, cos
sqrt(25)
log2(1024)
cos(45)

import random
print(random.randint(0, 100))
print(random.choice([1, 10, -1, 100]))
print(random.sample(range(100000), k=12))

import os # é um módulo built-in usado para executar comandos no sistema operacional
os.getcwd()
os.listdir()
os.cpu_count()
os.getlogin()
os.getenv(key='path')
os.getpid()

import re # (regular expression) fornece funções para busca de padrões em um texto
string = 'meuArquivo_20-01-2020.py'
padrao = "[a-zA-Z]*"
texto1 = re.search(padrao, string).group() # procura o primeiro local onde o padrão de expressão regular produz uma correspondência e o retorna
texto2 = re.match(padrao, string).group() # procura por um padrão no começo da string
texto3 = re.split("_", string)[0] # divide uma string pelas ocorrências do padrão
print(texto1)
print(texto2)
print(texto3)

# MÓDULO DATETIME
import datetime as dt
# Operações com data e hora
hoje = dt.datetime.today()
ontem = hoje - dt.timedelta(days=1) # subtrair 1 dia de uma data específica
uma_semana_atras = hoje - dt.timedelta(weeks=1) # subtrair 1 dia de uma semana específica

agora = dt.datetime.now() # captura a data e hora do sistema
duas_horas_atras = agora - dt.timedelta(hours=2)
# Formatação
hoje_formatado = dt.datetime.strftime(hoje, "%d-%m-%Y") # strtime: usamos pra formatar a aparência de uma data específica
ontem_formatado = dt.datetime.strftime(ontem, "%d de %B de %Y") # strtime: usamos pra converter uma string em um objeto do tipo datetime
# Converção de string para data
data_string = '11/06/2019 15:30'
data_dt = dt.datetime.strptime(data_string, "%d/%m/%Y %H:%M")

# BIBLIOTECA REQUESTS
# A biblioteca requests habilita funcionalidades do procotolo HTTP,
# como o get e o post. Dentre seus métodos, o get() é o responsável por
# capturar informação da internet. A documentação sobre ela está disponível
# no endereço https://requests.readthedocs.io/pt_BR/latest/
import requests
info = requests.get('https://api.github.com/events')
info.headers
print(info.headers['date']) # Data de extração
print(info.headers['server']) # Servidor de origem
print(info.headers['status']) # Status HTTP da extração, 200 é ok
print(info.encoding) # Encoding do texto
print(info.headers['last-modified']) # Data da última modificação da informação

#Para acessar o conteúdo que foi extraído, podemos usar a propriedade text,
# que converte todo o conteúdo para uma string...
texto_str = info.text
print(type(texto_str))
texto_str[:100] # exibe somente os 100 primeiros caracteres
# ou então o método json(), que faz a conversão para uma lista de dicionários.
texto_json = info.json()
print(type(texto_json))
texto_json[0]

# Vamos utilizar a biblioteca requests para extrair informações da
# Copa do Mundo de Futebol Feminino, que aconteceu no ano de 2019.

# primeiro passo extrair as informações com o request utilizando o método json().
import requests
import datetime as dt
jogos = requests.get('http://worldcup.sfg.io/matches').json()
print(type(jogos))

# segundo passo: percorrer cada dicionário da lista (ou seja, cada jogo) extraindo as informações
info_relatorio = []
file = open('relatorio_jogos.txt', "w") # cria um arquivo txt na pasta em que está trabalhando.
for jogo in jogos:
    data = jogo['datetime'] # extrai a data
    data = dt.datetime.strptime(data, "%Y-%m-%dT%H:%M:%SZ") # converte de string para data
    data = data.strftime("%d/%m/%Y") # formata
    
    nome_time1 = jogo['home_team_country']
    nome_time2 = jogo['away_team_country']

    gols_time1 = jogo['home_team']['goals']
    gols_time2 = jogo['away_team']['goals']
    
    linha = f"({data}) - {nome_time1} x {nome_time2} = {gols_time1} a {gols_time2}"
    file.write(linha + '\n') # escreve a linha no arquivo txt
    info_relatorio.append(linha)
file.close() # é preciso fechar o arquivo
info_relatorio[:5]

# MATPLOTLIB
# Matplotlib é uma biblioteca com funcionalidades para criar gráficos,
# cuja documentação está disponível no endereço https://matplotlib.org/.

# ler o arquivo salvo
file = open('relatorio_jogos.txt', 'r')
print('file = ', file, '\n')
info_relatorio = file.readlines()
file.close()
print("linha 1 = ", info_relatorio[0])

# Extrair somente a parta 'dd/mm' da linha
datas = [linha[1:6] for linha in info_relatorio]
print(sorted(datas))

datas_count = [(data, datas.count(data)) for data in set(datas)]
print(datas_count)

datas_count = dict(datas_count)
print(datas_count)

%matplotlib inline
import matplotlib.pyplot as plt
eixo_x = datas_count.keys()
eixo_y = datas_count.values()
plt.figure(figsize=(15, 5))
plt.xlabel('Dia do mês')
plt.ylabel('Quantidade de jogos')
plt.xticks(rotation=45)
plt.bar(eixo_x, eixo_y)
plt.show()