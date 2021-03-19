/* Atualizando dados na tabela
********************************/
update cliente set nome='Diego' where id=5;
update cliente set nome='Jairo', cpf='14536985620' where id=2;
update cliente set id_tipo_cliente=1 where id_tipo_cliente>0;

select * from cliente;