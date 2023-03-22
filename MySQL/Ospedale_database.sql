DROP DATABASE IF EXISTS GestionaleOspedale;
CREATE DATABASE GestionaleOspedale;
USE GestionaleOspedale;

create table Visite_mediche(
	visitaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nominativo VARCHAR(250) NOT NULL,
    codice_fiscale VARCHAR(16) NOT NULL,
    codice_univoco VARCHAR(16) UNIQUE NOT NULL,
    codice_segreto VARCHAR(16) UNIQUE NOT NULL,
    esito VARCHAR(250) NOT NULL,
    data_visita date NOT NULL
);

INSERT INTO Visite_mediche(nominativo,codice_fiscale,codice_univoco,codice_segreto,esito,data_visita) VALUES 
("nominativo","codiceFiscale","codiceUnivoco","codiceSegreto","esito",'2022-11-11'),
("Mario Rossi","MRO1243","1111","1111","Male Male",'2022-12-11');

SELECT * FROM VisiteMediche WHERE codice_fiscale = "codiceFiscale";


SELECT * FROM Visite_mediche WHERE  "2022-10-11" < data_visita and data_visita < "2022-12-11";

SELECT * FROM Visite_mediche;