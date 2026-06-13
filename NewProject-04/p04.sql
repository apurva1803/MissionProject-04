-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: p04
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `st_college`
--

DROP TABLE IF EXISTS `st_college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st_college` (
  `ID` bigint NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `PHONE_NO` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_college`
--

LOCK TABLES `st_college` WRITE;
/*!40000 ALTER TABLE `st_college` DISABLE KEYS */;
INSERT INTO `st_college` VALUES (2,'Truba','Indore','Indore','Indore','999999','Rahul Sahu','rahul.sahu@nenosystems.com','2014-07-19 17:42:17','2026-05-15 16:19:14'),(3,'SVIM','Gumasta Nagar','MP','Indore','9999999999','Rahul Sahu','Rahul Sahu','2014-07-19 17:42:17','2014-07-19 17:42:17'),(4,'J.I.Y.Indore','Rau','Madhya Pradesh','khargone','1234567890',NULL,NULL,NULL,NULL),(5,'J.I.U.Institute','Indore Road Rau','Gujrat','Bhopal','9165254357',NULL,NULL,NULL,NULL),(6,'M.I.T.Ujjain','Ujjain Road','Madhya Pradesh','Indore','1234567890',NULL,NULL,NULL,NULL),(7,'Oriyantel Tech','Mumbai road','Madhya Predash','Ahemdabad','985658568',NULL,NULL,NULL,NULL),(8,'M.D.Mansore','Nimach Road','Mansore','Mansore','7896321450',NULL,NULL,NULL,NULL),(9,'M.Y.Univercity','khargone','Madhya Pradesh','khargone','1234567890',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `st_college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st_course`
--

DROP TABLE IF EXISTS `st_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st_course` (
  `ID` bigint NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `DURATION` varchar(100) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_course`
--

LOCK TABLES `st_course` WRITE;
/*!40000 ALTER TABLE `st_course` DISABLE KEYS */;
INSERT INTO `st_course` VALUES (1,'Java','Java is a programing language','02-04','root@sunilos.com','root@sunilos.com','2026-05-30 11:35:37','2026-05-30 11:35:37');
/*!40000 ALTER TABLE `st_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st_faculty`
--

DROP TABLE IF EXISTS `st_faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st_faculty` (
  `ID` bigint NOT NULL,
  `COLLEGE_ID` bigint DEFAULT NULL,
  `COLLEGE_NAME` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `MOBILE_NO` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `GENDER` varchar(50) DEFAULT NULL,
  `DATE_OF_BIRTH` datetime DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_faculty`
--

LOCK TABLES `st_faculty` WRITE;
/*!40000 ALTER TABLE `st_faculty` DISABLE KEYS */;
INSERT INTO `st_faculty` VALUES (1,5,'J.I.U.Institute','Ram','Sharma','ram@gmail.com','9856569858','07 Ganga Bag Colony','Male','2002-12-12 00:00:00','rahul.sahu@nenosystems.com','rahul.sahu@nenosystems.com','2026-05-14 12:22:23','2026-05-14 12:22:23');
/*!40000 ALTER TABLE `st_faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st_marksheet`
--

DROP TABLE IF EXISTS `st_marksheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st_marksheet` (
  `ID` bigint NOT NULL,
  `ROLL_NO` varchar(255) DEFAULT NULL,
  `STUDENT_ID` bigint DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PHYSICS` int DEFAULT NULL,
  `CHEMISTRY` int DEFAULT NULL,
  `MATHS` int DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_marksheet`
--

LOCK TABLES `st_marksheet` WRITE;
/*!40000 ALTER TABLE `st_marksheet` DISABLE KEYS */;
INSERT INTO `st_marksheet` VALUES (1,'1',2,'Manish Sharma',99,99,99,'Rahul Sahu','rahul.sahu@nenosystems.com','2014-07-19 17:45:57','2014-07-21 19:14:20'),(2,'2',2,'Manish Sharma',55,55,55,NULL,NULL,NULL,NULL),(3,'3',2,'Manish Sharma',77,77,77,NULL,NULL,NULL,NULL),(4,'4',1,'Rahul Sahu',88,88,85,NULL,NULL,NULL,NULL),(5,'5',5,'Sivam Kumar',74,74,78,NULL,NULL,NULL,NULL),(6,'6',6,'Gurpreet Singh',55,55,55,NULL,NULL,NULL,NULL),(7,'7',5,'Sivam Kumar',82,82,89,NULL,NULL,NULL,NULL),(8,'9',6,'Gurpreet Singh',88,99,78,NULL,NULL,NULL,NULL),(9,'10',7,'Viju kumar chandore',77,77,77,NULL,NULL,NULL,NULL),(10,'11',3,'Vipin Chandore',88,99,79,NULL,NULL,NULL,NULL),(11,'12',7,'Viju kumar chandore',88,88,88,NULL,NULL,NULL,NULL),(12,'13',1,'Rahul Sahu',85,88,99,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `st_marksheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st_role`
--

DROP TABLE IF EXISTS `st_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st_role` (
  `ID` bigint NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_DATETIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_role`
--

LOCK TABLES `st_role` WRITE;
/*!40000 ALTER TABLE `st_role` DISABLE KEYS */;
INSERT INTO `st_role` VALUES (1,'Admin','Administrator Role','Admin','Admin','2014-07-19 11:43:36','2014-07-19 11:43:36'),(2,'Student','Student Role','Rahul Sahu','Rahul Sahu','2014-07-19 11:49:09','2014-07-19 11:49:09'),(3,'College','College Role','Rahul Sahu','Rahul Sahu','2014-07-19 11:49:30','2014-07-19 11:49:30'),(4,'KIOSK','KIOSK Role','Rahul Sahu','Rahul Sahu','2014-07-19 11:49:48','2014-07-19 11:49:48');
/*!40000 ALTER TABLE `st_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st_student`
--

DROP TABLE IF EXISTS `st_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st_student` (
  `ID` bigint NOT NULL,
  `COLLEGE_ID` bigint DEFAULT NULL,
  `COLLEGE_NAME` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `DATE_OF_BIRTH` datetime DEFAULT NULL,
  `MOBILE_NO` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_student`
--

LOCK TABLES `st_student` WRITE;
/*!40000 ALTER TABLE `st_student` DISABLE KEYS */;
INSERT INTO `st_student` VALUES (1,5,'J.I.U.Institute','Rahul','Sahu','2014-07-17 00:00:00','123456789','ram@gmail.com',NULL,NULL,NULL,NULL),(2,3,'SVIM','Manish','Sharma','2014-07-18 00:00:00','7896321452','manish@gmail.com',NULL,NULL,NULL,NULL),(3,5,'J.I.U.Institute','Vipin','Chandore','1991-12-05 00:00:00','9165254357','Vipin@gmail.com',NULL,NULL,NULL,NULL),(4,6,'M.I.T.Ujjain','Deepak','kumar','1991-10-05 00:00:00','9165254357','d@gmail.com',NULL,'root@sunilos.com',NULL,'2026-05-16 16:54:13'),(5,6,'M.I.T.Ujjain','Sivam','Kumar','2026-06-02 00:00:00','7894563210','g@gmail.com',NULL,'root@sunilos.com',NULL,'2026-06-01 15:52:26');
/*!40000 ALTER TABLE `st_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st_subject`
--

DROP TABLE IF EXISTS `st_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st_subject` (
  `ID` bigint NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `COURSE_ID` bigint DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_subject`
--

LOCK TABLES `st_subject` WRITE;
/*!40000 ALTER TABLE `st_subject` DISABLE KEYS */;
INSERT INTO `st_subject` VALUES (1,'String','String is a array of char',1,'root@sunilos.com','root@sunilos.com','2026-05-30 11:36:13','2026-05-30 11:36:13');
/*!40000 ALTER TABLE `st_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st_user`
--

DROP TABLE IF EXISTS `st_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st_user` (
  `ID` bigint NOT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `LOGIN` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `DOB` datetime DEFAULT NULL,
  `MOBILE_NO` varchar(255) DEFAULT NULL,
  `ROLE_ID` bigint DEFAULT NULL,
  `UNSUCCESSFUL_LOGIN` int DEFAULT NULL,
  `GENDER` varchar(255) DEFAULT NULL,
  `LAST_LOGIN` datetime DEFAULT NULL,
  `USER_LOCK` varchar(255) DEFAULT NULL,
  `REGISTERED_IP` varchar(255) DEFAULT NULL,
  `LAST_LOGIN_IP` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_user`
--

LOCK TABLES `st_user` WRITE;
/*!40000 ALTER TABLE `st_user` DISABLE KEYS */;
INSERT INTO `st_user` VALUES (1,'Anshul','Prajapati','an@gmail.com','aa','2026-05-13 00:00:00',NULL,1,0,'M',NULL,'Inactive',NULL,NULL,'Rahul Sahu','an@gmail.com','2014-07-19 17:39:20','2026-06-01 12:23:38'),(2,'Rakesh','Sen','vipinchandore@gmail.com','rr','2014-07-21 00:00:00','1234567890',2,0,'M','2014-07-19 20:18:49','Inactive','0:0:0:0:0:0:0:1','192.168.1.5','Rahul Sahu','Rahul Sahu','2014-07-19 17:39:20','2014-07-19 20:19:00'),(3,'ramlakhan','chandore','vipinchandorerrr@gmail.com','123','1991-12-05 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,NULL,NULL,NULL,NULL),(4,'vijay','chouhan','vijay@gmail.com','123','1991-10-05 00:00:00',NULL,1,0,'M',NULL,'Inactive',NULL,NULL,NULL,NULL,NULL,NULL),(5,'Viju kumarrr','Soni ji','Viju@gmail.com','123','2006-04-05 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'an@gmail.com','an@gmail.com','2026-06-01 12:23:51','2026-06-01 12:23:51');
/*!40000 ALTER TABLE `st_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-02 11:22:10
