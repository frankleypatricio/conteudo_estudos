/* Ordenando dados com OrderBy
*******************************/
select *
from cliente
order by nome;

select *
from cliente
order by id_tipo_cliente, nome; /* Ordenando primeiro por tipo e depois por nome */

select *
from cliente
order by 2; /* Ordenando pela coluna na posição 2 (nome) */

select *
from cliente
order by 2 desc; /* Ordenando em decrescente (asc é o padrão) */

select *
from cliente
order by right(cpf,3); /* Retornando os 3 últimos dígitos da direita e ordenando por eles */