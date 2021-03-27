import sqlite3
from sqlite3 import Error

# Criando conexão
def connect():
    path="D:\\htdocs\\Conteúdo de Aulas\\Cursos\\Python\\CFB Cursos\\agenda.db"
    con=None

    try:
        con=sqlite3.connect(path) # Tentando conexão
    except Error as ex:
        print(ex)
    
    return con

# Criando tabela
def create_table(sql):
    try:
        with connect() as con:
            con.execute(sql)
            print("Tabela criada!")
    except Error as ex:
        print(ex)

# Inserindo dados
def insert(sql):
    try:
        with connect() as con:
            c=con.cursor()
            c.execute(sql)
            con.commit() # Serve para fazer a persistência do registro, para aparecer no db
            print("Registo inserido!")
    except Error as ex:
        print(ex)

# Deletando dados
def remove(sql):
    try:
        with connect() as con:
            c=con.cursor()
            c.execute(sql)
            con.commit() # Serve para fazer a persistência do registro, para aparecer no db (confirmando a remoção)
            print("Registo removido!")
    except Error as ex:
        print(ex)

# Atualizando dados
def update(sql):
    try:
        with connect() as con:
            c=con.cursor()
            c.execute(sql)
            con.commit() # Serve para fazer a persistência do registro, para aparecer no db
            print("Registo atualizado!")
    except Error as ex:
        print(ex)

# Selecionando dados
def select(sql):
    try:
        with connect() as con:
            c=con.cursor()
            c.execute(sql)
            res=c.fetchall() # Retornando resultados do select
            return res
    except Error as ex:
        print(ex)

done=False
while(not done):
    op=int(input("> "))
    if op==0: # Crate Table
        # Não precisa colocar comando em maiúsculo
        table="""CREATE TABLE teste(
            id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
            teste VARCHAR(30) UNIQUE NOT NULL
        );"""
        create_table(vsql)
    if op==1: # Insert
        nome=input("Nome: ")
        tel=input("Telefone: ")
        email=input("Email: ")
        _insert=f"INSERT INTO contatos (nome,tel,email) VALUES ('{nome}','{tel}','{email}')"
        insert(_insert)
    if op==2: # Delete
        id=int(input("ID: "))
        delete=f"DELETE FROM contatos WHERE id={id};"
        remove(delete)
    if op==3: # Update
        id=int(input("ID: "))
        nome=input("Nome: ")
        tel=input("Telefone: ")
        email=input("Email: ")
        up=f"UPDATE contatos SET nome='{nome}',tel='{tel}',email='{email}' WHERE id={id}"
        update(up)
    if op==4: # Select
        _select="SELECT * FROM contatos"
        res=select(_select)
        print(type(res))
        for r in res:
            print(type(r))
            print(r)
    else: # Exit
        done=True





        
