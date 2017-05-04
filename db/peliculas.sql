CREATE DATABASE peliculas;
USE peliculas;
CREATE TABLE actores (
	id INT NOT NULL AUTO_INCREMENT,
    nombre	VARCHAR(50) NOT NULL,
	nacion 	VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
 );
 
 CREATE TABLE directores (
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	fechaNacimiento DATE NOT NULL,
	nacion VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
);
    
CREATE TABLE peliculas (
	id INT NOT NULL AUTO_INCREMENT,
	directorId INT NOT NULL,
	titulo VARCHAR(50) NOT NULL,
	año INT NOT NULL,
	nacion VARCHAR(20) NOT NULL,
	idioma VARCHAR(20) NOT NULL,
	color VARCHAR(20) NOT NULL,
	resumen TEXT NOT NULL,
	observacion TEXT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FOREIGN KEY(directorId) REFERENCES directores(id)
);
CREATE TABLE reparto (
	id INT NOT NULL AUTO_INCREMENT,
	peliculaId INT NOT NULL,
	actorId INT NOT NULL,
	personaje VARCHAR(50) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FOREIGN KEY (peliculaId) REFERENCES peliculas(id),
    CONSTRAINT FOREIGN KEY (actorId) REFERENCES actores(id)
);