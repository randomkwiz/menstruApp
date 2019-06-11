delete from
CICLOMENSTRUAL
where ID_USUARIO = 'randomkwiz'
and ID = '10B4EAC9-23AA-4301-A522-2CB47E97C817'

GO

delete from
EMBARAZO
where ID_USUARIO = 'randomkwiz'
and ID = '10B4EAC9-23AA-4301-A522-2CB47E97C817'


select * from EMBARAZO 


select *
from
REVISIONPERSONAL
where YEAR(FECHA) = ?
and MONTH(FECHA) = ?
and DAY(FECHA) = ? 
and ID_USUARIO = ?


SELECT R.ID_USUARIO, RE.ID_REVISIONPERSONAL, RE.ID_ESTADOANIMICO, E.ESTADO,R.FECHA, R.ID
FROM ESTADOANIMICO AS E
INNER JOIN REVISIONPERSONAL_ESTADOANIMICO AS RE
ON RE.ID_ESTADOANIMICO = E.ID
INNER JOIN REVISIONPERSONAL AS R
ON R.ID = RE.ID_REVISIONPERSONAL
WHERE
	R.ID_USUARIO = ?
	and
	e.ESTADO = ?

union

SELECT R.ID_USUARIO, RE.ID_REVISIONPERSONAL, RE.ID_FLUJOVAGINAL, E.TIPO,R.FECHA, R.ID
FROM FLUJOVAGINAL AS E
INNER JOIN REVISIONPERSONAL_FLUJOVAGINAL AS RE
ON RE.ID_FLUJOVAGINAL = E.ID
INNER JOIN REVISIONPERSONAL AS R
ON R.ID = RE.ID_REVISIONPERSONAL
WHERE
	R.ID_USUARIO = ?
	and
	e.TIPO = ?

	
union

SELECT R.ID_USUARIO, RE.ID_REVISIONPERSONAL, RE.ID_SEXO, E.OBSERVACION,R.FECHA, R.ID
FROM SEXO AS E
INNER JOIN REVISIONPERSONAL_SEXO AS RE
ON RE.ID_SEXO = E.ID
INNER JOIN REVISIONPERSONAL AS R
ON R.ID = RE.ID_REVISIONPERSONAL
WHERE
	R.ID_USUARIO = ?
	and
	e.OBSERVACION = ?

	
union

SELECT R.ID_USUARIO, RE.ID_REVISIONPERSONAL, RE.ID_REVISIONPERSONAL, E.SINTOMA, R.FECHA, R.ID
FROM SINTOMA AS E
INNER JOIN REVISIONPERSONAL_FLUJOVAGINAL AS RE
ON RE.ID_FLUJOVAGINAL = E.ID
INNER JOIN REVISIONPERSONAL AS R
ON R.ID = RE.ID_REVISIONPERSONAL
WHERE
	R.ID_USUARIO = ?
	and
	e.SINTOMA = ?


