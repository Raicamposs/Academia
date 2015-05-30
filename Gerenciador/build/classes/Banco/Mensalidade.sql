create table mensalidade(
men_id integer primary key not null  auto_increment,
men_aluno_alu_cod date not null  ,
men_valor float (3,2) not null,
men_date date not null,
men_estado_mensalidade references `estado_mensalidade`(eme_id),
men_aluno_id  references `aluno`(alu_id)

);
