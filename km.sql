-- MySQL dump 10.13  Distrib 8.0.12, for osx10.13 (x86_64)
--
-- Host: localhost    Database: km
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Article`
--

DROP TABLE IF EXISTS `Article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Article` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `problem` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `solution` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Article`
--

LOCK TABLES `Article` WRITE;
/*!40000 ALTER TABLE `Article` DISABLE KEYS */;
INSERT INTO `Article` VALUES (1,'How to Properly Reinstall Windowshuhuhuhregrereghrthth','<html dir=\"ltr\"><head></head><body contenteditable=\"true\">Windows needs to be reinstalled.1232</body></html>','<html dir=\"ltr\"><head></head><body contenteditable=\"true\">1. Reboot.&nbsp;<div>2. Start System Recovery.&nbsp;</div><div>3. Choose the option to Reinstall Windows.</div></body></html>'),(2,'My Internets Are Broken23123123','<html dir=\"ltr\"><head></head><body contenteditable=\"true\">Can\'t connect to the internet.qwewqewqqw</body></html>','<html dir=\"ltr\"><head></head><body contenteditable=\"true\">Switch to carrier pigeons.</body></html>'),(3,'123123','<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Lucida Grande\">1231231</font></p></body></html>','<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Lucida Grande\">123123</font></p></body></html>'),(4,'','<html dir=\"ltr\"><head></head><body contenteditable=\"true\"></body></html>','<html dir=\"ltr\"><head></head><body contenteditable=\"true\"></body></html>'),(5,'This is article 5','<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Lucida Grande\">happy are we<span class=\"Apple-tab-span\" style=\"white-space:pre\">	</span></font></p></body></html>','<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Lucida Grande\">yes indeed</font></p></body></html>'),(6,'wewe','<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Lucida Grande\">wewewe<span class=\"Apple-tab-span\" style=\"white-space:pre\">	</span></font></p></body></html>','<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Lucida Grande\">wewewew</font></p></body></html>');
/*!40000 ALTER TABLE `Article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-18 21:37:02
