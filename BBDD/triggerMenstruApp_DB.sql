/*TRIGGER PARA CADA VEZ
QUE UNA USUARIA INSERTA EL PESO EN LA TABLA REVISION MEDICA,
SE ACTUALICE EL PESO DE LA TABLA USUARIO
*/
USE MenstruApp
GO
BEGIN TRAN
GO
ALTER
--CREATE
TRIGGER modificarPeso 
ON REVISIONMEDICA
AFTER INSERT, UPDATE AS
BEGIN
	UPDATE
		USUARIO
	SET
		USUARIO.PESO = REVISION.PESO
	FROM
		USUARIO AS USU
	INNER JOIN
		EMBARAZO AS EM
	ON USU.NICK = EM.ID_USUARIO
	INNER JOIN 
		(
		/*ASI COGE EL REGISTRO MAS NUEVO DEL PESO*/
		SELECT TOP 1 ID_EMBARAZO,PESO, FECHA_CITA_ACTUAL
		FROM REVISIONMEDICA
		ORDER BY FECHA_CITA_ACTUAL DESC
		) AS REVISION
	ON EM.ID = REVISION.ID_EMBARAZO 
END

go

--SELECT * FROM USUARIO
--SELECT * FROM EMBARAZO
--SELECT * FROM REVISIONMEDICA

--INSERT INTO REVISIONMEDICA (ID_EMBARAZO, PESO, CINTURA, CADERA, ESTADOFETO, OBSERVACIONES,FECHA_CITA_ACTUAL, FECHA_SIGUIENTE_CITA)
--VALUES('CDBD8786-4033-43F3-B253-4A2F85EE6E64', 150,50,50, 'TODO BIEN', 'TODO PERFE TIA', '20200725','20200526')

--INSERT INTO REVISIONMEDICA (ID_EMBARAZO, PESO, CINTURA, CADERA, ESTADOFETO, OBSERVACIONES, FECHA_CITA_ACTUAL,FECHA_SIGUIENTE_CITA)
--VALUES('CDBD8786-4033-43F3-B253-4A2F85EE6E64', 70,50,50, 'TODO BIEN', 'TODO PERFE TIA', '20190626','20200526')

--INSERT INTO REVISIONMEDICA (ID_EMBARAZO, PESO, CINTURA, CADERA, ESTADOFETO, OBSERVACIONES, FECHA_CITA_ACTUAL,FECHA_SIGUIENTE_CITA)
--VALUES('CDBD8786-4033-43F3-B253-4A2F85EE6E64', 150,50,50, 'TODO BIEN', 'TODO PERFE TIA', '20190627','20200526')
go

ALTER
--CREATE
TRIGGER insertarNulosUsuario 
ON USUARIO
AFTER INSERT, UPDATE AS
BEGIN
/*SOLO VALE PARA CUANDO INSERTAS DE UNO EN UNO*/
/*solo es necesario hacer esto con el PESO porque es un tipo de
dato primitivo y por tanto no puedo ponerlo a nulo en java, sino a 0
entonces para que no se ponga a 0 en la bbdd sino a null, hago este trigger*/
	IF ((SELECT PESO FROM inserted) = 0)
	BEGIN
	UPDATE USUARIO
	SET PESO = NULL
	WHERE NICK = (SELECT NICK FROM inserted)
	END
END
GO

/*trigger para que no se pueda insertar un embarazo
si ya hay uno en curso (sin fecha de fin)
*/

