listAnimals = [] # Lista onde conterá todos os animais

class Animal: # Classe onde conterá os dados dos animais carregados do banco
    id=-1
    especie=""
    ultiOrden=""
    nvProduti=0
    insemin=False
    estimaParto=""
    def __init__(self,id,especie,ultiOrden,nvProduti,insemin,estimaParto):
        self.id=id
        self.especie=especie
        self.ultiOrden=ultiOrden
        self.nvProduti=nvProduti
        self.insemin=insemin
        self.estimaParto=estimaParto

def buscarAnimal(list, id): # Função que realizará a busca binária do animal
    min=0
    max=len(list) - 1
    meio=0
    while min <= max:
        meio = (min + max) // 2
        if id < list[meio].id:#.id ? ou teria que criar um método getID() ?
            max = meio - 1
        elif id > list[meio].id:
            min = meio + 1
        else:
            return meio 
    return -1

listVacas.append(Animal(1,"Harry Hunter","25/05/35",100,False,50))
listVacas.append(Animal(2,"Harry Poter","25/05/35",600,False,50))

print(str(buscarAnimal(listVacas,1)))