
create table funcionario (
  fun_id integer unsigned not null auto_increment,
  fun_pes_id integer unsigned not null,
  fun_funcao_id integer unsigned not null,
  fun_tur_id integer unsigned not null ,
  fun_cnt varchar(15) not null unique,
  fun_salario float(7,2) not null,
  primary key(fun_id),
  index funcionario_fkindex1(fun_id),
  foreign key(fun_tur_id)
  references turno(tur_id),
  foreign key(fun_funcao_id)
  references funcao(fun_id),
  foreign key(fun_pessoa_id)
  references `pessoa`(pes_id)
);


