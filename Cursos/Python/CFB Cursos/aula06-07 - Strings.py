if(input() == "1"):
    # Strings Parte 1
    texto="Curso de Python" #Uma string é uma cadeia de caracteres...
    print(texto[3]) #...por isso é possível imprimir suas posições
    print(texto[9:15]) #E também imprimir intervalos de posições

    print(f"Tamanho da string: {len(texto)}") #Retornando o tamanho da string

    texto2=" ESPAÇOS "
    print("-"+texto2+"-")
    print("-"+texto2.strip()+"-") #Remove espaços no início e fim da string
    print(texto2.lower()) #Converte pra minúsculo
    print(texto2.upper()) #Converte pra maiúsculo
    #Para usar mais de um método de uma vez só usar assim: texto2.strip().lower()

    texto=texto.replace("Python","C#")
    print(texto) #Substitui string
    print(texto.lower().replace("c","F")) #Teste comprovado: Substitui todas as letras c por F (e diferencia maiuscula de minúscula)

    array=texto.split(" ") #Separa a string em partes a cada espaço vazio encontrado, retornando um array de strings
    i=0
    for s in array:
        print(f"Pos {i}: {s}")
        i=i+1

else:
    # Strings Parte 2
    texto3="Curso de Píton"
    result="Python" in texto3 #Retorna se a string "Python" está na var texto3 (diferencia maiúscula de minúscula)
    print(result)
    result="Python" not in texto3 #Retorna se a string "Python" não está na var texto3
    print(result)

    dia=20; mes=9; ano=2020
    #data=f"{dia}/{mes}/{ano}" - Uma outra forma de fazer o código abaixo, só que mais simples, mas é aquilo, casos e casos...
    data="{}/{}/{}" #Declarando placeholders para formatação de dados (pode ser muito útil para exibir certas formatações pré estabelecidas("máscaras") tipo data, cpf, cep...) (esse placeholder é do tipo str)
    print(data.format(dia,mes,ano)) #Formatando dados na variável com placeholder de uma "máscara" de data

    # Caracteres de escape (podem ser adicionados no placeholder também)
    #\' - imprime um '
    #\" - imprime um "
    #\n - imprime uma quebra de linha
    #\r - imprime um retorno (tipo pressionar enter pra encerrar o comando)
    #\t - imprime um tab
    #\b - imprime um backspace (apaga um caractere)