--MEDICAMENTO (PK)
--USUARIA(PK)
--MEDICAMENTO-USUARIA(PK (FK_MEDICAMENTO, FK_USUARIA ))


--CICLOMENSTRUAL(PK, FK_USUARIA)
--EMBARAZO(PK, FK_USUARIA)

--REVISIONMEDICA(PK, FK_EMBARAZO)

--REVISIONPERSONAL(PK, FK_USUARIA)

--ESTADOANIMICO(PK)
--SINTOMA(PK)
--FLUJOVAGINAL(PK)
--SEXO(PK)

--REVISIONPERSONAL-ESTADOANIMICO(PK (FK_REVISION, FK_ESTADO))
--REVISIONPERSONAL-SINTOMA (PK (FK_REVISION, FK_SINTOMA))
--REVISIONPERSONAL-FLUJOVAGINAL (PK (FK_REVISION, FK_FLUJOVAGINAL))
--REVISIONPERSONAL-SEXO (PK (FK_REVISION, FK_SEXO))

USE master
GO
CREATE 
DATABASE MenstruApp
GO
USE MenstruApp

CREATE TABLE MEDICAMENTO(
	ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
	NOMBRE NVARCHAR(80) NOT NULL,
	CONSTRAINT PK_MEDICAMENTO PRIMARY KEY (ID)
)
GO

--preguntarle a Leo si es mejor separar nick y contraseņa en una tabla login (aunque la relacion seria 1:1 y al final quedaria igual)
CREATE TABLE USUARIO (
	NICK NVARCHAR(25) NOT NULL,
	NOMBRE NVARCHAR(50) NULL,
	PASS VARBINARY(100) NOT NULL,	--VER: https://blog.buhoos.com/sql-server-como-crear-un-campo-contrasena-o-password/
	PESO DECIMAL (5,2) NULL,	--ES ASI: 100.00
	FECHANACIMIENTO DATE NULL,
	CONSTRAINT PK_USUARIO PRIMARY KEY (NICK)	
)
GO

CREATE TABLE MEDICAMENTO_USUARIO (
	ID_MEDICAMENTO UNIQUEIDENTIFIER NOT NULL,
	ID_USUARIO NVARCHAR(25) NOT NULL,
	ISRECETADO BIT NOT NULL,
	FECHAINICIO DATE NULL,	--A LO MEJOR NO SE RECUERDA (EJ ES ALGO QUE TE ESTABAS TOMANDO DE ANTES)
	FECHAFIN DATE NULL, --A LO MEJOR NO HAY INTENCION DE DEJARLO A CORTO PLAZO
	CANTIDAD NVARCHAR(100) NOT NULL,	--AQUI SE EXPLICA LA TOMA (EJ: "UNA PASTILLA CADA OCHO HORAS")

	CONSTRAINT FK_MEDICAMENTOUSUARIO_MEDICAMENTO FOREIGN KEY (ID_MEDICAMENTO)
	REFERENCES MEDICAMENTO(ID)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT FK_MEDICAMENTOUSUARIO_USUARIO FOREIGN KEY (ID_USUARIO)
	REFERENCES USUARIO(NICK)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT PK_MEDICAMENTOUSUARIO PRIMARY KEY (ID_MEDICAMENTO, ID_USUARIO)

)
GO

CREATE TABLE CICLOMENSTRUAL (
	ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
	ID_USUARIO NVARCHAR(25) NOT NULL,
	FECHAINICIO DATE NOT NULL,
	FECHAFIN_ESTIMADA DATE NOT NULL,	--PODRIA SER UNA COLUMNA CALCULADA
	FECHAFIN_REAL DATE NOT NULL

	CONSTRAINT PK_CICLOMENSTRUAL PRIMARY KEY (ID),
	CONSTRAINT FK_CICLOMENSTRUAL_USUARIO FOREIGN KEY (ID_USUARIO)
	REFERENCES USUARIO(NICK)
	ON DELETE NO ACTION ON UPDATE CASCADE

)
GO

CREATE TABLE EMBARAZO (
	ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
	ID_USUARIO NVARCHAR(25) NOT NULL,
	FECHAINICIO DATE NOT NULL,
	FECHAFIN_ESTIMADA DATE NOT NULL,	--PODRIA SER UNA COLUMNA CALCULADA
	FECHAFIN_REAL DATE NOT NULL

	CONSTRAINT PK_EMBARAZO PRIMARY KEY (ID),
	CONSTRAINT FK_EMBARAZO_USUARIO FOREIGN KEY (ID_USUARIO)
	REFERENCES USUARIO(NICK)
	ON DELETE NO ACTION ON UPDATE CASCADE
)
GO
CREATE TABLE REVISIONMEDICA (
	ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
	ID_EMBARAZO UNIQUEIDENTIFIER NOT NULL,
	PESO DECIMAL (5,2) NOT NULL,
	CINTURA DECIMAL (5,2) NOT NULL,
	CADERA DECIMAL (5,2) NOT NULL,
	ESTADOFETO NVARCHAR(20) NOT NULL,
	OBSERVACIONES NVARCHAR(200) NULL,
	FECHA_SIGUIENTE_CITA DATE NULL,

	CONSTRAINT PK_REVISIONMEDICA PRIMARY KEY (ID),
	CONSTRAINT FK_REVISIONMEDICA_EMBARAZO FOREIGN KEY (ID_EMBARAZO)
	REFERENCES EMBARAZO(ID)
	ON DELETE NO ACTION ON UPDATE CASCADE
)

