create table cliente_aux(
	id int primary key auto_increment,
	nome varchar(100) not null,
	cpf varchar(11) not null unique,
	data_nasc datetime,
	id_tipo_cliente int not null default 1,
	key fk_tipo_cliente (id),
	constraint fk_tipocliente_aux foreign key (id_tipo_cliente) references tipo_cliente(id)
);

/* Inserindo na tabela os dados selecionados de uma outra tabela
******************************************************************/
insert into cliente_aux
	(nome, cpf, data_nasc, id_tipo_cliente)
select
	nome,
	cpf,
	data_nasc,
	id_tipo_cliente
from cliente;

select * from cliente_aux;
