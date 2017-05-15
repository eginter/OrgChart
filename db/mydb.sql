-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Employee` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Employee` (
  `idEmployee` INT NOT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `prevEmployee` INT NULL,
  `nextEmployee` INT NULL,
  `supervisor` INT NULL,
  PRIMARY KEY (`idEmployee`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`Employee`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Employee` (`idEmployee`, `firstName`, `lastName`, `prevEmployee`, `nextEmployee`, `supervisor`) VALUES (1, 'Elijah', 'Ginter', NULL, NULL, NULL);
INSERT INTO `mydb`.`Employee` (`idEmployee`, `firstName`, `lastName`, `prevEmployee`, `nextEmployee`, `supervisor`) VALUES (2, 'Joe', 'Smith', NULL, 3, 1);
INSERT INTO `mydb`.`Employee` (`idEmployee`, `firstName`, `lastName`, `prevEmployee`, `nextEmployee`, `supervisor`) VALUES (3, 'Tim', 'Cook', 2, NULL, 1);
INSERT INTO `mydb`.`Employee` (`idEmployee`, `firstName`, `lastName`, `prevEmployee`, `nextEmployee`, `supervisor`) VALUES (4, 'Sara', 'Brooks', NULL, 5, 2);
INSERT INTO `mydb`.`Employee` (`idEmployee`, `firstName`, `lastName`, `prevEmployee`, `nextEmployee`, `supervisor`) VALUES (5, 'Tom', 'Clark', 4, 6, 2);
INSERT INTO `mydb`.`Employee` (`idEmployee`, `firstName`, `lastName`, `prevEmployee`, `nextEmployee`, `supervisor`) VALUES (6, 'Sue', 'Thompson', NULL, 7, 3);
INSERT INTO `mydb`.`Employee` (`idEmployee`, `firstName`, `lastName`, `prevEmployee`, `nextEmployee`, `supervisor`) VALUES (7, 'Frank', 'Archer', 6, 8, 3);
INSERT INTO `mydb`.`Employee` (`idEmployee`, `firstName`, `lastName`, `prevEmployee`, `nextEmployee`, `supervisor`) VALUES (8, 'Ed', 'Alvarado', 7, NULL, 3);

COMMIT;