GO

CREATE TABLE REVISIONPERSONAL (
	ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
	ID_USUARIO NVARCHAR(25) NOT NULL,
	FECHA DATE NOT NULL,

	CONSTRAINT PK_REVISIONPERSONAL PRIMARY KEY (ID),
	CONSTRAINT FK_REVISIONPERSONAL_USUARIO FOREIGN KEY (ID_USUARIO)
	REFERENCES USUARIO(NICK)
	ON DELETE NO ACTION ON UPDATE CASCADE
)
GO

CREATE TABLE ESTADOANIMICO (
	ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
	ESTADO NVARCHAR (100) NOT NULL,

	CONSTRAINT PK_ESTADOANIMICO PRIMARY KEY (ID)
)
GO

CREATE TABLE REVISIONPERSONAL_ESTADOANIMICO (
	ID_REVISIONPERSONAL UNIQUEIDENTIFIER NOT NULL,
	ID_ESTADOANIMICO UNIQUEIDENTIFIER NOT NULL,

	CONSTRAINT FK_REVISIONPERSONALESTADOANIMICO_REVISIONPERSONAL FOREIGN KEY (ID_REVISIONPERSONAL)
	REFERENCES REVISIONPERSONAL(ID)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT FK_REVISIONPERSONALESTADOANIMICO_ESTADOANIMICO FOREIGN KEY (ID_ESTADOANIMICO)
	REFERENCES ESTADOANIMICO(ID)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT PK_REVISIONPERSONAL_ESTADOANIMICO PRIMARY KEY (ID_REVISIONPERSONAL, ID_ESTADOANIMICO)

)
GO

CREATE TABLE SINTOMA (
	ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
	SINTOMA NVARCHAR(100) NOT NULL,

	CONSTRAINT PK_SINTOMA PRIMARY KEY (ID)
)
GO

CREATE TABLE REVISIONPERSONAL_SINTOMA (
	ID_REVISIONPERSONAL UNIQUEIDENTIFIER NOT NULL,
	ID_SINTOMA UNIQUEIDENTIFIER NOT NULL,

	CONSTRAINT FK_REVISIONPERSONALSINTOMA_REVISIONPERSONAL FOREIGN KEY (ID_REVISIONPERSONAL)
	REFERENCES REVISIONPERSONAL(ID)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT FK_REVISIONPERSONALSINTOMA_SINTOMA FOREIGN KEY (ID_SINTOMA)
	REFERENCES SINTOMA(ID)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT PK_REVISIONPERSONAL_SINTOMA PRIMARY KEY (ID_REVISIONPERSONAL, ID_SINTOMA)

)
GO


CREATE TABLE FLUJOVAGINAL (
	ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
	TIPO NVARCHAR(100) NOT NULL,

	CONSTRAINT PK_FLUJOVAGINAL PRIMARY KEY (ID)
)
GO

CREATE TABLE REVISIONPERSONAL_FLUJOVAGINAL (
	ID_REVISIONPERSONAL UNIQUEIDENTIFIER NOT NULL,
	ID_FLUJOVAGINAL UNIQUEIDENTIFIER NOT NULL,

	CONSTRAINT FK_REVISIONPERSONALSINTOMA_REVISIONPERSONAL FOREIGN KEY (ID_REVISIONPERSONAL)
	REFERENCES REVISIONPERSONAL(ID)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT FK_REVISIONPERSONALSINTOMA_FLUJOVAGINAL FOREIGN KEY (ID_FLUJOVAGINAL)
	REFERENCES FLUJOVAGINAL(ID)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT PK_REVISIONPERSONAL_FLUJOVAGINAL PRIMARY KEY (ID_REVISIONPERSONAL, ID_FLUJOVAGINAL)

)
GO

CREATE TABLE SEXO (
	ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
	OBSERVACION NVARCHAR(100) NOT NULL,

	CONSTRAINT PK_SEXO PRIMARY KEY (ID)
)
GO

CREATE TABLE REVISIONPERSONAL_SEXO (
	ID_REVISIONPERSONAL UNIQUEIDENTIFIER NOT NULL,
	ID_SEXO UNIQUEIDENTIFIER NOT NULL,

	CONSTRAINT FK_REVISIONPERSONALSINTOMA_REVISIONPERSONAL FOREIGN KEY (ID_REVISIONPERSONAL)
	REFERENCES REVISIONPERSONAL(ID)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT FK_REVISIONPERSONALSINTOMA_SEXO FOREIGN KEY (ID_SEXO)
	REFERENCES SEXO(ID)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT PK_REVISIONPERSONAL_SEXO PRIMARY KEY (ID_REVISIONPERSONAL, ID_SEXO)

)
GO

/*
USE MASTER
GO
DROP DATABASE MENSTRUAPP
GO
*/