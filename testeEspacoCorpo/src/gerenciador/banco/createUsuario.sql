CREATE DEFINER=`root`@`localhost` PROCEDURE `createUsuario`(in login varchar(30),in senha varchar(30),in nivel int (1) )
BEGIN
insert into `usuario` (usu_senha, usu_login, usu_nivel_acesso)
values (senha,login,nivel);

END
