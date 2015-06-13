create table mensalidade(
men_id integer primary key not null  auto_increment,
men_valor float (3,2) not null,
men_data date not null,
men_eme_id integer not null references `estado_mensalidade`(eme_id),
men_alu_id INTEGER UNSIGNED NOT NULL  references `aluno`(alu_id),
  index mensalidade_fkindex1(men_alu_id),
  index mensalidade_fkindex2(men_eme_id),
  index mensalidade_fkindex3 (men_data)
);

