/* Selecionando colunas específicas
************************************/
select nome from cliente;

/* Selecionando colunas utilizando uma expressão matemática
*************************************************************/
select nome, id_tipo_cliente*2  from cliente;

/* Selecionando colunas convertendo o nome pra maiúsculo
**********************************************************/
select upper(nome), cpf from cliente;