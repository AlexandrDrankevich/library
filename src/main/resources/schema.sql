CREATE TABLE  IF NOT EXISTS `Printing_Product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `author` VARCHAR(45) NULL,
  `publisher` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `release_Date` DATE NULL,
  PRIMARY KEY (`id`));