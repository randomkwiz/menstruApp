use MenstruApp



select X.ID_USUARIO, X.ESTADO, X.cantidad, X.IDEstado
from 
(
select e.ESTADO, count(*) as cantidad, rp.ID_USUARIO, e.ID as IDEstado
			from REVISIONPERSONAL as rp
			inner join REVISIONPERSONAL_ESTADOANIMICO as re
			on rp.ID = re.ID_REVISIONPERSONAL
			inner join ESTADOANIMICO as e
			on re.ID_ESTADOANIMICO = e.ID
			where rp.ID_USUARIO = 'randomkwiz'
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
			where rp.ID_USUARIO = 'randomkwiz'
			group by e.ESTADO
		) X
	) Y
on Y.maximo = X.cantidad
where X.ID_USUARIO = 'randomkwiz'





