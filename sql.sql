-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: youthvibe
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `news_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `descr` text NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'20 načina kako zaraditi novac online!','Kako zaraditi novac online uz što malo ulaganja otkrivamo ovom detaljnom tekstu sa 20 najboljih načina oline zarade. Zarada iz vlastitog doma je najslađa (govorimo iz iskustva) pa nije ni čudo što se sve više ljudi odlučuje za pokretanje biznisa i online zarade.',''),(2,'Osnovan Srednjoškolski medicinski centar European Medical College','Univerzitet Sarajevska škola za nauku i tehnologiju (SSST) sa zadovoljstvom predstavlja European Medical College, inovativnu obrazovnu ustanovu, čiji je osnivač. Uz osnivanje Sarajevo Medical School koji nudi studijske programe iz medicine, stomatologije i farmacije, te uspostavljanje Unimed poliklinike, srednjoškolski centar je još jedan korak kojim SSST osnažuje obrazovni sistem i daje doprinos unapređenju sektora zdravsta Bosne i Hercegovine.',''),(3,'Podrška mentalnom zdravlju djece i mladih','Osim školskih torbi, djeca i mladi na svojim leđima često nose i brojne nevidljive terete – brige, strahove, posljedice vršnjačkog zlostavljanja ili nasilja u obitelji, pritiska u školi, bolesti roditelja ili konfliktnih razvoda. Dodatne izazove donijeli su i pandemija i potresi.  Mentalno zdravlje jednako je važno kao i ono fizičko pa ipak, mnoga se djeca i mladi s problemima mentalnog zdravlja nose u tišini, sama. Cijena te tišine iznimno je velika – za njih, njihove obitelji i za cijelo društvo. Zato je važno da im kao društvo osiguramo potrebnu podršku.','');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prilike`
--

DROP TABLE IF EXISTS `prilike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prilike` (
  `prilikaID` int NOT NULL AUTO_INCREMENT,
  `naslov` varchar(256) DEFAULT NULL,
  `opis` varchar(500) DEFAULT NULL,
  `datum` varchar(20) DEFAULT NULL,
  `lokacija` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`prilikaID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prilike`
--

LOCK TABLES `prilike` WRITE;
/*!40000 ALTER TABLE `prilike` DISABLE KEYS */;
INSERT INTO `prilike` VALUES (1,'Pridruži se velikom online događaju “Caring Communities”!',' Pridruži se velikom online događaju “Caring Communities”!\r\n\r\n⭐ Ko bi trebao prisustvovati?\r\nIstraživačice, inovatori, pružatelji socijalnih usluga, volonterke, javni akteri, nevladine organizacije – svi zainteresovani za budućnost kućne njege i usluga u zajednici.','21.6.2024.','Zenica'),(2,'Edukacija: Kreiraj uspješan handmade biznis: od ideje do prve prodaje!','Osmislili smo online edukaciju, baš za kreativce, pod nazivom Kreiraj uspješan handmade biznis: od ideje do prve prodaje. NAČIN PRIJAVE: putem PRIJAVNOG OBRASCA ','25.6.2024.','Zenica'),(3,'Prijavite se na Akademiju političke pismenosti mladih u BiH!','Fondacija „Akademija za žene“ realizovat će naredni modul u okviru Akademije političke pismenosti mladih u BiH, u periodu od 19. do 23. juna u Neumu, za polaznike i polaznice 3. i 4. generacije.','26.6.2024.','Zenica'),(4,'Pridruži se velikom online događaju “Caring Communities”!',' Pridruži se velikom online događaju “Caring Communities”!\r\n\r\n⭐ Ko bi trebao prisustvovati?\r\nIstraživačice, inovatori, pružatelji socijalnih usluga, volonterke, javni akteri, nevladine organizacije – svi zainteresovani za budućnost kućne njege i usluga u zajednici.','21.6.2024.','Zenica');
/*!40000 ALTER TABLE `prilike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_ID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`user_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-20 13:32:22
