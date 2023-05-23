CREATE DATABASE mutiavapestore;
USE mutiavapestore;

CREATE OR REPLACE TABLE akun(
	username CHAR (20) PRIMARY KEY,
	PASSWORD VARCHAR (50)
);
CREATE OR REPLACE TABLE kategori(
	idKategori CHAR (5) PRIMARY KEY,
	kategori VARCHAR (50) NOT NULL,
	
);
CREATE OR REPLACE TABLE produk(
	idProduk CHAR (5) PRIMARY KEY,
	namaProduk VARCHAR (50) NOT NULL,
	gambar LONGBLOB,
	idKategori CHAR (5) NOT NULL,
	kategori VARCHAR(50),
	stok INT (11),
	harga INT (11),
	CONSTRAINT fk_ik FOREIGN KEY (idKategori) REFERENCES kategori(idKategori)
);

CREATE OR REPLACE TABLE tipemember(
	idTipeMember CHAR (5) PRIMARY KEY,
	tipeMember VARCHAR (30) NOT NULL,
	diskon INT (11)
);

CREATE OR REPLACE TABLE anggota(
	idAnggota CHAR (5) PRIMARY KEY,
	namaAnggota VARCHAR (50),
	kodeOtentik INT (11),
	idTipeMember CHAR (5),
	tipeMember VARCHAR (50),
	CONSTRAINT fk_it FOREIGN KEY (idTipeMember) REFERENCES tipeMember(idTipeMember)
);

INSERT INTO akun VALUES
('admin','admin123');

INSERT INTO kategori VALUES
('KTG01','Device'),
('KTG02','Attomizer'),
('KTG03','Liquid'),
('KTG04','Kapas'),
('KTG05','Batre & Charger'),
('KTG06','Tools');

INSERT INTO tipeMember VALUES
('MBR01','Gold',35),
('MBR02','Silver',25),
('MBR03','Bronze',15);

CREATE OR REPLACE TABLE logo(
	id INT (11),
	gambar LONGBLOB
);
SELECT *FROM logo;