ALTER
--CREATE
TRIGGER noMasDeUnEmbarazoALaVez 
ON EMBARAZO
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS (select  CICLOINSERTADO.ID, CICLOINSERTADO.ID_USUARIO, CICLOINSERTADO.FECHAINICIO, CICLOINSERTADO.FECHAFIN_REAL
					from EMBARAZO AS CICLOINSERTADO
					INNER JOIN inserted AS CICLONUEVO
					ON CICLOINSERTADO.ID_USUARIO = CICLONUEVO.ID_USUARIO
					AND CICLOINSERTADO.ID != CICLONUEVO.ID
					where 
					(CICLONUEVO.FECHAINICIO BETWEEN CICLOINSERTADO.FECHAINICIO AND ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and 
					CICLONUEVO.FECHAFIN_REAL BETWEEN CICLOINSERTADO.FECHAINICIO AND ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					)
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and 
					CICLONUEVO.FECHAFIN_REAL > CICLOINSERTADO.FECHAINICIO
					and
					CICLONUEVO.FECHAFIN_REAL < ISNULL (CICLOINSERTADO.FECHAFIN_REAL, cast (CURRENT_TIMESTAMP as date))
					)
					or
					(
					CICLONUEVO.FECHAINICIO < ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					and
					CICLONUEVO.FECHAINICIO > CICLOINSERTADO.FECHAINICIO
					)
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and
					CICLONUEVO.FECHAINICIO < CICLOINSERTADO.FECHAINICIO
					and
					CICLONUEVO.FECHAFIN_REAL > ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					)
					)
					or
					CICLOINSERTADO.FECHAFIN_REAL is null
					and
					CICLONUEVO.FECHAFIN_REAL is null



				)
	BEGIN
		RAISERROR('Ya existe un embarazo en esa fecha',16,1)
		ROLLBACK
	END
END
go
ALTER
--CREATE
TRIGGER noMasDeUnaMenstruacionALaVez 
ON CICLOMENSTRUAL
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS (select  CICLOINSERTADO.ID, CICLOINSERTADO.ID_USUARIO, CICLOINSERTADO.FECHAINICIO, CICLOINSERTADO.FECHAFIN_REAL
					from CICLOMENSTRUAL AS CICLOINSERTADO
					INNER JOIN inserted AS CICLONUEVO
					ON CICLOINSERTADO.ID_USUARIO = CICLONUEVO.ID_USUARIO
					AND CICLOINSERTADO.ID != CICLONUEVO.ID
					where 
					CICLONUEVO.FECHAINICIO BETWEEN CICLOINSERTADO.FECHAINICIO AND ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and 
					CICLONUEVO.FECHAFIN_REAL BETWEEN CICLOINSERTADO.FECHAINICIO AND ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					)
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and 
					CICLONUEVO.FECHAFIN_REAL > CICLOINSERTADO.FECHAINICIO
					and
					CICLONUEVO.FECHAFIN_REAL < ISNULL (CICLOINSERTADO.FECHAFIN_REAL, cast (CURRENT_TIMESTAMP as date))
					)
					or
					(
					CICLONUEVO.FECHAINICIO < ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					and
					CICLONUEVO.FECHAINICIO > CICLOINSERTADO.FECHAINICIO
					)
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and
					CICLONUEVO.FECHAINICIO < CICLOINSERTADO.FECHAINICIO
					and
					CICLONUEVO.FECHAFIN_REAL > ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					)


				)
	BEGIN
		RAISERROR('Ya existe un ciclo menstrual en esa fecha',16,1)
		ROLLBACK
	END
END

GO
/*
trigger para que no se permita crear mas 
de una revision personal en un mismo dia
para un mismo usuario
*/
ALTER
--CREATE
TRIGGER unaRevisionPersonalAlDia
ON REVISIONPERSONAL
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS (
				select *
				from REVISIONPERSONAL as r
				inner join inserted as i
				on r.ID = i.ID
				where r.FECHA = cast (CURRENT_TIMESTAMP as date)
				and r.ID_USUARIO = i.ID_USUARIO
				and r.ID != i.ID
				)
	BEGIN
		RAISERROR('Actualmente ya existe una revision personal para el dia en curso',16,1)
		ROLLBACK
	END
