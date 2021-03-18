/* Deletando tabelas e databases
*********************************
drop table cliente
drop database cfbcursos;
*/

/* Alterando uma coluna da tabela
**********************************/
alter table cliente modify column nome varchar(30) not null;

/* Adicionando uma coluna na tabela
************************************/
alter table cliente add tipo_cliente int not null default 1;

/* Removendo uma coluna na tabela
***********************************/
alter table cliente drop column tipo_cliente;