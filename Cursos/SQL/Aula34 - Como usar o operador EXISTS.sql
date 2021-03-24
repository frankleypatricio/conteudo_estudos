/* Nova tabela criada na aula
*****************************/
create table produtovenda(
	id int NOT NULL AUTO_INCREMENT,
    id_venda int NOT NULL,
    descricao varchar(50) NOT NULL,
    preco float NOT NULL,
    qtd int,
    PRIMARY KEY (id),
    FOREIGN KEY (id_venda) REFERENCES venda (id)
);
insert into produtovenda values (1,1,'Mouse',7.89,1);
insert into produtovenda values (2,1,'Teclado',15.20,1);
insert into produtovenda values (3,2,'Mouse',7.89,2);
insert into produtovenda values (4,2,'Monitor',299.80,2);
insert into produtovenda values (5,2,'Microfone',34.90,2);
insert into produtovenda values (6,3,'Teclado',15.20,10);
insert into produtovenda values (7,4,'CPU',569.78,1);
insert into produtovenda values (8,4,'RAM',325.00,1);
insert into produtovenda values (9,5,'HD',329.90,2);
insert into produtovenda values (10,6,'Placa Vídeo',899.49,1);
insert into produtovenda values (11,6,'Placa Rede',19.90,1);
insert into produtovenda values (12,6,'Cx.Som',29.90,1);
insert into produtovenda values (13,6,'CPU',325.00,1);
insert into produtovenda values (14,6,'Mouse',7.89,1);
insert into produtovenda values (15,7,'Monitor',299.80,3);
insert into produtovenda values (16,7,'Mouse',7.89,2);
insert into produtovenda values (17,8,'HD',249.90,15);
insert into produtovenda values (18,9,'Placa Mãe',900.00,2);
insert into produtovenda values (19,10,'Cx.Som',29.90,2);
insert into produtovenda values (20,10,'Microfone',34.90,2);
insert into produtovenda values (21,11,'Teclado',15.20,5);
insert into produtovenda values (22,11,'CPU',989.90,2);
insert into produtovenda values (23,11,'RAM',325.00,2);
insert into produtovenda values (24,12,'HD',249.90,1);
insert into produtovenda values (25,13,'Placa Mãe',149.90,1);
insert into produtovenda values (26,14,'Impressora',889.99,3);
insert into produtovenda values (27,14,'Web Cam',599.90,3);
insert into produtovenda values (28,15,'Cabo Rede',4.99,1);
insert into produtovenda values (29,16,'Mouse',7.89,7);
insert into produtovenda values (30,17,'Teclado',15.20,8);
insert into produtovenda values (31,18,'RAM',325.00,2);
insert into produtovenda values (32,19,'HD',249.90,1);
insert into produtovenda values (33,19,'Microfone',34.90,1);
insert into produtovenda values (34,20,'Impressora',499.90,1);
insert into produtovenda values (35,20,'Web Cam',329.90,1);

insert into cliente values (10,'Cris','15935745698','2000-01-01',1);
insert into cliente values (11,'Margarete','32165498700','2001-01-01',1);
insert into cliente values (12,'Gilmar','12345678900','2002-01-01',1);
insert into cliente values (13,'Jaqueline','24789236911','2003-01-01',1);
insert into cliente values (14,'Jéssica','18785236911','1990-01-01',1);
insert into cliente values (15,'Marcus','95368715312','1991-01-01',3);
insert into cliente values (16,'Jorge','94536875612','1992-01-01',1);
insert into cliente values (17,'Aline','69756315896','1993-01-01',1);
insert into cliente values (18,'Alexa','35974563215','1994-01-01',2);
insert into cliente values (19,'Felipe','12386974562','1995-01-01',3);
insert into cliente values (20,'Franciele','75986321459','1996-01-01',2);
insert into cliente values (21,'Fábio','67458921453','1997-01-01',1);
insert into cliente values (22,'Kaio','39845621078','1998-01-01',1);
insert into cliente values (23,'Michaela','20398014650','1999-01-01',3);
insert into cliente values (24,'Otávio','56017038900','2005-01-01',1);

/* Selecionando apenas clientes que existem no resultado do Select
*******************************************************************/
select * from cliente c
where exists(select * from venda v where v.id_cliente = c.id);
