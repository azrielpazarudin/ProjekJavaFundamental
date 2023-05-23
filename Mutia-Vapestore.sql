`produk``produk`CREATE DATABASE mutiavapestore;
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
	hargaBeli INT(11),
	hargaJual INT (11),
	CONSTRAINT fk_ik FOREIGN KEY (idKategori) REFERENCES kategori(idKategori)
);



CREATE OR REPLACE TABLE penjualan(
	idPenjualan CHAR (5) PRIMARY KEY,
	tanggalTransaksi DATETIME,
	totalTransaksi INT(11)
);

CREATE OR REPLACE TABLE detailPenjualan(
	idPenjualan CHAR (5),
	idProduk CHAR (5) NOT NULL,
	namaProduk VARCHAR (50) NOT NULL,
	subHarga INT (11),
	jumlah INT(11),
	totalHarga INT (11),
	CONSTRAINT fk_ip FOREIGN KEY (idProduk) REFERENCES produk(idProduk),
	CONSTRAINT fk_ipj FOREIGN KEY (idPenjualan) REFERENCES penjualan(idPenjualan)	
);

CREATE OR REPLACE TABLE logo(
	id INT (11),
	gambar LONGBLOB
);

CREATE OR REPLACE TABLE pembelian(
	idPembelian CHAR (5) PRIMARY KEY,
	tanggalTransaksi DATETIME,
	totalTransaksi INT (11)
);
CREATE OR REPLACE TABLE detailPembelian(
	idPembelian CHAR (5),
	idProduk CHAR (5),
	namaProduk VARCHAR (50),
	gambarProduk LONGBLOB,
	idKategori CHAR (5),
	kategori VARCHAR(50),
	jumlah INT(11),
	hargaBeli INT(11),
	hargaJual INT (11),
	CONSTRAINT fk_ipj11 FOREIGN KEY (idPembelian) REFERENCES pembelian(idPembelian),
	CONSTRAINT fk_idk11 FOREIGN KEY (idKategori) REFERENCES kategori(idKategori)
);

CREATE OR REPLACE TABLE servis(
	idServis CHAR (5) PRIMARY KEY,
	namaCustomer VARCHAR (50),
	noTelp VARCHAR (13),
	namaBarang VARCHAR(50),
	tanggalMulai DATETIME,
	tanggalSelesai DATETIME,
	biaya INT(11)
);
CREATE OR REPLACE TABLE riwayatServis LIKE servis

DELIMITER $$;
CREATE OR REPLACE TRIGGER isiRiwayatServis
BEFORE DELETE ON servis
FOR EACH ROW BEGIN
	INSERT INTO riwayatServis VALUES (old.idServis,old.namaCustomer,old.noTelp,old.namaBarang,old.tanggalMulai,old.tanggalSelesai,old.biaya);
END;


SELECT *FROM keranjangJual;

INSERT INTO kategori VALUES
('KTG01','Device'),
('KTG02','Attomizer'),
('KTG03','Liquid'),
('KTG04','Kapas'),
('KTG05','Kawat'),
('KTG06','Batre & Charger'),
('KTG07','Tools');
