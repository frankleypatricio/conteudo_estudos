create table tipo_cliente(
	id int primary key auto_increment,
	descricao varchar(100) not null
);

/* Adicionando restrição de chave estrangeira na coluna
*********************************************************/
alter table cliente add constraint fk_tipo_cliente foreign key(id_tipo_cliente) references tipo_cliente(id);