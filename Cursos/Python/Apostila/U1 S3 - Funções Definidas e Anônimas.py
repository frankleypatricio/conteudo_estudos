# FUNÇÕES BUILT-IN EM PYTHON (funções pardão presentes em python)
# abs()	delattr()	hash()	memoryview()	set()
# all()	dict()	help()	min()	setattr()
# any()	dir()	hex()	next()	slice()
# ascii()	divmod()	id()	object()	sorted()
# bin()	enumerate()	input()	oct()	staticmethod()
# bool()	eval()	int()	open()	str()
# breakpoint()	exec()	isinstance()	ord()	sum()
# bytearray()	filter()	issubclass()	pow()	super()
# bytes()	float()	iter()	print()	tuple()
# callable()	format()	len()	property()	type()
# chr()	frozenset()	list()	range()	vars()
# classmethod()	getattr()	locals()	repr()	zip()
# compile()	globals()	map()	reversed()	__import__()
# complex()	hasattr()	max()	round()	

a = 2
b = 1
equacao = input("Digite a fórmula geral da equação linear (a * x + b): ")
print(f"\nA entrada do usuário {equacao} é do tipo {type(equacao)}")
for x in range(5):
    y = eval(equacao) # Recebe uma equação de entrada e transforma numa expressão e faz o cálculo
    print(f"\nResultado da equação para x = {x} é {y}")

# FUNÇÃO DEFINIDA PELO USUÁRIO
def imprimir_mensagem(disciplina, curso):
    print(f"Minha primeira função em Python desenvolvida na disciplina: {disciplina}, do curso: {curso}.")
imprimir_mensagem("Python", "ADS")

def somar(a, b): # Não precisa passar um tipo de retorno igual outras linguagens, até porque não é fortemente tipada
    return a + b
r = somar(2,6)
print(r)

def converter_minuscula(texto, flag_minuscula=True): # O parâmetro flag_minuscula possui True como valor padrão...
    if flag_minuscula:
        return texto.lower()
    else:
        return texto.upper()
texto1 = converter_minuscula(flag_minuscula=True, texto="LINGUAGEM de Programação")
texto2 = converter_minuscula(texto="LINGUAGEM de Programação") # ... assim não necessita passá-lo se não quiser
print(f"\nTexto 1 = {texto1}")
print(f"\nTexto 2 = {texto2}")

# Essa função possibilita passar ou não argumentos, que são salvos em um array que é a var "kwargs" (tipo o params de C#)
def imprimir_parametros(**kwargs): #(*kwargs) - com um * é obrigatório passar o argumento
    print(f"Tipo de objeto recebido = {type(kwargs)}\n")
    qtde_parametros = len(kwargs)
    print(f"Quantidade de parâmetros = {qtde_parametros}")
    
    for chave, valor in kwargs.items():
        print(f"variável = {chave}, valor = {valor}")
print("\nChamada 1")        
imprimir_parametros(cidade="São Paulo", idade=33, nome="João")
print("\nChamada 2")        
imprimir_parametros(desconto=10, valor=100)

# FUNÇÕES ANÔNIMAS EM PYTHON (Expressão Lambda)
(lambda x: x + 1)(x=3) # 1° parênteses é a função anônima e o 2° está chamando essa função
(lambda x, y: x + y)(x=3, y=2)

somar = lambda x, y: x + y # Atribuindo lambda a uma variável
somar(x=5, y=3) # Chamando função anônima