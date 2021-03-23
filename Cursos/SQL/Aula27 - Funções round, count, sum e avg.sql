/* Somando colunas(sum) e arredondando(round)
***********************************************/
select round(sum(valor),2) as Soma from venda; /* Params: valor, n° de casas à arredondar */

/* Calculando média(avg) e arredondando(round)
***********************************************/
select round(avg(valor),2) as Média from venda;


select
	round(avg(valor),2) as 'Média de Vendas',
	round(sum(valor),2) as 'Valor Total das Vendas',
	count(valor) as 'Total de Vendas'
from venda;