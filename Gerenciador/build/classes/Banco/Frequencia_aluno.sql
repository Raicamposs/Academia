create table frequencia_aluno(
freq_id integer primary key not null  auto_increment,
freq_dia date not null ,
freq_alu_id integer not null References `aluno`(alu_id,
index frequencia_aluno_fkindex1(freq_alu_id )
);




