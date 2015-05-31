
create table turma (
  tur_id integer unsigned not null,
  tur_alu_id integer unsigned not null,
  tur_aul_id integer unsigned not null,
  tur_fun_id integer unsigned not null,
  tur_dia_id integer unsigned not null,
  tur_horario integer not null,
  primary key(tur_id),
  index turma_fkindex1(tur_aul_id),
  index turma_fkindex2(tur_alu_id),
  index turma_fkindex3(tur_dia_id),
  index turma_fkindex4(tur_fun_id),
  foreign key(tur_aul_id)
    references aula(aul_id),
  foreign key(tur_alu_id)
    references aluno(alu_id),
  foreign key(tur_dia_id)
    references dias_semana(dia_id),
  foreign key(tur_fun_id)
    references funcionario(fun_id)
);
