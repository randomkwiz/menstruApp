USE MenstruApp
GO

/*TESTS TRIGGERS */

/*PRUEBA TESTS FECHA DE REVISION MEDICA*/

--UNA REVISION MEDICA SIEMPRE DEBE DE ESTAR DENTRO DEL PERIODO DE UN EMBARAZO

--PRIMERO BORRAMOS TODOS LOS CICLOS DEL USUARIO DE PRUEBA
DELETE FROM EMBARAZO WHERE ID_USUARIO = 'USUARIOPRUEBA'
GO
DELETE FROM CICLOMENSTRUAL WHERE ID_USUARIO = 'USUARIOPRUEBA'

--COMPROBAMOS QUE ESTAN BORRADOS
SELECT * FROM CICLOMENSTRUAL WHERE ID_USUARIO = 'USUARIOPRUEBA'

GO
SELECT * FROM EMBARAZO WHERE ID_USUARIO = 'USUARIOPRUEBA'

--CREAMOS UN EMBARAZO CON FECHA DE INICIO Y DE FIN 
INSERT INTO EMBARAZO(ID_USUARIO, FECHAINICIO, FECHAFIN_REAL)
VALUES('USUARIOPRUEBA', '20180101','20180901')	--EL CICLO DURA DEL 01/01/2018 AL 01/09/2018

--PRUEBAS QUE DEBEN FALLAR: 
	--INSERTAR REVISION ANTES DEL EMBARAZO SIN FECHA DE SIGUIENTE CITA
		INSERT INTO REVISIONMEDICA(ID_EMBARAZO, PESO, CINTURA, CADERA,FECHA_CITA_ACTUAL,ESTADOFETO, OBSERVACIONES, FECHA_SIGUIENTE_CITA)
		VALUES('36C55466-2A7F-46FC-8D3A-29F259B80BD3',0,0,0, '20170512',' ', ' ',NULL)
			--SALTA TRIGGER CON MENSAJE: 'La fecha debe estar dentro del periodo del embarazo'

	--INSERTAR REVISION ANTES DEL EMBARAZO CON FECHA DE SIGUIENTE CITA
		INSERT INTO REVISIONMEDICA(ID_EMBARAZO, PESO, CINTURA, CADERA,FECHA_CITA_ACTUAL,ESTADOFETO, OBSERVACIONES, FECHA_SIGUIENTE_CITA)
		VALUES('36C55466-2A7F-46FC-8D3A-29F259B80BD3',0,0,0, '20170512',' ', ' ','20190512')
			--SALTA TRIGGER CON MENSAJE: 'La fecha debe estar dentro del periodo del embarazo'

	--INSERTAR REVISION DESPUES DEL EMBARAZO SIN FECHA DE SIGUIENTE CITA
		INSERT INTO REVISIONMEDICA(ID_EMBARAZO, PESO, CINTURA, CADERA,FECHA_CITA_ACTUAL,ESTADOFETO, OBSERVACIONES, FECHA_SIGUIENTE_CITA)
		VALUES('36C55466-2A7F-46FC-8D3A-29F259B80BD3',0,0,0, '20190512',' ', ' ',NULL)
			--SALTA TRIGGER CON MENSAJE: 'La fecha debe estar dentro del periodo del embarazo'

	--INSERTAR REVISION DESPUES DEL EMBARAZO CON FECHA DE SIGUIENTE CITA
		INSERT INTO REVISIONMEDICA(ID_EMBARAZO, PESO, CINTURA, CADERA,FECHA_CITA_ACTUAL,ESTADOFETO, OBSERVACIONES, FECHA_SIGUIENTE_CITA)
		VALUES('36C55466-2A7F-46FC-8D3A-29F259B80BD3',0,0,0, '20190512',' ', ' ','20190515')
			--SALTA TRIGGER CON MENSAJE: 'La fecha debe estar dentro del periodo del embarazo'


	--INSERTAR REVISION CON FECHA ACTUAL CORRECTA PERO FECHA SIGUIENTE CITA INCORRECTA 
		INSERT INTO REVISIONMEDICA(ID_EMBARAZO, PESO, CINTURA, CADERA,FECHA_CITA_ACTUAL,ESTADOFETO, OBSERVACIONES, FECHA_SIGUIENTE_CITA)
		VALUES('36C55466-2A7F-46FC-8D3A-29F259B80BD3',0,0,0, '20180512',' ', ' ','20181215')
		--SALTA TRIGGER CON MENSAJE: 'La fecha debe estar dentro del periodo del embarazo'
	
	--INSERTAR REVISION CON FECHA DE SIGUIENTE CITA ANTERIOR A LA CITA ACTUAL PERO ESTANDO AMBAS DENTRO DEL PERIODO DE SU EMBARAZO
		INSERT INTO REVISIONMEDICA(ID_EMBARAZO, PESO, CINTURA, CADERA,FECHA_CITA_ACTUAL,ESTADOFETO, OBSERVACIONES, FECHA_SIGUIENTE_CITA)
		VALUES('36C55466-2A7F-46FC-8D3A-29F259B80BD3',0,0,0, '20180512',' ', ' ','20180215')
		--SALTA TRIGGER CON MENSAJE: 'La fecha de la siguiente cita no puede ser menor o igual a la de la cita actual'
				


--PRUEBAS QUE DEBEN IR BIEN: CREAR REVISION DENTRO DEL PERIODO DE SU EMBARAZO
		INSERT INTO REVISIONMEDICA(ID_EMBARAZO, PESO, CINTURA, CADERA,FECHA_CITA_ACTUAL,ESTADOFETO, OBSERVACIONES, FECHA_SIGUIENTE_CITA)
		VALUES('36C55466-2A7F-46FC-8D3A-29F259B80BD3',0,0,0, '20180512',' ', ' ','20180515')
		



		/*
		delete from REVISIONMEDICA where ID_EMBARAZO = '36C55466-2A7F-46FC-8D3A-29F259B80BD3'

		select * from REVISIONMEDICA
		*/