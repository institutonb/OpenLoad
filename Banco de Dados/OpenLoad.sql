CREATE DATABASE  IF NOT EXISTS `OpenLoad` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `OpenLoad`;
-- MySQL dump 10.13  Distrib 5.5.40, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: OpenLoad
-- ------------------------------------------------------
-- Server version	5.5.40-0ubuntu0.14.04.1

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
-- Table structure for table `arquivo`
--

DROP TABLE IF EXISTS `arquivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arquivo` (
  `idarquivo` int(11) NOT NULL AUTO_INCREMENT,
  `nomearquivo` varchar(45) NOT NULL,
  `aula_idaula` int(11) NOT NULL,
  `aula_fk_curso` int(11) NOT NULL,
  PRIMARY KEY (`idarquivo`),
  KEY `fk_arquivo_aula1_idx` (`aula_idaula`,`aula_fk_curso`),
  CONSTRAINT `fk_arquivo_aula1` FOREIGN KEY (`aula_idaula`, `aula_fk_curso`) REFERENCES `aula` (`idaula`, `fk_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arquivo`
--

LOCK TABLES `arquivo` WRITE;
/*!40000 ALTER TABLE `arquivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `arquivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aula` (
  `idaula` int(11) NOT NULL,
  `linkaula` text NOT NULL,
  `fk_curso` int(11) NOT NULL,
  `nomeaula` varchar(40) NOT NULL,
  `descricaoaula` text NOT NULL,
  `exercicio_idexercicio` int(11) NOT NULL,
  PRIMARY KEY (`idaula`,`fk_curso`),
  KEY `fk_aula_curso1_idx` (`fk_curso`),
  KEY `fk_aula_exercicio1_idx` (`exercicio_idexercicio`),
  CONSTRAINT `fk_aula_exercicio1` FOREIGN KEY (`exercicio_idexercicio`) REFERENCES `exercicio` (`idexercicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aula_curso1` FOREIGN KEY (`fk_curso`) REFERENCES `curso` (`idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `idcurso` int(11) NOT NULL AUTO_INCREMENT,
  `nomecurso` varchar(45) NOT NULL,
  `tipocurso` tinyint(4) NOT NULL,
  `valorcurso` float NOT NULL,
  `descricaocurso` text NOT NULL,
  `conteudocurso` text NOT NULL,
  `prerequisitoscurso` text NOT NULL,
  `tempocurso` varchar(15) NOT NULL,
  `datainiciocurso` date NOT NULL,
  `diasaulacurso` varchar(80) NOT NULL,
  `publicoalvocurso` varchar(255) NOT NULL,
  PRIMARY KEY (`idcurso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dados_usuario`
--

DROP TABLE IF EXISTS `dados_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dados_usuario` (
  `iddados_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nomedados_usuario` varchar(80) NOT NULL,
  `cpfdados_usuario` int(11) NOT NULL,
  `telefonedados_usuario` int(11) DEFAULT NULL,
  `fk_usuario` int(11) NOT NULL,
  `enderecodados_usuario` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`iddados_usuario`,`fk_usuario`),
  UNIQUE KEY `cpfdados_usuario_UNIQUE` (`cpfdados_usuario`),
  KEY `fk_dados_usuario_usuario_idx` (`fk_usuario`),
  CONSTRAINT `fk_dados_usuario_usuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_usuario`
--

LOCK TABLES `dados_usuario` WRITE;
/*!40000 ALTER TABLE `dados_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `dados_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercicio`
--

DROP TABLE IF EXISTS `exercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercicio` (
  `idexercicio` int(11) NOT NULL AUTO_INCREMENT,
  `qtdacertosexercicio` varchar(45) NOT NULL,
  `qtderrosexercicio` varchar(45) NOT NULL,
  `perguntaexercicio` text NOT NULL,
  `respostaexercicio` text NOT NULL,
  PRIMARY KEY (`idexercicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercicio`
--

LOCK TABLES `exercicio` WRITE;
/*!40000 ALTER TABLE `exercicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `senhaUsuario` varchar(45) NOT NULL,
  `emailUsuario` varchar(45) NOT NULL,
  `nivelUsuario` int(11) NOT NULL,
  `statususuario` tinyint(1) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_curso`
--

DROP TABLE IF EXISTS `usuario_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_curso` (
  `idusuario_curso` int(11) NOT NULL,
  `curso_idcurso` int(11) NOT NULL,
  PRIMARY KEY (`idusuario_curso`,`curso_idcurso`),
  KEY `fk_usuario_has_curso_curso1_idx` (`curso_idcurso`),
  KEY `fk_usuario_has_curso_usuario1_idx` (`idusuario_curso`),
  CONSTRAINT `fk_usuario_has_curso_curso1` FOREIGN KEY (`curso_idcurso`) REFERENCES `curso` (`idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_curso_usuario1` FOREIGN KEY (`idusuario_curso`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_curso`
--

LOCK TABLES `usuario_curso` WRITE;
/*!40000 ALTER TABLE `usuario_curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_curso` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-30 14:53:08
