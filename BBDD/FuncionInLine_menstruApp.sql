use MenstruApp

GO
ALTER
--CREATE 
FUNCTION hallarEstadoAnimicoMasFrecuente (@usuario nvarchar(25))
RETURNS TABLE  AS
RETURN 
(
select X.ID_USUARIO, X.ESTADO, X.cantidad, X.IDEstado
from 
(
select e.ESTADO, count(*) as cantidad, rp.ID_USUARIO, e.ID as IDEstado
			from REVISIONPERSONAL as rp
			inner join REVISIONPERSONAL_ESTADOANIMICO as re
			on rp.ID = re.ID_REVISIONPERSONAL
			inner join ESTADOANIMICO as e
			on re.ID_ESTADOANIMICO = e.ID
			where rp.ID_USUARIO = @usuario
			group by e.ESTADO, rp.ID_USUARIO, e.ID

) X

inner join 
	(
	select MAX(X.cantidad) as maximo
	from 
		(
			select e.ESTADO, count(*) as cantidad
			from REVISIONPERSONAL as rp
			inner join REVISIONPERSONAL_ESTADOANIMICO as re
			on rp.ID = re.ID_REVISIONPERSONAL
			inner join ESTADOANIMICO as e
			on re.ID_ESTADOANIMICO = e.ID
			where rp.ID_USUARIO = @usuario
			group by e.ESTADO
		) X
	) Y
on Y.maximo = X.cantidad
where X.ID_USUARIO = @usuario


)
GO

--SU USO:
SELECT * FROM hallarEstadoAnimicoMasFrecuente('aabendroth93')

------------------------

GO
ALTER
--CREATE 
FUNCTION hallarSintomaMasFrecuente (@usuario nvarchar(25))
RETURNS TABLE  AS
RETURN 
(
select X.ID_USUARIO, X.SINTOMA, X.cantidad, X.IDEstado
from 
(
select e.SINTOMA, count(*) as cantidad, rp.ID_USUARIO, e.ID as IDEstado
			from REVISIONPERSONAL as rp
			inner join REVISIONPERSONAL_SINTOMA as re
			on rp.ID = re.ID_REVISIONPERSONAL
			inner join SINTOMA as e
			on re.ID_SINTOMA = e.ID
			where rp.ID_USUARIO = @usuario
			group by e.SINTOMA, rp.ID_USUARIO, e.ID

) X

inner join 
	(
	select MAX(X.cantidad) as maximo
	from 
		(
			select e.SINTOMA, count(*) as cantidad
			from REVISIONPERSONAL as rp
			inner join REVISIONPERSONAL_SINTOMA as re
			on rp.ID = re.ID_REVISIONPERSONAL
			inner join SINTOMA as e
			on re.ID_SINTOMA = e.ID
			where rp.ID_USUARIO = @usuario
			group by e.SINTOMA
		) X
	) Y
on Y.maximo = X.cantidad
where X.ID_USUARIO = @usuario
)
GO

--SU USO:
SELECT * FROM hallarSintomaMasFrecuente('randomkwiz')


------------------------

GO
ALTER
--CREATE 
FUNCTION hallarSexoMasFrecuente (@usuario nvarchar(25))
RETURNS TABLE  AS
RETURN 
(
select X.ID_USUARIO, X.OBSERVACION, X.cantidad, X.IDEstado
from 
(
select e.OBSERVACION, count(*) as cantidad, rp.ID_USUARIO, e.ID as IDEstado
			from REVISIONPERSONAL as rp
			inner join REVISIONPERSONAL_SEXO as re
			on rp.ID = re.ID_REVISIONPERSONAL
			inner join SEXO as e
			on re.ID_SEXO = e.ID
			where rp.ID_USUARIO = @usuario
			group by e.OBSERVACION, rp.ID_USUARIO, e.ID

) X

inner join 
	(
	select MAX(X.cantidad) as maximo
	from 
		(
			select e.OBSERVACION, count(*) as cantidad
			from REVISIONPERSONAL as rp
			inner join REVISIONPERSONAL_SEXO as re
			on rp.ID = re.ID_REVISIONPERSONAL
			inner join SEXO as e
			on re.ID_SEXO = e.ID
			where rp.ID_USUARIO = @usuario
			group by e.OBSERVACION
		) X
	) Y
on Y.maximo = X.cantidad
where X.ID_USUARIO = @usuario
)
GO

--SU USO:
SELECT * FROM hallarSexoMasFrecuente('randomkwiz')




------------------------

GO
ALTER
--CREATE 
FUNCTION hallarFlujoVaginalMasFrecuente (@usuario nvarchar(25))
RETURNS TABLE  AS
RETURN 
(
select X.ID_USUARIO, X.TIPO, X.cantidad, X.IDEstado
from 
(
select e.TIPO, count(*) as cantidad, rp.ID_USUARIO, e.ID as IDEstado
			from REVISIONPERSONAL as rp
			inner join REVISIONPERSONAL_FLUJOVAGINAL as re
			on rp.ID = re.ID_REVISIONPERSONAL
			inner join FLUJOVAGINAL as e
			on re.ID_FLUJOVAGINAL = e.ID
			where rp.ID_USUARIO = @usuario
			group by e.TIPO, rp.ID_USUARIO, e.ID

) X

inner join 
	(
	select MAX(X.cantidad) as maximo
	from 
		(
			select e.TIPO, count(*) as cantidad
			from REVISIONPERSONAL as rp
			inner join REVISIONPERSONAL_FLUJOVAGINAL as re
			on rp.ID = re.ID_REVISIONPERSONAL
			inner join FLUJOVAGINAL as e
			on re.ID_FLUJOVAGINAL = e.ID
			where rp.ID_USUARIO = @usuario
			group by e.TIPO
		) X
	) Y
on Y.maximo = X.cantidad
where X.ID_USUARIO = @usuario
)
GO

--SU USO:
SELECT * FROM hallarFlujoVaginalMasFrecuente('randomkwiz')






select * from USUARIO