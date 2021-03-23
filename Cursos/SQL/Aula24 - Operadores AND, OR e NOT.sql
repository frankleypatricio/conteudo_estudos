/* Operadores AND, OR e NOT
****************************/
select * from cliente
where data_nasc is not null and id_tipo_cliente=1; /* As duas condições tem que ser verdadeiras com o 'and' */

select * from cliente
where not id_tipo_cliente=2; /* A condição deve ser falsa com o 'not' */

