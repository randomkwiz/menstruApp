/*Datos */
SELECT *
FROM USUARIO
WHERE NICK = 'USUARIOPRUEBA'

/*Usuarios de prueba*/
INSERT INTO USUARIO (NICK, NOMBRE, PASS, PESO, FECHANACIMIENTO)
VALUES('usuarioPrueba', 'Soy un usuario de prueba', PWDENCRYPT('123456789'), 65, '20000512')

select *
from CICLOMENSTRUAL
where ID_USUARIO = 'usuarioPrueba'
order by FECHAINICIO asc

select ID, ID_USUARIO, FECHAINICIO, FECHAFIN_REAL
from EMBARAZO
where ID_USUARIO = 'usuarioPrueba'
order by FECHAINICIO asc

delete 
from CICLOMENSTRUAL
where ID_USUARIO = 'usuarioPrueba'
and FECHAINICIO < '20190101'

/*Insercion de ciclos antiguos para ese usuario*/
INSERT INTO CICLOMENSTRUAL(ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
VALUES('usuarioPrueba','20100101','20100105'),
('usuarioPrueba','20100203','20100207'),
('usuarioPrueba','20100301','20100305'),
('usuarioPrueba','20100403','20100407'),
('usuarioPrueba','20100503','20100507'),
('usuarioPrueba','20100601','20100605'),
('usuarioPrueba','20100703','20100707'),
('usuarioPrueba','20100803','20100807'),
('usuarioPrueba','20100901','20100905'),
('usuarioPrueba','20101003','20101007'),
('usuarioPrueba','20101103','20101107'),
('usuarioPrueba','20101201','20101205'),

---

('usuarioPrueba','20110101','20110105'),
('usuarioPrueba','20110203','20110207'),
('usuarioPrueba','20110301','20110305'),
('usuarioPrueba','20110403','20110407'),
('usuarioPrueba','20110503','20110507'),
('usuarioPrueba','20110601','20110605'),
('usuarioPrueba','20110703','20110707'),
('usuarioPrueba','20110803','20110807'),
('usuarioPrueba','20110901','20110905'),
('usuarioPrueba','20111003','20111007'),
('usuarioPrueba','20111103','20111107'),
('usuarioPrueba','20111201','20111205'),
---

('usuarioPrueba','20120101','20120105'),
('usuarioPrueba','20120203','20120207'),
('usuarioPrueba','20120301','20120305'),
('usuarioPrueba','20120403','20120407'),
('usuarioPrueba','20120503','20120507'),
('usuarioPrueba','20120601','20120605'),
('usuarioPrueba','20120703','20120707'),
('usuarioPrueba','20120803','20120807'),
('usuarioPrueba','20120901','20120905'),
('usuarioPrueba','20121003','20121007'),
('usuarioPrueba','20121103','20121107'),
('usuarioPrueba','20121201','20121205'),

---

('usuarioPrueba','20130101','20130105'),
('usuarioPrueba','20130203','20130207'),
('usuarioPrueba','20130301','20130305'),
('usuarioPrueba','20130403','20130407'),
('usuarioPrueba','20130503','20130507'),
('usuarioPrueba','20130601','20130605'),
('usuarioPrueba','20130703','20130707'),
('usuarioPrueba','20130803','20130807'),
('usuarioPrueba','20130901','20130905'),
('usuarioPrueba','20131003','20131007'),
('usuarioPrueba','20131103','20131107'),
('usuarioPrueba','20131201','20131205'),
--

('usuarioPrueba','20140101','20140105'),
('usuarioPrueba','20140203','20140207'),
('usuarioPrueba','20140301','20140305'),
('usuarioPrueba','20140403','20140407'),
('usuarioPrueba','20140503','20140507'),
('usuarioPrueba','20140601','20140605'),
('usuarioPrueba','20140703','20140707'),
('usuarioPrueba','20140803','20140807'),
('usuarioPrueba','20140901','20140905'),
('usuarioPrueba','20141003','20141007'),
('usuarioPrueba','20141103','20141107'),
('usuarioPrueba','20141201','20141205'),

--

('usuarioPrueba','20150101','20150105'),
('usuarioPrueba','20150203','20150207'),
('usuarioPrueba','20150301','20150305'),
('usuarioPrueba','20150403','20150407'),
('usuarioPrueba','20150503','20150507'),
('usuarioPrueba','20150601','20150605'),
('usuarioPrueba','20150703','20150707'),
('usuarioPrueba','20150803','20150807'),
('usuarioPrueba','20150901','20150905'),
('usuarioPrueba','20151003','20151007'),
('usuarioPrueba','20151103','20151107'),
('usuarioPrueba','20151201','20151205'),

--

('usuarioPrueba','20160101','20160105'),
('usuarioPrueba','20160203','20160207'),
('usuarioPrueba','20160301','20160305'),
('usuarioPrueba','20160403','20160407'),
('usuarioPrueba','20160503','20160507'),
('usuarioPrueba','20160601','20160605'),
('usuarioPrueba','20160703','20160707'),
('usuarioPrueba','20160803','20160807'),
('usuarioPrueba','20160901','20160905'),
('usuarioPrueba','20161003','20161007'),
('usuarioPrueba','20161103','20161107'),
('usuarioPrueba','20161201','20161205'),

--

('usuarioPrueba','20170101','20170105'),
('usuarioPrueba','20170203','20170207'),
('usuarioPrueba','20170301','20170305'),
('usuarioPrueba','20170403','20170407'),
('usuarioPrueba','20170503','20170507'),
('usuarioPrueba','20170601','20170605'),
('usuarioPrueba','20170703','20170707'),
('usuarioPrueba','20170803','20170807'),
('usuarioPrueba','20170901','20170905'),
('usuarioPrueba','20171003','20171007'),
('usuarioPrueba','20171103','20171107'),
('usuarioPrueba','20171201','20171205'),


--
('usuarioPrueba','20180101','20180105'),
('usuarioPrueba','20180203','20180207'),
('usuarioPrueba','20180301','20180305'),
('usuarioPrueba','20180403','20180407'),
('usuarioPrueba','20180503','20180507'),
('usuarioPrueba','20180601','20180605'),
('usuarioPrueba','20180703','20180707'),
('usuarioPrueba','20180803','20180807'),
('usuarioPrueba','20180901','20180905'),
('usuarioPrueba','20181003','20181007'),
('usuarioPrueba','20181103','20181107'),
('usuarioPrueba','20181201','20181205'),

--
INSERT INTO CICLOMENSTRUAL(ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
VALUES
('usuarioPrueba','20190101','20190105'),
('usuarioPrueba','20190203','20190207'),
('usuarioPrueba','20190301','20190305'),
('usuarioPrueba','20190403','20190407'),
('usuarioPrueba','20190503','20190507'),
('usuarioPrueba','20190601','20190605')


/*insertar embarazo actual*/
INSERT INTO EMBARAZO (ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
VALUES('usuarioPrueba', '20190610',null)