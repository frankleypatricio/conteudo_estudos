/* Unindo tameblas em um Select
********************************/
/* Obs:
- Pra unir, tem que ter a mesma quantidade de colunas;
- Deve ter as mesmas colunas (de mesmo tipo, ex: dois IDs);
- As colunas devem estar na mesma ordem.
*/
select 'Cliente' as Tabela,id,nome from cliente union /* Esse texto 'Cliente' aparecerá na primeira coluna de todos os resultados */
select 'Cliente Aux',id,nome from cliente_aux union
select 'Venda',v.id,c.nome from venda v
inner join cliente c on v.id_cliente = c.id;