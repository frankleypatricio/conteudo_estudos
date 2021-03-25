/* Retorna a primeira posição da string passada
************************************************/
select locate('a',nome) as 'Posição', nome as Nome from cliente where id=3;

/* Retorna a string em maiúsculo
*********************************/
select upper(nome) as 'Maiúsculo', nome as Nome from cliente where id=14;

/* Retorna a string em minúsculo
*********************************/
select lower(nome) as 'Minúsculo', nome as Nome from cliente where id=7;

/* Extrai parte de uma string (string, pos inicial, qtd de chars)
******************************************************************/
select substr(nome,2,3) as 'Extraído', nome as Nome from cliente where id=20;

/* Concatena strings
*********************/
select concat('Seu nome é ', nome) as 'Concatenado', nome as Nome from cliente where id=1;

/* Retorna o tamanho de uma string
***********************************/
select char_length(nome) as 'Tamanho', nome as Nome from cliente where id=2;

/* Retorna o valor ASCII do primeiro caracter da string
********************************************************/
select ascii(nome) as 'ASCII', nome as Nome from cliente where id=13;

/* Formata um numeral para o padrão #, ###, ###.##
com a quantidade de casas decimais informada
****************************************************/
select format(valor,1) as 'Formatado', valor as Valor from venda where id=3;