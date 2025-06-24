CREATE DATABASE /*!32312 IF NOT EXISTS*/`mahasiswa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;



/*Table structure for table `mhs` */


/*CREATE DATABASE `mahasiswa`;*/
USE `mahasiswa`;
DROP TABLE IF EXISTS `mhs`;
CREATE TABLE `mhs` (
  `NIM` VARCHAR(10) NOT NULL,
  `NAMA` VARCHAR(200) DEFAULT NULL,
  `ALAMAT` VARCHAR(225) DEFAULT NULL,
  PRIMARY KEY (`NIM`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `mhs` */

INSERT  INTO `mhs`(`NIM`,`NAMA`,`ALAMAT`) VALUES 
('2301010425','Suciantari','Denpasar');