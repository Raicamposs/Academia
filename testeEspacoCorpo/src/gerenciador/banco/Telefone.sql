create table telefone (
tel_id Integer Primary Key Not Null Unique Auto_Increment, 
tel_num integer (11) Not Null, 
tel_pes_id integer  not null References `pessoa`(pes_id),
 index telefone_fkindex1(tel_pes_id)

); 
