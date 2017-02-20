-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: freedomfinancialdatabase
-- ------------------------------------------------------
-- Server version	5.6.26

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(45) NOT NULL,
  `dept_location` varchar(45) DEFAULT NULL,
  `dept_expertise` varchar(45) DEFAULT NULL,
  `dept_size` int(11) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (7,'Social','Salisbury','Analytics',0),(9,'Social','Salisbury','Analytics',0),(10,'Social','Salisbury','Analytics',890),(12,'Science','nam','Target',25),(15,'Kart','Charlotte','Data',250),(16,'Java','Arizona','Freedom',250);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_lname` varchar(45) NOT NULL,
  `emp_fname` varchar(45) NOT NULL,
  `emp_email` varchar(45) NOT NULL,
  `emp_phone` double NOT NULL,
  `emp_gender` varchar(45) DEFAULT NULL,
  `emp_age` int(11) DEFAULT NULL,
  `emp_YOJ` int(11) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `employee_ibfk_1` (`dept_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (5,'Agarwal','Hima888888888888888888888','h@gmail.com',89890,'M',90,2016,7),(6,'Agarwal','Hima','h@gmail.com',89890,'M',90,2016,9),(7,'Agarwal','Dhan','h@gmail.com',89890,'F',52,2014,9),(8,'Agarwal','Dhan','h@gmail.com',89890,'F',52,2014,9),(10,'Agarwal','Hima','h@gmail.com',89890,'M',90,2016,9),(11,'Agarwal','Hima','h@gmail.com',89890,'M',90,2016,9),(12,'Agarwal','123456','h@gmail.com',89890,'M',90,2016,9),(15,'Sharma','Himanshu','h@gmail.com',89890,'M',90,2016,7),(16,'Agarwal','Himanshu	','haga@uncc.edu',89890,'M',25,2017,16);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'freedomfinancialdatabase'
--

--
-- Dumping routines for database 'freedomfinancialdatabase'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-20 17:25:06
