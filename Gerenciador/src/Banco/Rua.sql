

create table rua (
  rua_cep int(10)  not null,
  rua_nome varchar(45) not null ,
  rua_id_bairro integer unsigned not null references `bairro`(bai_id),
  primary key(rua_cep)
);


