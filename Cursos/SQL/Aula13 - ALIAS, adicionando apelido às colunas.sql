/* Dando um apelido para as colunas
*************************************/
select id as ID, nome as Nome, cpf as CPF from cliente;

/* Dando um apelido pra tabela
(mais usado quando se faz select em multiplas colunas)
********************************************************/
select
	tbc.id as ID,
	tbc.nome as Nome,
	tbc.cpf as CPF
from
	cliente tbc; /*Alguns SGBDs aceitam usar o as na tabela, outros não, no MySQL você escolhe se quer usar ou não */