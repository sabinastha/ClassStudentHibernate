create database springtutorial;
create table testdata (id int not null auto_increment primary key,foo varchar(25), bar int);




DROP TABLE IF EXISTS `offers`;
create table offers(id int not null auto_increment primary key,name varchar(50), email varchar(50),text varchar(200));

insert into offers values(null,'sanjay','rauniyarsanjay@gmail.com','instructor');
insert into offers values(null,'rauniyar','rauniyar_sanjay@mail.com','instructor');


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(60) NOT NULL,
  `password` varchar(80) DEFAULT NULL,
  `authority` varchar(45) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `email` varchar(60) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `offers`;
CREATE TABLE `offers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `username` varchar(60) NOT NULL,
  PRIMARY KEY (`id`,`username`),
  KEY `fk_offers_users_idx` (`username`),
  CONSTRAINT `fk_offers_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;