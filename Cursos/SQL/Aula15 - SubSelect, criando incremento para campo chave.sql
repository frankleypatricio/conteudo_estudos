/* Seleciona o valor máximo do id do cliente
**********************************************/
select max(id) from cliente;

/* Usando Select para inserir cliente com o próximo ID
********************************************************/
insert into cliente
values (
	(select max(c.id)+1 from cliente as c), /* Precisa do ALIAS aqui*/
	'Kevin',
	'15623895674',
	'1990-02-08',
	1
);