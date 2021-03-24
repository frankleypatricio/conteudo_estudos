/* Criando uma procedure, tipo uma função
******************************************/
delimiter $$ /* Alterando o delimitador da codificação pra não gerar problemas com o ' ; ' (não precisa ser necessariamente ' $$ ') */

create procedure basico()
begin
	declare x int; /* Cria uma variável */
	set x=10; /* Passando um valor pra var */
	select x; /* Retorna o valor da var */
end $$

delimiter ; /* Voltando o delimitador pro padrão */

/* Chamando a procedure
************************/
call basico();

delimiter $$

create procedure soma(in valor1 int, in valor2 int) /* in - valores de entrada */
begin
	declare resultado int;
	set resultado=valor1+valor2;
	select valor1,valor2,resultado;
end $$

delimiter ;

call soma(2,5);