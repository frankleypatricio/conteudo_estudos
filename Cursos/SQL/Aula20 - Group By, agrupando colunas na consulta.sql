/* Agrupando consultas com Group By
************************************/
select tc.descricao as Tipo, count(c.id_tipo_cliente) as QTD /* Retornando quantidade de cada tipo */
from cliente c
inner join tipo_cliente tc on tc.id = c.id_tipo_cliente
group by c.id_tipo_cliente;  /* Não repete tipos, só exibe o primero registo com cada tipo */

select v.data_venda as Data, count(v.id) as QTD
from venda v
group by data_venda;