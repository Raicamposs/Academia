
create table funcionario (
  fun_id integer not null auto_increment,
  fun_pes_id integer not null
  references pessoa(pes_id),
  fun_funcao_id integer unsigned not null
  references funcao(fun_id),
  fun_usurio_id integer unsigned not null
  references usurio(usu_id),
  fun_tur_id integer unsigned not null
  references turno(tur_id),
  fun_cnt varchar(15) not null unique,
  fun_salario float(7,2) not null,
  primary key(fun_id),
  index funcionario_fkindex1(fun_id)

);


