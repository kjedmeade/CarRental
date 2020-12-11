-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema rentaldb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `rentaldb` ;

-- -----------------------------------------------------
-- Schema rentaldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rentaldb` DEFAULT CHARACTER SET utf8 ;
USE `rentaldb` ;

-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `credit_card` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `car`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `car` ;

CREATE TABLE IF NOT EXISTS `car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rental`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rental` ;

CREATE TABLE IF NOT EXISTS `rental` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATETIME NULL DEFAULT NULL,
  `start_time` VARCHAR(45) NULL DEFAULT 'null',
  `end_date` DATETIME NULL DEFAULT NULL,
  `end_time` VARCHAR(45) NULL DEFAULT 'null',
  `car_id` INT NOT NULL DEFAULT 1,
  `customer_id` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_rental2_car_idx` (`car_id` ASC),
  INDEX `fk_rental2_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_rental2_car`
    FOREIGN KEY (`car_id`)
    REFERENCES `car` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rental2_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS rentaluser;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'rentaluser' IDENTIFIED BY 'rentaluser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'rentaluser';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `customer`
-- -----------------------------------------------------
START TRANSACTION;
USE `rentaldb`;
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `credit_card`) VALUES (1, 'Mary', 'May', '0000-000-0000');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `credit_card`) VALUES (2, 'Gred', 'Fray', '1111-111-1111');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `credit_card`) VALUES (3, 'Henry', 'Lou', '2222-222-2222');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `credit_card`) VALUES (4, 'Greg', 'May', '3333-333-3333');

COMMIT;


-- -----------------------------------------------------
-- Data for table `car`
-- -----------------------------------------------------
START TRANSACTION;
USE `rentaldb`;
INSERT INTO `car` (`id`, `type`) VALUES (1, 'Sedan');
INSERT INTO `car` (`id`, `type`) VALUES (2, 'Sedan');
INSERT INTO `car` (`id`, `type`) VALUES (3, 'Sedan');
INSERT INTO `car` (`id`, `type`) VALUES (4, 'Sedan');
INSERT INTO `car` (`id`, `type`) VALUES (5, 'Suv');
INSERT INTO `car` (`id`, `type`) VALUES (6, 'Suv');
INSERT INTO `car` (`id`, `type`) VALUES (7, 'Suv');
INSERT INTO `car` (`id`, `type`) VALUES (8, 'Van');
INSERT INTO `car` (`id`, `type`) VALUES (9, 'Van');
INSERT INTO `car` (`id`, `type`) VALUES (10, 'Van');

COMMIT;


-- -----------------------------------------------------
-- Data for table `rental`
-- -----------------------------------------------------
START TRANSACTION;
USE `rentaldb`;
INSERT INTO `rental` (`id`, `start_date`, `start_time`, `end_date`, `end_time`, `car_id`, `customer_id`) VALUES (1, '2020-09-09', '9:00', '2020-09-10', '10:00', 1, 1);
INSERT INTO `rental` (`id`, `start_date`, `start_time`, `end_date`, `end_time`, `car_id`, `customer_id`) VALUES (2, '2020-09-08', '10:00', '2020-09-11', '11:00', 1, 1);

COMMIT;

