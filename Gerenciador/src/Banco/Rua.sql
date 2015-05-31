
create table rua (
  rua_cep integer unsigned not null,
  rua_nome varchar unsigned not null unique,
  rua_id_bairro integer unsigned not null references `bairro`(bai_id),
  primary key(rua_cep)
);

