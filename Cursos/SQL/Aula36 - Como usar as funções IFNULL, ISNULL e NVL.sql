/*
MySQL - ifnull ou coalesce
SQLServer - isnull
Oracle - nvl
*/

update produtovenda set qtd=null where id=1;

/* Verifica se é nulo
***********************/
select *, round((preco*ifnull(qtd,0)),2) as Total # Se for nulo, retorna 0
from produtovenda;