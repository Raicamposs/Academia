
CREATE PROCEDURE `getCidade` (in id integer)
BEGIN
select cid_Nome from cidade where cid_id = id ;
END



/*call academia.getCidade('2');/*
