class Elemento:
    desc=""
    forca=0
    resistencia=0
    velocidade=0
    def __init__(self,d,f,r,v): # Construtor do python (self == this, está passando a classe no construtor)
        self.desc=d
        self.forca=f
        self.resistencia=r
        self.velocidade=v
    def dados(self): # Método
        print(f"Força: {self.desc}")
        print(f"Força: {self.forca} / Resistência: {self.resistencia} / Velocidade: {self.velocidade}")
class Agua(Elemento):
    def __init__(self,desc): # Está sobrepondo o construtor da classe pai
        self.forca=60
        self.resistencia=30
        self.velocidade=80
        super().__init__(desc,self.forca,self.resistencia,self.velocidade) # super() chama um método da classe pai
    def dados(self):
        super().dados()

agua=Agua("Um elemento molhado!")
agua.dados()