END
GO
/*
trigger para que no se pueda
insertar un ciclo menstrual si 
hay un embarazo en curso

IMPORTANTE:
al contrario no ser�a necesario 
(que no se pueda insertar un embarazo en mitad
de un ciclo menstrual
porque realmente
s� que se puede, t� te quedas
embarazada en mitad de un ciclo menstrual)
*/
ALTER
--CREATE
TRIGGER noHayReglasEnMitadDelEmbarazo 
ON CICLOMENSTRUAL
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS (select  CICLOINSERTADO.ID, CICLOINSERTADO.ID_USUARIO, CICLOINSERTADO.FECHAINICIO, CICLOINSERTADO.FECHAFIN_REAL
					from EMBARAZO AS CICLOINSERTADO
					INNER JOIN inserted AS CICLONUEVO
					ON CICLOINSERTADO.ID_USUARIO = CICLONUEVO.ID_USUARIO
						AND CICLOINSERTADO.ID != CICLONUEVO.ID
					where 
					CICLONUEVO.FECHAINICIO BETWEEN CICLOINSERTADO.FECHAINICIO AND ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and 
					CICLONUEVO.FECHAFIN_REAL BETWEEN CICLOINSERTADO.FECHAINICIO AND ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					)
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and 
					CICLONUEVO.FECHAFIN_REAL > CICLOINSERTADO.FECHAINICIO
					and
					CICLONUEVO.FECHAFIN_REAL < ISNULL (CICLOINSERTADO.FECHAFIN_REAL, cast (CURRENT_TIMESTAMP as date))
					)
					or
					(
					CICLONUEVO.FECHAINICIO < ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					and
					CICLONUEVO.FECHAINICIO > CICLOINSERTADO.FECHAINICIO
					)
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and
					CICLONUEVO.FECHAINICIO < CICLOINSERTADO.FECHAINICIO
					and
					CICLONUEVO.FECHAFIN_REAL > ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					)

					)
				
	BEGIN
		RAISERROR('No se puede insertar una menstruacion en mitad de un embarazo',16,1)
		ROLLBACK
	END
END



ALTER
--CREATE
TRIGGER noHayEmbarazosEnMitadDeUnCiclo
ON embarazo
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS (select  CICLOINSERTADO.ID, CICLOINSERTADO.ID_USUARIO, CICLOINSERTADO.FECHAINICIO, CICLOINSERTADO.FECHAFIN_REAL
					from CICLOMENSTRUAL AS CICLOINSERTADO
					INNER JOIN inserted AS CICLONUEVO
					ON CICLOINSERTADO.ID_USUARIO = CICLONUEVO.ID_USUARIO
						AND CICLOINSERTADO.ID != CICLONUEVO.ID
					where 
					CICLONUEVO.FECHAINICIO BETWEEN CICLOINSERTADO.FECHAINICIO AND ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and 
					CICLONUEVO.FECHAFIN_REAL BETWEEN CICLOINSERTADO.FECHAINICIO AND ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					)
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and 
					CICLONUEVO.FECHAFIN_REAL > CICLOINSERTADO.FECHAINICIO
					and
					CICLONUEVO.FECHAFIN_REAL < ISNULL (CICLOINSERTADO.FECHAFIN_REAL, cast (CURRENT_TIMESTAMP as date))
					)
					or
					(
					CICLONUEVO.FECHAINICIO < ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					and
					CICLONUEVO.FECHAINICIO > CICLOINSERTADO.FECHAINICIO
					)
					or
					(
					CICLONUEVO.FECHAFIN_REAL is not null
					and
					CICLONUEVO.FECHAINICIO < CICLOINSERTADO.FECHAINICIO
					and
					CICLONUEVO.FECHAFIN_REAL > ISNULL(CICLOINSERTADO.FECHAFIN_REAL, cast(CURRENT_TIMESTAMP as date))
					)

					)
				
	BEGIN
		RAISERROR('No se puede insertar un embarazo en mitad de un ciclo',16,1)
		ROLLBACK
	END
END




