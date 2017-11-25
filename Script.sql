-- MySQL Script generated by MySQL Workbench
-- Sat Nov 25 16:56:49 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bootcamp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bootcamp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bootcamp` DEFAULT CHARACTER SET utf8 ;
USE `bootcamp` ;

-- -----------------------------------------------------
-- Table `bootcamp`.`atmosferas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`atmosferas` (
  `idatmosfera` INT(11) NOT NULL AUTO_INCREMENT,
  `humedad` INT(11) NULL DEFAULT NULL,
  `presion` DECIMAL(5,1) NULL DEFAULT NULL,
  `visibilidad` INT(11) NULL DEFAULT NULL,
  `ambiente_asc` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idatmosfera`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bootcamp`.`paises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`paises` (
  `idpais` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_alfa3` VARCHAR(3) NOT NULL,
  `cod_alfa2` VARCHAR(2) NOT NULL,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`idpais`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bootcamp`.`provincias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`provincias` (
  `idprovincia` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `abreviatura` VARCHAR(10) NULL DEFAULT NULL,
  `superficie` INT(11) NULL DEFAULT NULL,
  `capital` VARCHAR(45) NULL DEFAULT NULL,
  `idpais` INT(11) NOT NULL,
  PRIMARY KEY (`idprovincia`),
  INDEX `fk_provincia_pais_idx` (`idpais` ASC),
  CONSTRAINT `fk_provincia_pais`
    FOREIGN KEY (`idpais`)
    REFERENCES `bootcamp`.`paises` (`idpais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bootcamp`.`localidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`localidades` (
  `idlocalidad` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `idprovincia` INT(11) NOT NULL,
  PRIMARY KEY (`idlocalidad`),
  INDEX `fk_localidad_provincia_idx` (`idprovincia` ASC),
  CONSTRAINT `fk_localidad_provincia`
    FOREIGN KEY (`idprovincia`)
    REFERENCES `bootcamp`.`provincias` (`idprovincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bootcamp`.`vientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`vientos` (
  `idviento` INT(11) NOT NULL AUTO_INCREMENT,
  `velocidad` INT(11) NULL DEFAULT NULL,
  `direccion` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`idviento`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bootcamp`.`climas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcamp`.`climas` (
  `idclima` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL DEFAULT NULL,
  `temperatura` INT(11) NULL DEFAULT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  `idviento` INT(11) NOT NULL,
  `idatmosfera` INT(11) NOT NULL,
  `idlocalidad` INT(11) NOT NULL,
  `tempmin` INT(11) NULL DEFAULT NULL,
  `tempmax` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idclima`),
  INDEX `fk_clima_viento_idx` (`idviento` ASC),
  INDEX `fk_clima_atmosfera_idx` (`idatmosfera` ASC),
  INDEX `fk_clima_localidad_idx` (`idlocalidad` ASC),
  CONSTRAINT `fk_clima_atmosfera`
    FOREIGN KEY (`idatmosfera`)
    REFERENCES `bootcamp`.`atmosferas` (`idatmosfera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clima_localidad`
    FOREIGN KEY (`idlocalidad`)
    REFERENCES `bootcamp`.`localidades` (`idlocalidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clima_viento`
    FOREIGN KEY (`idviento`)
    REFERENCES `bootcamp`.`vientos` (`idviento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
