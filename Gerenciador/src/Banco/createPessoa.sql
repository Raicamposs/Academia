CREATE DEFINER=`root`@`localhost` PROCEDURE `createPessoa`(
in nome Varchar (45),
in rg Varchar (10),
in cpf Varchar (11),
in data_nascimento date,
in email Varchar (30),
in sexo char(1),
in end_id integer,
in ec_id integer
)
BEGIN
if sexo like ('f' or 'm') then
insert into `pessoa` (
pes_nome,pes_rg ,pes_cpf ,pes_data_nascimento,
pes_email ,pes_sexo ,pes_end_id ,pes_ec_id )
values (nome,rg ,cpf ,data_nascimento,
email ,sexo ,end_id ,ec_id );

end if;

END