go
ALTER
--CREATE
TRIGGER noMasDeUnCicloALaVez 
ON CICLOMENSTRUAL
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS (select  *
					from CICLOMENSTRUAL AS CICLOINSERTADO
					inner join EMBARAZO as CICLOEMBARAZOINSERTADO
					on CICLOINSERTADO.ID_USUARIO = CICLOEMBARAZOINSERTADO.ID_USUARIO
					INNER JOIN inserted AS CICLONUEVO
					ON CICLOINSERTADO.ID_USUARIO = CICLONUEVO.ID_USUARIO
						AND CICLOINSERTADO.ID != CICLONUEVO.ID
					where 
					CICLONUEVO.FECHAFIN_REAL is null
					and
					(CICLOINSERTADO.FECHAFIN_REAL is null
					or
					CICLOEMBARAZOINSERTADO.FECHAFIN_REAL is null
					)
				)
	BEGIN
		RAISERROR('No puede haber mas de un ciclo a la vez',16,1)
		ROLLBACK
	END
END
GO



go


ALTER
--CREATE
TRIGGER noMasDeUnCicloALaVezEmbarazo 
ON EMBARAZO
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS (
					select  *
					from EMBARAZO as CICLOEMBARAZOINSERTADO
					INNER JOIN inserted AS CICLONUEVO
					ON CICLOEMBARAZOINSERTADO.ID = CICLONUEVO.ID
					inner join CICLOMENSTRUAL as regla
					on regla.ID_USUARIO = CICLONUEVO.ID_USUARIO
					where 
					CICLOEMBARAZOINSERTADO.ID != CICLONUEVO.ID
					and
					CICLONUEVO.FECHAFIN_REAL is null
					and
					(regla.FECHAFIN_REAL is null
					or
					CICLOEMBARAZOINSERTADO.FECHAFIN_REAL is null
					)
				)
	BEGIN
		RAISERROR('No puede haber mas de un ciclo a la vez',16,1)
		ROLLBACK
	END
END
GO



/*TODO: trigger para que la fecha de fin insertada
no sea nunca menor a la fecha de inicio*/

ALTER
--CREATE
TRIGGER controlarQueFechaFinNoSeaAnteriorAInicioRegla 
ON CICLOMENSTRUAL
AFTER INSERT, UPDATE AS
BEGIN
	if EXISTS (
		select *
		from CICLOMENSTRUAL as cm
		inner join inserted as i
		on cm.ID = i.ID
		where cm.FECHAFIN_REAL < cm.FECHAINICIO
	)
	BEGIN
		RAISERROR('La fecha de fin no puede ser anterior a la fecha de inicio',16,1)
		ROLLBACK
	END
END
GO
ALTER
--CREATE
TRIGGER controlarQueFechaFinNoSeaAnteriorAInicioEmbarazo 
ON EMBARAZO
AFTER INSERT, UPDATE AS
BEGIN
	if EXISTS (
		select *
		from EMBARAZO as cm
		inner join inserted as i
		on cm.ID = i.ID
		where cm.FECHAFIN_REAL < cm.FECHAINICIO
	)
	BEGIN
		RAISERROR('La fecha de fin no puede ser anterior a la fecha de inicio',16,1)
		ROLLBACK
	END
END


/*
it's not a bug, it's a feature: 
En el programa, cuando insertas un periodo de una fecha anterior, como 
ese ciclo se queda sin fecha de fin, lo detecta como el ciclo actual
En realidad no es un problema como tal porque hasta que no cierras ese 
ciclo no te deja abrir uno nuevo.
Si en lugar de llamarlo "ciclo actual" fuera
"ultimo ciclo sin cierre" seria mas acertado
*/


/*
No debe permitir ingresar ciclos en una fecha anterior
a la fecha de nacimiento del usuario
*/

ALTER
--CREATE
TRIGGER noCiclosAntesDeNacer 
ON CICLOMENSTRUAL
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS ( 
	select ID, FECHANACIMIENTO 
	from USUARIO  as U
	inner join inserted as I
	on U.NICK = I.ID_USUARIO
	where 
	I.FECHAINICIO < U.FECHANACIMIENTO
	or
	I.FECHAFIN_REAL < U.FECHANACIMIENTO
	)
	BEGIN
		RAISERROR('No puedes insertar un ciclo antes de haber nacido',16,1)
		ROLLBACK
	END
