/* Inserindo dados nas tebelas
*******************************/
insert into tipo_cliente values (1,'Pessoa física');
insert into tipo_cliente values (2,'Pessoa jurídica');
insert into tipo_cliente values (3,'Cliente especial');

insert into cliente values (1,'Lucas','03540002174', '1994-09-12', 1);
insert into cliente values (2,'João','13543458974', '1995-08-23', 2);
insert into cliente values (3,'Larissa','13576852174', '1996-03-08', 2);
insert into cliente values (4,'Luana','13534552174', '1997-06-10', 1);
insert into cliente values (5,'George','23546852174', '1998-03-01', 1);
insert into cliente values (6,'Matheus','23446852174', '1999-01-01', 3);
insert into cliente values (7,'Sarah','13545652174', '2000-03-07', 1);

/* Inserindo dados informando as tabelas nas tebelas
*****************************************************/
insert into cliente(nome, cpf, data_nasc) values ('Julia','15431266278', '2000-05-06');


/* Selecionando todos os dados da tabela
*****************************************/
select * from tipo_cliente;
select * from cliente;