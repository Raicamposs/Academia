create table bairro ( 
bai_id integer not null  auto_increment, 
bai_nome varchar(45) not null,
bai_id_cidade integer not null,
foreign key(bai_cid_id) references cidade(cid_id),
primary key (bai_id) 
); 
