lista=[ # Matriz é um list com lists dentro
    ["Caneta","Compactor"],
    ["Lápis","Faber-Castell"],
    ["Borracha","Bic"]
]

print(armas[2][1])

for linha,coluna in armas:
    print("Linha: "+linha+" - Coluna: "+coluna)