create table funcionario (
fun_Id Integer Primary Key Not Null Unique Auto_Increment, 
fun_salario float (7,2) Not Null, 
fun_cnt Varchar (15)  Not Null Unique,  
fun_pes_id integer  not null References `pessoa`(pessoa), 
fun_funcao_id integer not null References `funcao`(fun_id)

); 
