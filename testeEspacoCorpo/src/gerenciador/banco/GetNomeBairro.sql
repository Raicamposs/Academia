USE `academia`;
DROP procedure IF EXISTS `getNomeBairro`;

DELIMITER $$
USE `academia`$$
CREATE PROCEDURE `getNomeBairro` (in id integer)
BEGIN
select bai_Nome from bairro where bai_id = id ;

END
$$

DELIMITER ;
