
create table aluno (
  alu_id integer unsigned not null auto_increment,
  alu_em_id integer unsigned not null,
  alu_pes_id integer unsigned not null,
  alu_data_matricula date not null,
  alu_dia_venc_mensal int(2) not null,
  alu_observacoes varchar(255) null,
  alu_validade_exame date null,
  alu_validade_avaliacao date null,
  primary key(alu_id),
  index aluno_fkindex1( alu_pes_id),
  index aluno_fkindex2( alu_em_id),
  foreign key( alu_pes_id)
    references pessoa(pes_id),
  foreign key( alu_em_id)
    references estado_matricula(em_id)
);

