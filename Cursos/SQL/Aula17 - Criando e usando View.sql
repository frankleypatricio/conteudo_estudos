/* Criando uma view
*********************/
create view cpf_cliente as select id,cpf from cliente;

create view nivers_mes as
select
	id,
	nome,
	day(data_nasc)/* Retorna apenas o dia */
from
	cliente
where
	month(data_nasc) = month(curdate()); /* Verifica mês do nasc. com o atual */

/* Chamando view
******************/
select * from cpf_cliente;
select * from nivers_mes;