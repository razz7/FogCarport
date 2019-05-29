DROP SCHEMA IF exists `fog`;
CREATE SCHEMA IF NOT EXISTS `fog`;
USE `fog`;

CREATE TABLE `fog`.`stock`(
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_description` text,
  `width` float DEFAULT NULL,
  `height` float DEFAULT NULL,
  `entity` text,
  `materialtype` text,
  `price` float DEFAULT '0',
  `stockquantity` int(11) DEFAULT '0',
  PRIMARY KEY (`item_id`));

INSERT INTO `stock`(`item_id`, `item_description`, `width`, `height`, `entity`, `materialtype`, `price`, `stockquantity`) VALUES
(1,'25x200 mm. trykimp. Brædt',25,200,'stk','Træ & Tagplader',0,0),
(2,'25x125mm. trykimp. Brædt.',25,125,'stk','Træ & Tagplader',0,0),
(3,'38x73 mm. Lægte ubh.',38,73,'stk','Træ & Tagplader',0,0),
(4,'45x95 mm. Reglar ub.',45,95,'stk','Træ & Tagplader',0,0),
(5,'45x195 mm. spærtræ ubh.',45,195,'stk','Træ & Tagplader',0,0),
(6,'97x97 mm. trykimp. Stolpe',97,97,'stk','Træ & Tagplader',0,0),
(7,'19x100 mm. trykimp. Brædt',19,100,'stk','Træ & Tagplader',0,0),
(8,'Plastmo Ecolite blåtonet',0,0,'stk','Træ & Tagplader',0,0),
(9,'plastmo bundskruer 200 stk.',0,0,'pakke','Beslag & Skruer',0,0),
(10,'hulbånd 1x20 mm. 10 mtr.',1,20,'rulle','Beslag & Skruer',0,0),
(12,'universal 190 mm højre',0,190,'stk','Beslag & Skruer',0,0),
(13,'universal 190 mm venstre',0,190,'stk','Beslag & Skruer',0,0),
(14,'4,5 x 60 mm. skruer 200 stk.',4.5,60,'pakke','Beslag & Skruer',0,0),
(15,'4,0 x 50 mm. beslagskruer 250 stk.',4,50,'pakke','Beslag & Skruer',0,0),
(16,'bræddebolt 10 x 120 mm.',10,120,'stk','Beslag & Skruer',0,0),
(17,'firkantskiver 40x40x11mm',40,40,'stk','Beslag & Skruer',0,0),
(18,'4,5 x 70 mm. Skruer 400 stk.',4.5,70,'pk','Beslag & Skruer',0,0),
(19,'4,5 x 50 mm. Skruer 300 stk.',4.5,50,'pk','Beslag & Skruer',0,0),
(20,'stalddørsgreb 50x75',50,75,'sæt','Beslag & Skruer',0,0),
(21,'t hængsel 390 mm',0,0,'stk','Beslag & Skruer',0,0),
(22,'vinkelbeslag 35',0,0,'stk','Beslag & Skruer',0,0),
(23,'25x150 mm. trykimp. Bræt',25,150,'stk','Træ',0,0),
(24,'fædigskåret (byg-selv spær)',0,0,'sæt','Træ',0,0),
(25,'25x50 mm. trykimp. Bræt',25,50,'stk','Træ',0,0),
(26,'38x73 mm. taglægte T1',38,73,'stk','Træ',0,0),
(27,'B & C Dobbelt -s sort',0,0,'stk','Tagpakken',0,0),
(28,'B & C Rygsten sort',0,0,'stk','Tagpakken',0,0),
(29,'B & C Toplægte holder',0,0,'stk','Tagpakken',0,0),
(30,'B & C rygstensbeslag',0,0,'stk','Tagpakken',0,0),
(31,'B & C tagstens bindere & nakkekroge',0,0,'pk','Tagpakken',0,0),
(32,'5,0 x 40 mm. beslagskruer 250 stk.',5,40,'pakke','Beslag & Skruer',0,0),
(33,'5,0 x 100 mm. skruer 100 stk.',5,100,'pakke','Beslag & Skruer',0,0),
(34,'4,5 x 70 mm. Skruer 200 stk.',4.5,70,'pk','Beslag & Skruer',0,0),
(35,'4,5 x 50 mm. Skruer 350 stk.',4.5,50,'pk','Beslag & Skruer',0,0);

CREATE TABLE IF NOT EXISTS `fog`.`orders` (
  `order_id` INT(11) NOT NULL AUTO_INCREMENT,
  `width` FLOAT NULL DEFAULT NULL,
  `length` FLOAT NULL DEFAULT NULL,
  `rooftilt` FLOAT NULL DEFAULT NULL,
  `shedwidth` FLOAT NULL DEFAULT NULL,
  `shedlength` FLOAT NULL DEFAULT NULL,
  `status` TINYINT(4) NULL DEFAULT '0',
  `customer_id` INT(11) NULL DEFAULT NULL,
  `orderdate` DATE NULL DEFAULT NULL,
  `price` FLOAT DEFAULT '0',
  PRIMARY KEY (`order_id`));


CREATE TABLE `fog`.`lineitems` (
  `lineitems_id` INT(11) NOT NULL AUTO_INCREMENT,
  `item_id` INT(11) NULL DEFAULT NULL,
  `order_id` INT(11) NOT NULL,
foreign key(`order_id`) references orders(`order_id`),
  `item_description` TEXT NULL DEFAULT NULL,
  `width` FLOAT NULL DEFAULT NULL,
  `length`FLOAT NULL DEFAULT NULL,
  `height` FLOAT NULL DEFAULT NULL,
  `entity` VARCHAR(45) NULL DEFAULT NULL,
  `materialtype` VARCHAR(45) NULL DEFAULT NULL,
  `price` FLOAT NULL DEFAULT NULL,
  `orderquantity` INT(11) NULL DEFAULT NULL,
  `versionnr` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`lineitems_id`, `order_id`),
  CONSTRAINT `deleteOrder`
    FOREIGN KEY (`order_id`)
    REFERENCES `orders` (`order_id`)
    ON DELETE CASCADE);

CREATE TABLE IF NOT EXISTS `fog`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(200) NULL DEFAULT NULL,
  `role` VARCHAR(45) NULL DEFAULT NULL,
  `securepassword` VARCHAR(45) NULL DEFAULT NULL,
  `salt` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`));
