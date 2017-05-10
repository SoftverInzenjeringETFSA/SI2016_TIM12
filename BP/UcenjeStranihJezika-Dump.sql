-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ucenje_stranih_jezika
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `administratori`
--

DROP TABLE IF EXISTS `administratori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administratori` (
  `ADMIN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `KORISNICKO_IME` varchar(255) NOT NULL,
  `SIFRA` varchar(255) NOT NULL,
  PRIMARY KEY (`ADMIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administratori`
--

LOCK TABLES `administratori` WRITE;
/*!40000 ALTER TABLE `administratori` DISABLE KEYS */;
/*!40000 ALTER TABLE `administratori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupe`
--

DROP TABLE IF EXISTS `grupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupe` (
  `GRUPA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAZIV` varchar(255) NOT NULL,
  `NIVO_KURSA_ID` int(11) DEFAULT NULL,
  `PREDAVAC_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`GRUPA_ID`),
  UNIQUE KEY `PREDAVAC_ID_UNIQUE` (`PREDAVAC_ID`),
  KEY `NIVO_KURSA_ID_idx` (`NIVO_KURSA_ID`),
  KEY `PREDAVAC_ID_idx` (`PREDAVAC_ID`),
  CONSTRAINT `GRUPA_NIVO_KURSA_ID` FOREIGN KEY (`NIVO_KURSA_ID`) REFERENCES `nivoi_kurseva` (`NIVO_KURSA_ID`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `PREDAVAC_ID` FOREIGN KEY (`PREDAVAC_ID`) REFERENCES `predavaci` (`PREDAVAC_ID`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupe`
--

LOCK TABLES `grupe` WRITE;
/*!40000 ALTER TABLE `grupe` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kursevi`
--

DROP TABLE IF EXISTS `kursevi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kursevi` (
  `KURS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAZIV_KURSA` varchar(255) NOT NULL,
  PRIMARY KEY (`KURS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kursevi`
--

LOCK TABLES `kursevi` WRITE;
/*!40000 ALTER TABLE `kursevi` DISABLE KEYS */;
/*!40000 ALTER TABLE `kursevi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materijali`
--

DROP TABLE IF EXISTS `materijali`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materijali` (
  `MATERIJAL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PREDAVANJE_ID` int(11) NOT NULL,
  `NAZIV` varchar(255) NOT NULL,
  `OPIS` varchar(255) DEFAULT NULL,
  `MATERIJAL` mediumblob NOT NULL,
  PRIMARY KEY (`MATERIJAL_ID`),
  KEY `PREDAVANJE_ID_idx` (`PREDAVANJE_ID`),
  CONSTRAINT `PREDAVANJE_ID` FOREIGN KEY (`PREDAVANJE_ID`) REFERENCES `predavanja` (`PREDAVANJE_ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materijali`
--

LOCK TABLES `materijali` WRITE;
/*!40000 ALTER TABLE `materijali` DISABLE KEYS */;
/*!40000 ALTER TABLE `materijali` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nivoi_kurseva`
--

DROP TABLE IF EXISTS `nivoi_kurseva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nivoi_kurseva` (
  `NIVO_KURSA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAZIV_NIVOA` char(2) NOT NULL,
  `KURS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`NIVO_KURSA_ID`),
  KEY `KURS_ID_idx` (`KURS_ID`),
  CONSTRAINT `KURS_ID` FOREIGN KEY (`KURS_ID`) REFERENCES `kursevi` (`KURS_ID`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivoi_kurseva`
--

LOCK TABLES `nivoi_kurseva` WRITE;
/*!40000 ALTER TABLE `nivoi_kurseva` DISABLE KEYS */;
/*!40000 ALTER TABLE `nivoi_kurseva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pitanja`
--

DROP TABLE IF EXISTS `pitanja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pitanja` (
  `PITANJE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TEST_ID` int(11) NOT NULL,
  `KATEGORIJA` int(11) NOT NULL,
  `PITANJE` varchar(500) NOT NULL,
  `ODGOVOR` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`PITANJE_ID`),
  KEY `TEST_ID_idx` (`TEST_ID`),
  CONSTRAINT `TEST_ID` FOREIGN KEY (`TEST_ID`) REFERENCES `testovi` (`TEST_ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pitanja`
--

LOCK TABLES `pitanja` WRITE;
/*!40000 ALTER TABLE `pitanja` DISABLE KEYS */;
/*!40000 ALTER TABLE `pitanja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predavaci`
--

DROP TABLE IF EXISTS `predavaci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `predavaci` (
  `PREDAVAC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `IME` varchar(255) NOT NULL,
  `PREZIME` varchar(255) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `BROJ_TELEFONA` varchar(255) DEFAULT NULL,
  `KORISNICKO_IME` varchar(255) NOT NULL,
  `SIFRA` varchar(255) NOT NULL,
  PRIMARY KEY (`PREDAVAC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predavaci`
--

LOCK TABLES `predavaci` WRITE;
/*!40000 ALTER TABLE `predavaci` DISABLE KEYS */;
/*!40000 ALTER TABLE `predavaci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predavanja`
--

DROP TABLE IF EXISTS `predavanja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `predavanja` (
  `PREDAVANJE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NIVO_KURSA_ID` int(11) DEFAULT NULL,
  `NAZIV_PREDAVANJA` varchar(255) NOT NULL,
  `VRIJEME_POCETKA` datetime DEFAULT NULL,
  `VRIJEME_KRAJA` datetime DEFAULT NULL,
  PRIMARY KEY (`PREDAVANJE_ID`),
  KEY `PRED_NIVO_KURSA_ID_idx` (`NIVO_KURSA_ID`),
  CONSTRAINT `PRED_NIVO_KURSA_ID` FOREIGN KEY (`NIVO_KURSA_ID`) REFERENCES `nivoi_kurseva` (`NIVO_KURSA_ID`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predavanja`
--

LOCK TABLES `predavanja` WRITE;
/*!40000 ALTER TABLE `predavanja` DISABLE KEYS */;
/*!40000 ALTER TABLE `predavanja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studenti`
--

DROP TABLE IF EXISTS `studenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studenti` (
  `STUDENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `IME` varchar(255) NOT NULL,
  `PREZIME` varchar(255) NOT NULL,
  `JMBG` char(13) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `DATUM_RODJENJA` datetime DEFAULT NULL,
  `MJESTO_RODJENJA` varchar(255) DEFAULT NULL,
  `ADRESA_BORAVISTA` varchar(255) DEFAULT NULL,
  `KORISNICKO_IME` varchar(255) NOT NULL,
  `SIFRA` varchar(255) NOT NULL,
  `GRUPA_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`STUDENT_ID`),
  KEY `GRUPA_ID_idx` (`GRUPA_ID`),
  CONSTRAINT `GRUPA_ID` FOREIGN KEY (`GRUPA_ID`) REFERENCES `grupe` (`GRUPA_ID`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studenti`
--

LOCK TABLES `studenti` WRITE;
/*!40000 ALTER TABLE `studenti` DISABLE KEYS */;
/*!40000 ALTER TABLE `studenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testovi`
--

DROP TABLE IF EXISTS `testovi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `testovi` (
  `TEST_ID` int(11) NOT NULL,
  `NIVO_KURSA_ID` int(11) DEFAULT NULL,
  `NAZIV_TESTA` varchar(255) NOT NULL,
  PRIMARY KEY (`TEST_ID`),
  UNIQUE KEY `NIVO_KURSA_ID_UNIQUE` (`NIVO_KURSA_ID`),
  KEY `TEST_NIVO_KURSA_ID_idx` (`NIVO_KURSA_ID`),
  CONSTRAINT `TEST_NIVO_KURSA_ID` FOREIGN KEY (`NIVO_KURSA_ID`) REFERENCES `nivoi_kurseva` (`NIVO_KURSA_ID`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testovi`
--

LOCK TABLES `testovi` WRITE;
/*!40000 ALTER TABLE `testovi` DISABLE KEYS */;
/*!40000 ALTER TABLE `testovi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zapisi`
--

DROP TABLE IF EXISTS `zapisi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zapisi` (
  `ZAPIS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `NIVO_KURSA_ID` int(11) DEFAULT NULL,
  `DATUM_POLAGANJA` datetime DEFAULT NULL,
  `POPUNJENI_TEST` mediumblob,
  `OSTVARENI_REZULTAT` double DEFAULT NULL,
  PRIMARY KEY (`ZAPIS_ID`),
  KEY `STUDENT_ID_idx` (`STUDENT_ID`),
  KEY `NIVO_KURSA_ID_idx` (`NIVO_KURSA_ID`),
  CONSTRAINT `NIVO_KURSA_ID` FOREIGN KEY (`NIVO_KURSA_ID`) REFERENCES `nivoi_kurseva` (`NIVO_KURSA_ID`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `STUDENT_ID` FOREIGN KEY (`STUDENT_ID`) REFERENCES `studenti` (`STUDENT_ID`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zapisi`
--

LOCK TABLES `zapisi` WRITE;
/*!40000 ALTER TABLE `zapisi` DISABLE KEYS */;
/*!40000 ALTER TABLE `zapisi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-08  1:30:19
