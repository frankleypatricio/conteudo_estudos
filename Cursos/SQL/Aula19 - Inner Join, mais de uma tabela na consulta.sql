/* Aplicando um Inner Join no Select para juntar dados de tabelas
*******************************************************************/
select
	c.id as ID, c.nome as Nome, c.cpf as CPF, c.data_nasc as 'Data Nasc.', tc.descricao as Tipo
from cliente c
	inner join tipo_cliente tc on c.id_tipo_cliente = tc.id /* Selecionando os que o ID de uma tabela é igual o da FK da outra */
;

select
	v.id as ID,
	c.nome as Nome,
	tc.descricao as Tipo,
	v.data_venda as 'Data',
	v.valor as Valor
from venda v
	inner join cliente c on v.id = c.id
	inner join tipo_cliente tc on tc.id = c.id
;