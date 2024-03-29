
insert into REVISIONPERSONAL (ID_USUARIO, FECHA)
values('aabbayrl',CURRENT_TIMESTAMP)


select * 
from USUARIO

select id
from REVISIONPERSONAL
where FECHA = cast (CURRENT_TIMESTAMP as date)	--importante ponerle el cast as date
and ID_USUARIO = 'aabbayrl'

/*nota: hacer trigger para que no se pueda insertar otra revision personal el mismo dia*/


SELECT * 
FROM REVISIONPERSONAL
WHERE ID = '97212344-513A-4791-9B51-DD969F349585'


select * 
from REVISIONPERSONAL_ESTADOANIMICO as re
inner join ESTADOANIMICO as e
on re.ID_ESTADOANIMICO = e.ID
where ID_REVISIONPERSONAL = ?


select * 
from REVISIONPERSONAL_SINTOMA as rs
inner join SINTOMA as s
on rs.ID_SINTOMA = s.ID
where ID_REVISIONPERSONAL = ?


select * 
from REVISIONPERSONAL_SEXO as rsx
inner join SEXO as sx
on rsx.ID_SEXO = sx.ID
where ID_REVISIONPERSONAL = ?

select * 
from REVISIONPERSONAL_FLUJOVAGINAL as rf
inner join FLUJOVAGINAL as f
on rf.ID_FLUJOVAGINAL = f.ID
where ID_REVISIONPERSONAL = ?


select * from ESTADOANIMICO

insert into REVISIONPERSONAL_ESTADOANIMICO (ID_REVISIONPERSONAL, ID_ESTADOANIMICO)
values ('97212344-513A-4791-9B51-DD969F349585', '5E6E292F-A546-4F42-9765-2C723A7ABD87' ),
('97212344-513A-4791-9B51-DD969F349585', '69E88F05-2995-43F6-AD2D-2CC13EAA430A' ),
('97212344-513A-4791-9B51-DD969F349585', '207DC83A-FA5E-4998-8C3C-39C659163818' ),
('97212344-513A-4791-9B51-DD969F349585', '0C11C266-F0F3-4486-A978-3D90A14DF62B' )




SELECT * FROM FLUJOVAGINAL
insert into REVISIONPERSONAL_FLUJOVAGINAL(ID_REVISIONPERSONAL, ID_FLUJOVAGINAL)
values ('97212344-513A-4791-9B51-DD969F349585', 'E9FF7363-C036-4B7F-8C46-217502C03EF5' ),
('97212344-513A-4791-9B51-DD969F349585', '82D9A713-663A-4179-9101-685CB9A163CC' ),
('97212344-513A-4791-9B51-DD969F349585', '21851F82-C609-4EFC-A1DC-423241B01213' )

SELECT * FROM SEXO
insert into REVISIONPERSONAL_SEXO(ID_REVISIONPERSONAL, ID_SEXO)
values ('97212344-513A-4791-9B51-DD969F349585', '23C70FCF-1A76-4F13-89A4-22C98D360090' ),
('97212344-513A-4791-9B51-DD969F349585', '3A024193-45E2-4742-BA8C-6CC5E037B79E' )

SELECT * FROM SINTOMA
insert into REVISIONPERSONAL_SINTOMA(ID_REVISIONPERSONAL, ID_SINTOMA)
values ('97212344-513A-4791-9B51-DD969F349585', '650FBE78-0C5C-421E-A2CA-1EFBAB5A42B5' ),
('97212344-513A-4791-9B51-DD969F349585', '7E035597-9A90-4356-8E8F-B96B21111E5C' )


select *
from ESTADOANIMICO
where ESTADO = ?
union
select * 
from SINTOMA
where SINTOMA = ?
union
select *
from FLUJOVAGINAL
where TIPO = ?
union
select * 
from SEXO
where OBSERVACION = ?

select ID_REVISIONPERSONAL, ESTADO
from REVISIONPERSONAL_ESTADOANIMICO re
inner join ESTADOANIMICO e
on re.ID_ESTADOANIMICO = e.ID
where ID_REVISIONPERSONAL = '97212344-513A-4791-9B51-DD969F349585' 


select * from REVISIONPERSONAL

insert into REVISIONPERSONAL (ID_USUARIO, FECHA)
values(?, cast (CURRENT_TIMESTAMP as date))

select * from USUARIO where nick = 'randomkwiz'

select * from REVISIONPERSONAL

insert into REVISIONPERSONAL (ID_USUARIO, FECHA)
values('lola', cast (CURRENT_TIMESTAMP as date))

delete 
from USUARIO
where nick = 'keru'