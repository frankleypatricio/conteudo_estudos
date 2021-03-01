import datetime

data=datetime.datetime.now() # Retorna atual data completa
print(data)
print(f"{data.day}/{data.month}/{data.year}") # Obtendo data

nasc=datetime.datetime(2000,22,5) # Criando uma data personalizada
print(nasc)

print(nasc.strftime("%A")) # Retorna uma formatação da data
# Sumário
# %a - Dia da semana resumido (tues)
# %A - Dia da semana completo (tuesday)
# %w - Número do dia da semana (dia 1, dia 2...)
# %d - Número do dia do mês
# %b - Mês abreviado
# %B - Mês
# %m - Número do mês (mês 1, mês 2...)
# %y - Ano com dois dígitos
# %Y - Ano com quatro dígitos
# %j - Dia do ano (1-366)
# %W - Número da semana do ano
# %H - Hora com dois dígitos (00 - 23)
# %I - Hora com dois dígitos (00 - 12)
# %p - AM/PM
# %M - Minutos
# %S - Segundos
# %f - Microsegundos