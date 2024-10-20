/*
SQLyog Community Edition- MySQL GUI v6.55
MySQL - 5.5.5-10.4.32-MariaDB : Database - sprigboot
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`sprigboot` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `sprigboot`;

/*Table structure for table `contrato` */

DROP TABLE IF EXISTS `contrato`;

CREATE TABLE `contrato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_insercao` datetime(6) DEFAULT NULL,
  `texto` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `valor` decimal(38,2) DEFAULT NULL,
  `id_servico` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK549xskx8rqs1lxb43khpvil68` (`id_servico`),
  CONSTRAINT `FK549xskx8rqs1lxb43khpvil68` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `contrato` */

insert  into `contrato`(`id`,`data_insercao`,`texto`,`titulo`,`valor`,`id_servico`) values (1,'2024-10-19 16:01:57.000000','modelo texto','Contrato 001/200','20000.00',1),(2,'2024-10-19 16:02:35.000000','modelo texto','Contrato 002/200','20000.00',2),(3,'2024-10-19 16:04:22.000000','modelo texto2','Contrato 003/200','15600.30',3),(4,'2024-10-19 16:55:19.000000','modelo texto','Contrato 004/200','15600.10',2),(6,'2024-10-20 17:11:19.000000','TESTE DE TEXTO PARA ENVIO','MODELO 1010/2024','15000.00',2),(7,'2024-10-20 17:26:50.000000','texto','Modelo react 01/2024','4500.00',3),(8,'2024-10-20 17:32:43.000000','modelo texto','Contrato 005/200','15600.10',2),(9,'2024-10-20 17:35:26.000000','modelo','Modelo React 100','3500.00',2);

/*Table structure for table `servico` */

DROP TABLE IF EXISTS `servico`;

CREATE TABLE `servico` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_insercao` datetime(6) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `servico` */

insert  into `servico`(`id`,`data_insercao`,`descricao`,`titulo`) values (1,'2024-10-18 11:48:42.000000','serviço de saude aos funcionarios','Unimed'),(2,'2024-10-18 11:52:41.000000','serviço de dentes aos funcionarios','Uniodoto'),(3,'2024-10-18 11:53:55.000000','aulas de faculdade','Cesupa'),(4,'2024-10-18 11:55:13.000000','parque de diversão','Beto carreiro');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_insercao` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `perfil` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `usuario` */

insert  into `usuario`(`id`,`data_insercao`,`email`,`nome`,`senha`,`status`,`perfil`) values (2,'2024-10-17 20:00:28.000000','johndoe@example.com','John Doe','$2a$10$IKGig6KPwPkeV3DVQ5xyduvVHTn7ECEP3OUbCPASwtg7wMYkOfibe','\0','1'),(4,'2024-10-18 08:45:31.000000','david.foxmulder@gmail.com','david orion','$2a$10$aKR35inPC.T/i5MYs4/5n.y1bLPROM/o2wTdIAQcsZhd61.jLNWPe','','2'),(5,'2024-10-18 10:04:00.000000','jessica@gmail.com','Jessica natasha','$2a$10$ci3BaXBncjtErCvYlth/v.isTTVLXh30CH0YJdPF8pATl6fLjvKJe','\0','2'),(6,'2024-10-20 17:44:29.000000','regina@teste.com','Regina Celia','$2a$10$hQQUlnEPE2WEsveKGbctKe4LIHSWZi.jvbt/txeA1mjtd26iSyQqW','','1'),(7,'2024-10-20 18:06:19.000000','claudio@teste.com.br','Claudio Nonato','$2a$10$1X29.kiuijhghMzP.JA7s.jvDXNhIhTPgG33xRLHwl9sazD/jA2am','','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
