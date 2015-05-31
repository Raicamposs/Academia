create table endereco (
  end_id integer unsigned not null auto_increment,
  end_rua_cep integer unsigned not null,
  end_est_uf varchar(2) not null,
  end_cid_id integer unsigned not null,
  end_num varchar(8) null,
  primary key(end_id),
  index endereco_fkindex1(end_cid_id),
  index endereco_fkindex3(end_est_uf),
  index endereco_fkindex4(end_rua_cep),
  foreign key(end_cid_id) references cidade(cid_id),
  foreign key(end_est_uf) references estado(est_uf),
  foreign key(end_rua_cep) references rua(rua_cep)
);



