/* Correlacionando dados de uma mesma tabela
*********************************************/
select * from cliente c1, cliente c2
where c1.id_tipo_cliente = c2.id_tipo_cliente
order by c1.id_tipo_cliente;