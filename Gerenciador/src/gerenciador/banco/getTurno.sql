CREATE PROCEDURE `getTurno` ( in id integer)
BEGIN
select tur_Nome from turno where tur_id = id;
END

