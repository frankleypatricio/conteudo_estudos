import json

print("-------------------------Transformando arquivo JSON em Dictionary-------------------------")
carrosJson='{"marca":"Honda","modelo":"HRV","cor":"Prata"}' # JSON: Estrutura igual dictionary em python

carros=json.loads(carrosJson) # loads() carrega e transforma em uma string

print(type(carros)) # Ele vira um dictionary
print(carros["modelo"])
print("---------------")
for x in carros:
    print(x)
print("---------------")
for x in carros.values():
    print(x)

print("-------------------------Transformando Dictionary em arquivo JSON-------------------------")

cores={ # Criando um dicttionary
    "r":"vermelho",
    "g":"verde",
    "b":"azul"
}

cores_json=json.dumps(cores) # Converte dictionary pra JSON
print(cores_json)

print("-------------------------Tipos de conversão em arquivo JSON-------------------------")
styles_dic={ # Dictionary viram arquivos de objetos em JSON
    "D":"Rank D",
    "C":"Rank C",
    "B":"Rank B",
    "A":"Rank A",
    "S":"Rank S",
    "SS":"Rank SS",
    "SSS":"Rank SSS"
}
# Listas e Tuplas viram arrays em JSON
styles_list=[
    "Rank D",
    "Rank C",
    "Rank B",
    "Rank A",
    "Rank S",
    "Rank SS",
    "Rank SSS"
]
styles_tuple=(
    "Rank D",
    "Rank C",
    "Rank B",
    "Rank A",
    "Rank S",
    "Rank SS",
    "Rank SSS"
)

styles_json=json.dumps(styles_dic)
print(styles_json)
styles_json=json.dumps(styles_list)
print(styles_json)
styles_json=json.dumps(styles_tuple)
print(styles_json)

print("-----------------------------------------")
# Formatações
# indent: identação (identação=espaços/quebra de linha, o 4 são tabs)
# separators: substitui o separador das vars
# sort_keys: ordena elementos
styles_json=json.dumps(styles_dic, indent=4, separators=": ","->", sort_keys=true)  
print(styles_json)
