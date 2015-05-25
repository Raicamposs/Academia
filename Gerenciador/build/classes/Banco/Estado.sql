 create table estado ( 
est_id integer not null  auto_increment, 
est_nome varchar(20) not null unique , 
est_uf varchar(2),
primary key (est_id) 
); 
