CREATE DATABASE  IF NOT EXISTS `jfinance` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `jfinance`;
-- MySQL dump 10.13  Distrib 5.5.53, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: jfinance
-- ------------------------------------------------------
-- Server version	5.7.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_credit`
--

DROP TABLE IF EXISTS `tb_credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_credit` (
  `cr_idcredit` int(100) NOT NULL AUTO_INCREMENT,
  `cr_name` varchar(45) NOT NULL,
  `cr_description` varchar(100) DEFAULT NULL,
  `cr_available` varchar(10) NOT NULL,
  `cr_value` decimal(7,2) NOT NULL,
  `cr_iduser` int(100) DEFAULT NULL COMMENT '	',
  PRIMARY KEY (`cr_idcredit`),
  KEY `fk_credit_user_idx` (`cr_iduser`),
  CONSTRAINT `fk_credit_user` FOREIGN KEY (`cr_iduser`) REFERENCES `tb_user` (`us_iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_credit`
--

LOCK TABLES `tb_credit` WRITE;
/*!40000 ALTER TABLE `tb_credit` DISABLE KEYS */;
INSERT INTO `tb_credit` VALUES (9,'salario','salario do mes 11','05/11/2016',1500.00,NULL),(13,'salario','novo salario','11/11/2016',2000.00,16),(17,'credito1','credito1','11/10/2016',2000.00,16),(18,'credito2','credito2','11/09/2016',2000.34,16),(19,'sdsd','ssd','11/09/2016',2323.00,15),(21,'salario','salario','13/12/2016',2000.00,21),(22,'adasd','asddasd','14/12/2016',123.00,16);
/*!40000 ALTER TABLE `tb_credit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-14 20:56:28
