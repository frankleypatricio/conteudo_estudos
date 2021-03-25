/* Loop while
**************/
delimiter $$

create procedure loopwhile(out soma int)
begin
	declare x int default 0; /* Inicioando var com valor padrão 0 */
	while(x<10)do
		set x = x+1;
	end while;

	set soma=x;
end $$

delimiter ;

call loopwhile(@ret);
select @ret;

/* Loop loop
**************/
delimiter $$

create procedure looploop(out soma int)
begin
	declare x int default 0; /* Inicioando var com valor padrão 0 */
	meuloop:loop
		if(x>10)then
			leave meuloop;
		end if;
		set x=x+1;
	end loop;

	set soma=x;
end $$

delimiter ;

call looploop(@ret);
select @ret;