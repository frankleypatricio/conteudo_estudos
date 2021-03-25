/* Criando um cursor (tipo que um iterator pra consultas)
**********************************************************/
delimiter $$

create procedure aulacursor(out soma float)
begin
	declare vv float default 0;
	declare done int default 0;

	declare meucursor cursor for select valor from venda; /* Associando select ao cursor */
	declare continue handler for not found set done=1; /* Quando não encontrar mais dados no cursor */
	
	set soma=0;
	open meucursor; /* Abrindo cursor */
	while(done != 1)do
		fetch meucursor into vv; /* Passando valor pra var vv (tipo um getline() ou iterator de C) */
		set soma = soma+vv;
	end while;
end $$

delimiter ;

call aulacursor(@res);
select round(@res,2) as Resultado;