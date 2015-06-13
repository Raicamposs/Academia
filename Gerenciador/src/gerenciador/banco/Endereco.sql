
create table endereco (
  end_id integer unsigned not null auto_increment,
  end_rua_cep integer unsigned not null references rua(rua_cep),
  end_complemento varchar(100) null,
  end_num varchar(8) null,
  primary key(end_id),
  index endereco_fkindex(end_rua_cep)

);




