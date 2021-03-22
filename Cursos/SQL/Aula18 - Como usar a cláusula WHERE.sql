/* Usando a cláusula where
***************************/
select * from cliente
where
	id_tipo_cliente in(1,2) and /* in() - Entre 2 e 3 */
	(month(data_nasc) >= 4 and month(data_nasc) <= 9) /* Mês de nasc. maior que 5 */
;