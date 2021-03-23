/* Valores nulos
******************/
select * from cliente
where data_nasc is null; /* Se for nulo */

select * from cliente
where data_nasc is not null; /* Se não for nulo */