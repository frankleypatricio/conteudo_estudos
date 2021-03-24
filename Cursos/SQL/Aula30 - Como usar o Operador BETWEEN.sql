/* Selecionando clientes em que o ID do tipo está entre 1 à 3
**************************************************************/
select * from cliente
where id_tipo_cliente between 1 and 3;

select * from venda
where (data_venda between '2020-07-01' and '2020-10-01') and
id_cliente not in (8,10);