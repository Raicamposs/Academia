create table endereco (
end_id integer not null  auto_increment primary Key,
end_rua varchar(45),
end_num varchar(8),
end_cep varchar(8),
end_cid_id integer  not null References `cidade`(cid_id), 
end_bai_id integer not null References `bairro`(bai_id), 
end_est_uf varchar(2)References `estado`(est_id) 
); 

