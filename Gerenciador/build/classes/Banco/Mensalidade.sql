create table mensalidade(
men_id integer primary key not null  auto_increment,
men_alu_id date not null  ,
men_valor float (3,2) not null,
men_data date not null,
men_estado_mensalidade references `estado_mensalidade`(eme_id),
men_alu_id  references `aluno`(alu_id),
  index mensalidade_fkindex1(men_alu_id),
  index mensalidade_fkindex2(men_estado_mensalidade ),
  index mensalidade_fkindex3 (men_data)
);
