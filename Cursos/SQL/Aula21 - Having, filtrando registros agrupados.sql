/* Filtrando dados com Having
*******************************/
select * from venda having data_venda > '2020-10-01';

select * from venda having count(id) >= 2;