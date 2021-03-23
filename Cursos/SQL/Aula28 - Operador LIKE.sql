/*
% - qualquer caracter
_ - quantidade de caractere
*/

/* Clientes que começam com a letra 'j'
****************************************/
select * from cliente
where nome like('j%'); /* começa com 'j' e o resto é qualquer caractere */

/* Clientes que terminam com a letra 'o'
*****************************************/
select * from cliente
where nome like('%o'); /* termina com 'o' e o resto é qualquer caractere */

/* Clientes que começam com 'd' terminam com 'o'
*************************************************/
select * from cliente
where nome like('d%o');

/* Clientes que tem 5 letras no nome
*************************************/
select * from cliente
where nome like('_____');

/* Clientes que tem 5 letras no nome
*************************************/
select * from cliente
where nome like('j____'); /* Começa com 'j' e tem mais 4 caracteres no nome (além do j) */