# A CLASSES EM PYTHON
class PrimeiraClasse:
    
    def imprimir_mensagem(self, nome): # Criando um método
        print(f"Olá {nome}, seja bem vindo!")
objeto1 = PrimeiraClasse() # Instanciando um objeto do tipo PrimeiraClasse
objeto1.imprimir_mensagem('João') # Invocando o método

class Calculadora:
    def somar(self, n1, n2):
        return n1 + n2
    def subtrair(self, n1, n2):
        return n1 - n2
    def multiplicar(self, n1, n2):
        return n1 * n2
    def dividir(self, n1, n2):
        return n1 / n2
    def dividir_resto(self, n1, n2):
        return n1 % n2

calc = Calculadora()
print('Soma:', calc.somar(4, 3))
print('Subtração:', calc.subtrair(13, 7))
print('Multiplicação:', calc.multiplicar(2, 4))
print('Divisão:', calc.dividir(16, 5))
print('Resto da divisão:', calc.dividir_resto(7, 3))

# CONSTRUTOR DA CLASSE __INIT__()
class Televisao:
    def __init__(self): # Em Python, o método construtor é chamado de __init__()
        self.volume = 10 # Um atributo de instância é uma variável precedida com o parâmetro self
    def aumentar_volume(self):
        self.volume += 1
    def diminuir_volume(self):
        self.volume -= 1
tv = Televisao()
print("Volume ao ligar a tv = ", tv.volume)
tv.aumentar_volume()
print("Volume atual = ", tv.volume)

# VARIÁVEIS E MÉTODOS PRIVADOS
# Em Python, não existem modificadores de acesso e todos os recursos são públicos.
# Para simbolizar que um atributo ou método é privado, por convenção, usa-se
# um sublinhado "_"  antes do nome; por exemplo, _cpf, _calcular_desconto().
class ContaCorrente:
    def __init__(self):
        self._saldo = None
    def depositar(self, valor):
        self._saldo += valor
    def consultar_saldo(self):
        return self._saldo

# HERANÇA EM PYTHON
# A sintaxe para criar a herança é feita com parênteses após o nome da classe:
# class NomeClasseFilha(NomeClassePai). Se for uma herança múltipla,
# cada superclasse deve ser separada por vírgula.
class Pessoa:
    def __init__(self):
        self.cpf = None
        self.nome = None
        self.endereco = None
class Funcionario(Pessoa):
    def __init__(self):
        self.matricula = None
        self.salacio = None
    def bater_ponto(self):
        # código aqui
        pass
    def fazer_login(self):
        # código aqui
        pass
class Cliente(Pessoa):
    def __init__(self):
        self.codigo = None
        self.dataCadastro = None
    def fazer_compra(self):
        # código aqui
        pass
    def pagar_conta(self):
        # código aqui
        pass

f1 = Funcionario()
f1.nome = "Funcionário A"
print(f1.nome)
c1 = Cliente()
c1.cpf = "111.111.111-11"
print(c1.cpf)

# MÉTODOS MÁGICOS EM PYTHON
# Quando uma classe é criada em Python, ela herda, mesmo que não declarado explicitamente,
# todos os recursos de uma classe-base chamada object. Veja o resultado da função dir(),
# que retorna uma lista com os recursos de um objeto.
print(dir(Pessoa()))
# Como é possível observar na saída 12 (Out[12]), a classe Pessoa, que explicitamente
# não tem nenhuma herança, possui uma série de recursos nos quais os nomes estão com
# underline (sublinhado). Todos eles são chamados de métodos mágicos e, com a herança,
# podem ser sobrescritos

# MÉTODO CONSTRUTOR NA HERANÇA E SOBRESCRITA
# Para utilizar o construtor da classe-base, é necessário invocá-lo explicitamente,
# dentro do construtor-filho, da seguinte forma: ClassePai.__init__().
class int42(int):
    # Aparentemente, esses underline duplo (__) são para sobrescrever (vendo que init é herdado da class object)
    def __init__(self, n): # O método construtor é um método mágico, assim como o __add__ e o __str__.
        int.__init__(n) #Chamando o construtor da classe pai
    def __add__(a, b): # Métodod sobreescrito
        return 42
    def __str__(n): # Métodod sobreescrito
        return '42'
a = int42(7)
b = int42(13)
print(a + b)
print(a)
print(b)
c = int(7)
d = int(13)
print(c + d)
print(c)
print(d)

# HERANÇA MÚLTIPLA
class Ethernet():
    def __init__(self, name, mac_address):
        self.name = name
        self.mac_address = mac_address
class PCI():
    def __init__(self, bus, vendor):
        self.bus = bus
        self.vendor = vendor
class USB():
    def __init__(self, device):
        self.device = device
class Wireless(Ethernet):
    def __init__(self, name, mac_address):
        Ethernet.__init__(self, name, mac_address)
class PCIEthernet(PCI, Ethernet):
    def __init__(self, bus, vendor, name, mac_address):
        PCI.__init__(self, bus, vendor)
        Ethernet.__init__(self, name, mac_address)
class USBWireless(USB, Wireless):
    def __init__(self, device, name, mac_address):
        USB.__init__(self, device)
        Wireless.__init__(self, name, mac_address)
        
eth0 = PCIEthernet('pci :0:0:1', 'realtek', 'eth0', '00:11:22:33:44')
wlan0 = USBWireless('usb0', 'wlan0', '00:33:44:55:66')
print('PCIEthernet é uma PCI?', isinstance(eth0, PCI))
print('PCIEthernet é uma Ethernet?', isinstance(eth0, Ethernet))
print('PCIEthernet é uma USB?', isinstance(eth0, USB))
print('\nUSBWireless é uma USB?', isinstance(wlan0, USB))
print('USBWireless é uma Wireless?', isinstance(wlan0, Wireless))
print('USBWireless é uma Ethernet?', isinstance(wlan0, Ethernet))
print('USBWireless é uma PCI?', isinstance(wlan0, PCI))