END
go

ALTER
--CREATE
TRIGGER noEmbarazosAntesDeNacer 
ON EMBARAZO
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS ( 
	select ID, FECHANACIMIENTO 
	from USUARIO  as U
	inner join inserted as I
	on U.NICK = I.ID_USUARIO
	where 
	I.FECHAINICIO < U.FECHANACIMIENTO
	or
	I.FECHAFIN_REAL < U.FECHANACIMIENTO
	)
	BEGIN
		RAISERROR('No puedes insertar un embarazo antes de haber nacido',16,1)
		ROLLBACK
	END
END

go
/*
TRIGGER 
para que ninguna fecha sea superior a la fecha actual
*/
ALTER
--CREATE
TRIGGER noViajesEnElTiempoEmbarazo
ON EMBARAZO
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS ( 
	select *
	from inserted 
	
	where 
	FECHAINICIO > cast (CURRENT_TIMESTAMP as date)
	or
	FECHAFIN_REAL > cast (CURRENT_TIMESTAMP as date)
	)
	BEGIN
		RAISERROR('Lo siento no puedes registrar fechas superiores a la actual',16,1)
		ROLLBACK
	END
END

go

ALTER
--CREATE
TRIGGER noViajesEnElTiempoRegla
ON CICLOMENSTRUAL
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS ( 
	select *
	from inserted 
	where 
	FECHAINICIO > cast (CURRENT_TIMESTAMP as date)
	or
	FECHAFIN_REAL > cast (CURRENT_TIMESTAMP as date)
	)
	BEGIN
		RAISERROR('Lo siento no puedes registrar fechas superiores a la actual',16,1)
		ROLLBACK
	END
END

go

/*Trigger para controlar las fechas actual y siguiente de la cita m�dica,
controlar que todas las citas esten dentro de un embarazo*/

ALTER
--CREATE
TRIGGER fechaSiguienteDespuesDeActualRevisionMedica
ON REVISIONMEDICA
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS ( 
	select *
	from inserted 
	where 
	FECHA_SIGUIENTE_CITA <= FECHA_CITA_ACTUAL
	)
	BEGIN
		RAISERROR('La fecha de la siguiente cita no puede ser menor o igual a la de la cita actual',16,1)
		ROLLBACK
	END
END

/*Trigger para comprobar que la fecha de la cita en vigor no sea
superior a la fecha actual*/
ALTER
--CREATE
TRIGGER fechaCitaActualNoPuedeSerSuperiorAMomentoActual
ON REVISIONMEDICA
AFTER INSERT, UPDATE AS
BEGIN
	IF EXISTS ( 
	select *
	from inserted 
	where 
	FECHA_CITA_ACTUAL > cast(CURRENT_TIMESTAMP as date)
	)
	BEGIN
		RAISERROR('La fecha de la cita en vigor no puede ser mayor a la fecha actual',16,1)
		ROLLBACK
	END
END

go
/*Trigger para controlar que una revision medica siempre este dentro
del periodo de un embarazo
*/
ALTER
--CREATE
TRIGGER fechaRevisionMedicaDentroPeriodoEmbarazo
ON REVISIONMEDICA
AFTER INSERT, UPDATE AS
BEGIN
	IF (
		(select e.FECHAFIN_REAL
	from inserted  as i
	inner join EMBARAZO as e
	on i.ID_EMBARAZO = e.ID) != null	
			)
			begin
				if exists (
					select *
					from inserted  as i
					inner join EMBARAZO as e
					on i.ID_EMBARAZO = e.ID
					where i.FECHA_CITA_ACTUAL not between e.FECHAINICIO and e.FECHAFIN_REAL
				)

				BEGIN
					RAISERROR('La fecha debe estar dentro del periodo del embarazo',16,1)
					ROLLBACK
				END
			end
	
END