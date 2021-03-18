create database cfbcursos;

create table cliente(
	id int primary key auto_increment,
	nome varchar(100) not null,
	cpf varchar(11) not null unique,
	data_nasc datetime
);

