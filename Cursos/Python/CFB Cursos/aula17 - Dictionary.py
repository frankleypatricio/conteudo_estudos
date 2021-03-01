# Chave / Valor
cores={"#FF0000":"Red", "#00FF00":"Green", "#0000FF":"Blue"} # É o Map do C++

print(cores["#FF0000"]) # cores.get("#FF0000") também funciona

for key in cores:
    print("Chave: "+key+" - Valor: "+cores[key])
print("-------------------------------------------------------")
for key,value in cores.items():
    print(key+" : "+value)

if "#FF0000" in cores:
    print("A chave #FF0000 está em cores")

cores["#000000"]="Black" # Adiciona
print(cores["#000000"])
cores.pop("#000000") # Remove, e del cores["#000000"] também funciona

tipos_cores={
    "Quentes":{
        "#FF0000":"Vermelho",
        "#FFFF00":"Amarelo"
    },
    "Frias":{
        "#0000FF":"Azul",
        "#00FFFF":"Turqueza"
    }
}

print(chars["Frias"]["#00FFFF"])