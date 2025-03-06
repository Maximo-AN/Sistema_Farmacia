CREATE DATABASE FCristoRey;
use FCristoRey;

CREATE TABLE Usuarios(
	id int AUTO_INCREMENT,
	user varchar(20) NOT NULL,
	pass varchar(20) NOT NULL,
	CONSTRAINT us_pk PRIMARY KEY (id)
);

CREATE TABLE Proveedores(
	prov_id int AUTO_INCREMENT,
	prov_nom varchar(100),
	prov_mail varchar(50),
	prov_dir varchar(100),
	prov_cat varchar(50),
	CONSTRAINT prov_pk PRIMARY KEY (prov_id)
);

CREATE TABLE Productos(
	prod_id int(20),
	prod_nom varchar(50),
	prod_uni int(20),
	prod_cate varchar(50),
	prod_cadu date,
	prod_prov varchar(50),
	CONSTRAINT prod_pk PRIMARY KEY (prod_id)
);

CREATE TABLE Ticket(
	ticket_id int NOT NULL AUTO_INCREMENT,
	ticket_producto varchar(50),
	ticket_user varchar(20),
	ticket_subtotal varchar(30),
	ticket_total varchar(30),
	ticket_fecha date,
	ticket_cantidad varchar(30),
	CONSTRAINT ticket_pk PRIMARY KEY (ticket_id)
);

ALTER TABLE productos ADD DEFAULT 1 FOR prod_id;


//Pruebas

INSERT INTO Usuarios(user, pass) VALUES
('Max', '130304');




