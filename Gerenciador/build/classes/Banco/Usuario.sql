
create table usuario (
  usu_id integer unsigned not null auto_increment,
  usu_login varchar(30) not null unique,
  usu_senha varchar(20) not null ,
  usu_fun_id integer not null unique references `funcionario` (fun_id),
  primary key(usu_id)
);

