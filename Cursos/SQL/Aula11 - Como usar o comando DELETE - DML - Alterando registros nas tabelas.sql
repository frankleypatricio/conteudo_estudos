/* Deleta todos os dados de cliente
************************************
delete from cliente; */

insert into cliente (nome,cpf,data_nasc,id_tipo_cliente) values('David', '12345678952', '1989-01-02', 2);
select * from cliente where id_tipo_cliente=2;

/* Deleta todos os dados específicos de cliente
************************************************/
delete from cliente where id_tipo_cliente=2;