CREATE TABLE IF NOT EXISTS Coachs(
	nom VARCHAR(50) NOT NULL PRIMARY KEY,
	prenom VARCHAR(50) NOT NULL,
	codePostal INT NOT NULL 
);

CREATE TABLE IF NOT EXISTS Cours(
	id SERIAL NOT NULL PRIMARY KEY,
	libelle TEXT NOT NULL,
	coach_nom VARCHAR(50) NOT NULL REFERENCES Coachs(nom)
);


CREATE TABLE IF NOT EXISTS Objectifs(
	id SERIAL NOT NULL,
	libelle TEXT NOT NULL,
	id_cours INT NOT NULL REFERENCES Cours(id)
);

INSERT INTO Coachs(nom, prenom, codePostal) 
VALUES ('Dupond','Jean', 75015), ('Duchamp','Marc', 75016);


INSERT INTO Cours(id, libelle, coach_nom) 
VALUES (1,'Coaching Standard', 'Dupond'), (2,'Coaching Fitness', 'Duchamp');

INSERT INTO Objectifs(id, libelle, id_cours) 
VALUES (1,'Remise en forme', 1), (2,'Perdre du poids', 1), (3, 'Gain de masse musculaire', 2);