create table responsavel_aluno(
res_id integer primary key not null unique auto_increment,
res_alu_id integer not null References `aluno`(alu_id),
res_pes_id integer not null References `pessoa` (pes_id)

);
