USE MenstruApp
GO

SELECT * FROM USUARIO

--INSERTAR USUARIO
insert into USUARIO (NICK, PASS) 
values('buhoos',PWDENCRYPT('12345678'))

insert into USUARIO (NICK, PASS) 
values('randomkwiz',PWDENCRYPT('123456789'))

insert into USUARIO (NICK, PASS) 
values('PEPITA',PWDENCRYPT('12345678'))

INSERT INTO EMBARAZO (ID_USUARIO,FECHAINICIO)
VALUES('PEPITA', '20190325')


insert into USUARIO (NICK, PASS) 
values('prueba',PWDENCRYPT('1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890'))
--cambiar

insert into USUARIO (NICK, PASS) 
values('prueba2',PWDENCRYPT('12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901'))


insert into USUARIO (NICK, PASS) 
values('prueba3',PWDENCRYPT('12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345'))


--VERIFICAR LOGIN (SI DEVUELVE ALGUNA FILA, ES QUE ESTA OK)
select * from USUARIO where NICK ='buhoos' and PWDCOMPARE('12345678',PASS)= 1

select * from USUARIO where NICK ='randomkwiz' and PWDCOMPARE('123456789',PASS)= 1

select nick,nombre,pass,peso,fechanacimiento from USUARIO where NICK ='randomkwiz' and PWDCOMPARE('123456789',PASS)= 1

update USUARIO
set peso = 500
where nick = 'randomkwiz'
