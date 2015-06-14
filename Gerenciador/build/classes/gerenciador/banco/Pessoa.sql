create table pessoa (
pes_id Integer Not Null Unique Auto_Increment,
pes_nome Varchar (45) Not Null,
pes_rg Varchar (10)  Not Null Unique ,
pes_cpf Varchar (11)  Not Null Unique,
pes_data_nascimento date Not Null,
pes_email Varchar (30)  Not Null Unique ,
pes_sexo char(1) Not Null ,
pes_end_id integer unsigned not null references endereco(end_id),
pes_ec_id integer unsigned not null references estado_civil(ec_id),
primary key(pes_id, pes_rg, pes_cpf),
index pessoa_fkindex1(pes_cpf),
index pessoa_fkindex2(pes_nome)

)