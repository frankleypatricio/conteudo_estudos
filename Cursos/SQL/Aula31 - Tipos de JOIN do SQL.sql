/* Comum entre as tabelas
**************************/
select c.id as ID, c.nome as Nome, v.id as 'Venda ID'
from cliente c
inner join venda v on c.id = v.id;

/* Todos da primeira tabela e o que tem de comum como ela da segunda
*********************************************************************/
select c.id as ID, c.nome as Nome, v.id as 'Venda ID'
from cliente c
left join venda v on c.id = v.id;

/* Todos da segunda tabela e o que tem de comum como ela da primeira
*********************************************************************/
select c.id as ID, c.nome as Nome, v.id as 'Venda ID'
from cliente c
right join venda v on c.id = v.id;