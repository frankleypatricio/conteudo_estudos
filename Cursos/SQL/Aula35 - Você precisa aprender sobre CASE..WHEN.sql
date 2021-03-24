/* if else do SQL
******************/
select
	id,
	nome,
	cpf,
	case
		/*when data_nasc is null then now() - Se data for nula, coloca a data de hoje */
		when data_nasc < '2000-01-01' then now() /* após o then é o retorno */
		else data_nasc
	end 'data_nasc',
	id_tipo_cliente,
	case	
		when (datediff(now(),data_nasc)/365) > 18 then 'Maior' /* Esse datediff compara a diferença entre 2 datas */
		else 'Menor'
	end 'Situação'
from cliente;