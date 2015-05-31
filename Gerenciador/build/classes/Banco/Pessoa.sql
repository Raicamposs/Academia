create table pessoa (
pes_id Integer Primary Key Not Null Unique Auto_Increment,
pes_nome Varchar (45) Not Null,
pes_rg Varchar (10)  Not Null ,
pes_cpf Varchar (11)  Not Null , 
pes_data_nascimento date Not Null, 
pes_email Varchar (30)  Not Null , 
pes_sexo char(1) Not Null ,
  pes_end_id integer unsigned not null,
 pes_ec_id integer unsigned not null,
  primary key(pes_cod, pes_rg, pes_cpf),
  index pessoa_fkindex1(pes_cpf),
  index pessoa_fkindex2(pes_nome),
  foreign key( pes_end_id) references endereco(end_id),
  foreign key(pes_ec_id) references estado_civil(ec_id)
)
