create table estado (
  est_uf varchar(2) not null ,
  est_nome varchar(20) not null unique,
  primary key(est_uf)
);

