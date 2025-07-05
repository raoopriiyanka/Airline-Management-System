-- MySQL dump 10.13  Distrib 8.0.39, for Win64 (x86_64)
--
-- Host: localhost    Database: airlinemanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cancel`
--

DROP TABLE IF EXISTS `cancel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cancel` (
  `pnr` varchar(20) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `cancelno` varchar(20) DEFAULT NULL,
  `fcode` varchar(20) DEFAULT NULL,
  `ddate` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancel`
--

LOCK TABLES `cancel` WRITE;
/*!40000 ALTER TABLE `cancel` DISABLE KEYS */;
INSERT INTO `cancel` VALUES ('PNR-105415','neha','771605','1022','25-Oct-2024'),('PNR-180681','Priyanka Rao','55377','1022','16-Jul-2025'),('PNR-832787','Heer Mehta','415688','1023','21-Jul-2025');
/*!40000 ALTER TABLE `cancel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `f_code` varchar(20) DEFAULT NULL,
  `f_name` varchar(20) DEFAULT NULL,
  `source` varchar(40) DEFAULT NULL,
  `destination` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('-','-','Select City','Select City'),('1021','AI-2001','Bangalore','Jaipur'),('1022','AI-2002','Hyderabad','Delhi'),('1023','AI-2003','Mumbai','Pune'),('1024','AI-2004','Chennai','Goa'),('1025','AI-2005','Kolkata','Bangalore'),('1026','AI-2006','Amritsar','Hyderabad'),('1027','AI-2007','Pune','Chennai'),('1028','AI-2008','Delhi','Kolkata'),('1029','AI-2009','Jaipur','Mumbai'),('1030','AI-2010','Goa','Amritsar'),('1031','AI-2011','Bangalore','Kolkata'),('1032','AI-2012','Pune','Jaipur'),('1033','AI-2013','Chennai','Delhi'),('1034','AI-2014','Mumbai','Amritsar'),('1035','AI-2015','Hyderabad','Goa'),('1036','AI-2016','Kolkata','Hyderabad'),('1037','AI-2017','Bangalore','Pune'),('1038','AI-2018','Delhi','Chennai'),('1039','AI-2019','Jaipur','Hyderabad'),('1040','AI-2020','Goa','Delhi');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin','admin'),('user','pass');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
  `name` varchar(20) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `aadhar` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES ('Priyanka Rao','Indian','Mumbai','1122334466','111222','FEMALE'),('Heer Mehta','Indian','Delhi','8899445566','333444','FEMALE');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `PNR` varchar(15) DEFAULT NULL,
  `TICKET` varchar(20) DEFAULT NULL,
  `aadhar` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `nationality` varchar(30) DEFAULT NULL,
  `flightname` varchar(15) DEFAULT NULL,
  `flightcode` varchar(20) DEFAULT NULL,
  `src` varchar(30) DEFAULT NULL,
  `des` varchar(30) DEFAULT NULL,
  `ddate` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES ('PNR-80366','TIC-8519','2005','Priyanka','indian','AI-2001','1021','Bangalore','Jaipur','30-Oct-2024'),('PNR-844028','TIC-2081','111222','Priyanka Rao','Indian','AI-2017','1037','Bangalore','Pune','09-Jul-2025');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-05 22:42:53
