DROP DATABASE IF EXISTS bbdd_visa;

CREATE DATABASE bbdd_visa;

USE bbdd_visa;

CREATE TABLE escaladors (
	id_escalador	INT UNSIGNED AUTO_INCREMENT,
    nom 			VARCHAR(25),
    alies 			VARCHAR(25)		COMMENT "Com li coneixen",
    edat 			TINYINT,
    nivell_maxim	VARCHAR(3) 		COMMENT "Nivell de via màxim que ha escalat",
    via_nivell_max	INT UNSIGNED	COMMENT "Quina via ha sigut el seu nivell màxim",
    estil_preferit	ENUM('Esportiva','Clàssica','Gel'),
    /*
    historial		VARCHAR(120),
    fita			VARCHAR(100),
    */
    CONSTRAINT pk_escaladors PRIMARY KEY (id_escalador)
);

CREATE TABLE localitzacions (
	id_localitzacio		INT UNSIGNED AUTO_INCREMENT,
    ciutat				VARCHAR(20) 	COMMENT "Ex: Lloret de Mar",
    regio				VARCHAR(20)		COMMENT "EX: Girona",
    codipostal			VARCHAR(10)		COMMENT "EX: 17310",
    CONSTRAINT pk_localitzacions PRIMARY KEY (id_localitzacio)
);

CREATE TABLE escoles (
	id_escola			INT UNSIGNED AUTO_INCREMENT,
    nom					VARCHAR(30),
	id_localitzacio		INT UNSIGNED	COMMENT "Ciutat, Regió, CP",
    aproximacio			VARCHAR(120) 	COMMENT "Descripció de com arribar",
    numero_vies			TINYINT 		COMMENT "Número de vies de té l'escola",
    popularitat			ENUM('Baixa','Mitjana','Alta'),
    restriccions		VARCHAR(150) 	COMMENT "Prohibicions en casos especials",
    CONSTRAINT pk_escoles PRIMARY KEY (id_escola),
    CONSTRAINT fk_escoles_poblacions FOREIGN KEY (id_localitzacio)
		REFERENCES localitzacions(id_localitzacio),
    CONSTRAINT uk_escoles_nom UNIQUE (nom)
);

CREATE TABLE sectors (
	id_sector		INT UNSIGNED AUTO_INCREMENT,
    nom				VARCHAR(30),
    coordenades		VARCHAR(50) 	COMMENT "Latitud, Longitud",
    aproximacio		VARCHAR(120) 	COMMENT "Breu descripcío de com arribar",
    numero_vies		TINYINT 		COMMENT "Número de vies de té l'escola",
    popularitat		ENUM('Baixa','Mitjana','Alta'),
    restriccions	VARCHAR(150) 	COMMENT "Prohibicions en casos especials",
    id_escola		INT UNSIGNED,
    CONSTRAINT pk_sectors PRIMARY KEY (id_sector),
    CONSTRAINT fk_sectors_escoles FOREIGN KEY (id_escola)
		REFERENCES escoles(id_escola)
);

CREATE TABLE dificultats (
    id_dificultat 	INT UNSIGNED AUTO_INCREMENT,
    nom 			VARCHAR(3) 		COMMENT "Numero, Numero+, NumeroLletra o NumeroLletra+",
    CONSTRAINT pk_dificultats PRIMARY KEY (id_dificultat)
);

CREATE TABLE ancoratges (
	id_ancoratge	INT UNSIGNED AUTO_INCREMENT,
	nom				ENUM('Friends','Tascons','Bagues','Tricams','BigBros','Spits','Parabolts','Químics'),
    CONSTRAINT pk_ancoratges PRIMARY KEY (id_ancoratge)
);

CREATE TABLE tipus_roques (
    id_tipus_roca 	INT UNSIGNED AUTO_INCREMENT,
    nom				ENUM('Conglomerat','Granit','Calcaria','Arenisca','Altres'),
    CONSTRAINT pk_tipus_roques PRIMARY KEY (id_tipus_roca)
);

CREATE TABLE materials (
    id_material    	INT UNSIGNED AUTO_INCREMENT,
    nom				VARCHAR(35),
    CONSTRAINT pk_materials PRIMARY KEY (id_material)
);

CREATE TABLE tipus_vies (
	id_tipus_via 	INT UNSIGNED AUTO_INCREMENT,
    nom				ENUM('Esportiva', 'Clàssica', 'Gel'),
    CONSTRAINT pk_tipus_vies PRIMARY KEY (id_tipus_via)
);

CREATE TABLE trams (
	id_via			INT UNSIGNED,
    id_dificultat	INT UNSIGNED,
    llargada		SMALLINT
);

CREATE TABLE vies (
    id_via              INT UNSIGNED AUTO_INCREMENT,
    nom                 VARCHAR(25),
    id_tipus_via        INT UNSIGNED			COMMENT "(FK tipus_vies)",
    estat               ENUM('Apte', 'Construcció', 'Tancada'),
    orientacio          ENUM('N', 'NE', 'NO', 'SE', 'SO', 'E', 'O', 'S'),
    id_ancoratge        INT UNSIGNED 			COMMENT "(FK ancoratges)",
    id_tipus_roca       INT UNSIGNED			COMMENT "(FK tipus_roca)",
    id_sector           INT UNSIGNED			COMMENT "(FK sectors)",
    creador        		INT UNSIGNED 			COMMENT "(FK escaladors)",
    CONSTRAINT pk_vies PRIMARY KEY (id_via)
);

ALTER TABLE escaladors
	ADD CONSTRAINT fk_escaladors_vies FOREIGN KEY (via_nivell_max)
		REFERENCES vies(id_via);

ALTER TABLE trams
	ADD CONSTRAINT fk_trams_vies FOREIGN KEY (id_via)
		REFERENCES vies(id_via),
	ADD CONSTRAINT fk_trams_dificultat FOREIGN KEY (id_dificultat)
		REFERENCES dificultats(id_dificultat);

ALTER TABLE vies
	ADD CONSTRAINT fk_vies_tipus_via FOREIGN KEY (id_tipus_via)
		REFERENCES tipus_vies(id_tipus_via),
    ADD CONSTRAINT fk_vies_ancoratges FOREIGN KEY (id_ancoratge)
        REFERENCES ancoratges(id_ancoratge),
    ADD CONSTRAINT fk_vies_tipus_roca FOREIGN KEY (id_tipus_roca)
        REFERENCES tipus_roques(id_tipus_roca),
    ADD CONSTRAINT fk_vies_sectors FOREIGN KEY (id_sector)
        REFERENCES sectors(id_sector),
    ADD CONSTRAINT fk_vies_escalador FOREIGN KEY (creador)
        REFERENCES escaladors(id_escalador);