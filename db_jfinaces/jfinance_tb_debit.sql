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
-- Table structure for table `tb_debit`
--

DROP TABLE IF EXISTS `tb_debit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_debit` (
  `de_iddebit` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `de_name` varchar(45) NOT NULL,
  `de_description` varchar(45) DEFAULT NULL,
  `de_maturity` varchar(10) NOT NULL,
  `de_value` decimal(7,2) NOT NULL,
  `de_iduser` int(11) NOT NULL,
  PRIMARY KEY (`de_iddebit`),
  KEY `fk_tb_debit_user_idx` (`de_iduser`),
  CONSTRAINT `fk_tb_debit_user` FOREIGN KEY (`de_iduser`) REFERENCES `tb_user` (`us_iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_debit`
--

LOCK TABLES `tb_debit` WRITE;
/*!40000 ALTER TABLE `tb_debit` DISABLE KEYS */;
INSERT INTO `tb_debit` VALUES (2,'debito','descricao','13/12/2016',2000.00,16),(3,'aluguel','mes 12','13/12/2016',500.00,21),(4,'qweqwe','qweqwe','14/12/2016',2323.00,16);
/*!40000 ALTER TABLE `tb_debit` ENABLE KEYS */;
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
