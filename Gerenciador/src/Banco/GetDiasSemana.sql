
CREATE PROCEDURE `getDiasSemana` (in id integer)
BEGIN
select dia_Nome from dias_semana where dia_id = id ;
END


/*call academia.getDiasSemana('3');/*