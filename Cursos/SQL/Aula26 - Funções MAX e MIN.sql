/* Selecionando o mínimo e máximo em uma tabela
************************************************/
select max(valor) as 'Maior Venda' from venda; /* Selecionando o maior valor em 'valor' */

select * from venda
where valor = (select max(valor) from venda);

select * from venda
where valor = (select min(valor) from venda);