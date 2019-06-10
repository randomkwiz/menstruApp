SELECT *
FROM USUARIO

delete 
from USUARIO
where nick = 'randomkwiz'

SELECT NICK FROM USUARIO 
WHERE NICK = 'randomkwiz' 

insert into USUARIO (NICK, PASS)
values('randomkwiz', PWDENCRYPT('123456789'))

select  *
from EMBARAZO
where ID_USUARIO = 'randomkwiz' AND FECHAFIN_REAL IS NULL
ORDER BY FECHAINICIO desc

insert into CICLOMENSTRUAL(ID_USUARIO, FECHAINICIO)
values('randomkwiz', CURRENT_TIMESTAMP)

insert into EMBARAZO(ID_USUARIO, FECHAINICIO)
values('randomkwiz', CURRENT_TIMESTAMP)

insert into CICLOMENSTRUAL(ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
values('randomkwiz', '20190504','20190508')

delete
from CICLOMENSTRUAL
where ID = '9202B5FC-4C22-46BC-B848-90D5D02B5FCC'

select * from
CICLOMENSTRUAL
where ID_USUARIO = 'randomkwiz'

select * from
EMBARAZO
where ID_USUARIO = 'randomkwiz'

insert into CICLOMENSTRUAL(ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
values('randomkwiz', '20090406','20090408')

insert into CICLOMENSTRUAL(ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
values('randomkwiz', '20090403','20090406')

insert into CICLOMENSTRUAL(ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
values('randomkwiz', '20090407','20090411')


insert into CICLOMENSTRUAL(ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
values('randomkwiz', '20090403','20090413')

insert into CICLOMENSTRUAL(ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
values('randomkwiz', '20090303','20090306')

insert into CICLOMENSTRUAL(ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
values('randomkwiz', '20190503','20190506')

select *
from CICLOMENSTRUAL
where ID_USUARIO = 'randomkwiz'

insert into CICLOMENSTRUAL(ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
values('randomkwiz', '20190707',null)

insert into EMBARAZO (ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
values ('randomkwiz', '20290608', null)

select * from EMBARAZO



delete 
from EMBARAZO
where ID = '7FDEA065-8A3E-4CF6-809C-5C409D28AC07'


select ID, 'CICLOMENSTRUAL' as TABLAORIGEN ,ID_USUARIO, FECHAINICIO, FECHAFIN_REAL
from CICLOMENSTRUAL as M
where 
(
M.ID_USUARIO = 'randomkwiz'
and
M.FECHAFIN_REAL is null
)
union
select ID, 'EMBARAZO' as TABLAORIGEN ,ID_USUARIO, FECHAINICIO, FECHAFIN_REAL
from EMBARAZO as E
where 
(
E.ID_USUARIO = 'randomkwiz'
and
E.FECHAFIN_REAL is null
)




select *
from CICLOMENSTRUAL
WHERE ID_USUARIO = 'Ivan'

select * from USUARIO

select * from EMBARAZO

delete 
from 
USUARIO
where nick = 'randomkwiz'

insert into CICLOMENSTRUAL


insert into CICLOMENSTRUAL (ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
values (?,?,?)