DROP DATABASE IF EXISTS GestionaleOspedale;
CREATE DATABASE GestionaleOspedale;
USE GestionaleOspedale;

create table Persone(
	personaID INTEGER PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(250) NOT NULL,
	cognome VARCHAR(250) NOT NULL,
    codice_fiscale VARCHAR(16) NOT NULL
);

create table Visite_mediche(
	visitaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    codice_univoco VARCHAR(16) UNIQUE NOT NULL,
    codice_segreto VARCHAR(16) UNIQUE NOT NULL,
    esito VARCHAR(250) NOT NULL,
    data_visita date NOT NULL,
    personaRIF INTEGER,
	FOREIGN KEY (personaRIF) REFERENCES Persone(personaID) ON DELETE CASCADE
);


INSERT INTO Persone(nome,cognome,codice_fiscale) VALUES
("Mario","Rossi","MRO1243"),
("Luca","Verdi","LVR1234");

INSERT INTO Visite_mediche(codice_univoco,codice_segreto,esito,data_visita,personaRIF) VALUES 
("codiceUnivoco","codiceSegreto","esito",'2022-11-11',1),
("1111","1111","Male Male",'2022-12-11',2);

SELECT * FROM Persone JOIN Visite_mediche ON Visite_mediche.personaRIF = Persone.personaID;