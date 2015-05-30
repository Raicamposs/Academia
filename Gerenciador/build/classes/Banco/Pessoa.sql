create table pessoa (
pes_Id Integer Primary Key Not Null Unique Auto_Increment, 
pes_Nome Varchar (45) Not Null, 
pes_Rg Varchar (10)  Not Null Unique, 
pes_cpf Varchar (11)  Not Null Unique, 
pes_data_nascimento date Not Null, 
pes_email Varchar (30)  Not Null , 
pes_sexo char(1) Not Null , 
pes_end_id integer  not null References `endereco`(end_id), 
pes_est_civil_id integer not null References `estado_civil`(ec_id)

); 
