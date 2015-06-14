

create table rua (
  rua_cep integer not null,
  rua_nome varchar(100) not null ,
  rua_id_bairro integer unsigned not null references `bairro`(bai_id),
  primary key(rua_cep)
);

