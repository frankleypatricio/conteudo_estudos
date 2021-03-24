/* Selecionando CPFs que terminam com 4,5 ou 8
***********************************************/
select * from cliente
where right(cpf,1) in (4,5,8);

select * from cliente
where right(cpf,3) in (174,278);

/* Obtendo dados pro in através de um Select
**********************************************/
select * from cliente
where data_nasc in(
	select data_nasc from cliente
	where data_nasc > '1990-01-01' and data_nasc < '1998-01-01'
);