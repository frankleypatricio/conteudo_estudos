/* Out e condicionais em procedures
************************************/

delimiter $$

create procedure idade(in idCliente int, out idade int, out res varchar(5)) /* in - valores de entrada / out - valores de saída */
begin
	declare dt datetime;
	set dt = (select data_nasc from cliente where id=idCliente);
	set idade = year(now()) - year(dt);

	if(idade >= 18) then set res='Maior';
	else set res='Menor';
	end if;


	/* select idade,res; - não é necessário ao usar o out, pois o resultado fica nele */
end $$

delimiter ;

call idade(24,@idade,@res); # @idade - criando uma var pra receber o out
select @idade,@res;