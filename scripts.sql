SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema seniorteste
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `seniorteste` ;

-- -----------------------------------------------------
-- Schema seniorteste
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `seniorteste` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `seniorteste` ;

-- -----------------------------------------------------
-- Table `seniorteste`.`tbl_perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seniorteste`.`tbl_perfil` ;

CREATE TABLE IF NOT EXISTS `seniorteste`.`tbl_perfil` (
  `id_perfil` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_perfil` VARCHAR(255) NOT NULL,
  `sigla_perfil` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id_perfil`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `UK_nd1fy8h9lwhhkj5q3aw8gt0v9` ON `seniorteste`.`tbl_perfil` (`sigla_perfil` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `seniorteste`.`tbl_solicitacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seniorteste`.`tbl_solicitacao` ;

CREATE TABLE IF NOT EXISTS `seniorteste`.`tbl_solicitacao` (
  `id_solicitacao` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `solicitante_solicitacao` VARCHAR(64) NOT NULL,
  `desc_item_solicitacao` VARCHAR(256) NOT NULL,
  `email_solicitacao` VARCHAR(128) NOT NULL,
  `valor_solicitacao` DOUBLE NOT NULL,
  `dt_criacao_solicitacao` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dt_aprovado_solicitacao` DATETIME NULL DEFAULT NULL,
  `dt_reprovado_solicitacao` DATETIME NULL DEFAULT NULL,
  `motivo_reprovacao_solicitacao` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`id_solicitacao`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seniorteste`.`tbl_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seniorteste`.`tbl_usuario` ;

CREATE TABLE IF NOT EXISTS `seniorteste`.`tbl_usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `id_perfil` INT(11) NOT NULL,
  `nome_usuario` VARCHAR(255) NOT NULL,
  `email_usuario` VARCHAR(255) NOT NULL,
  `senha_usuario` VARCHAR(255) NOT NULL,
  `dt_criado_usuario` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dt_excluido_usuario` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `UK_l5vsky604kqs9xg7xb8uqjjxc` ON `seniorteste`.`tbl_usuario` (`email_usuario` ASC) VISIBLE;


-- -----------------------------------------------------
-- Data for table `seniorteste`.`tbl_perfil`
-- -----------------------------------------------------
START TRANSACTION;
USE `seniorteste`;
INSERT INTO `seniorteste`.`tbl_perfil` (`id_perfil`, `nome_perfil`, `sigla_perfil`) VALUES (1, 'Administração', 'ADM');
INSERT INTO `seniorteste`.`tbl_perfil` (`id_perfil`, `nome_perfil`, `sigla_perfil`) VALUES (2, 'Almoxarife', 'ALF');

COMMIT;


-- -----------------------------------------------------
-- Data for table `seniorteste`.`tbl_usuario`
-- -----------------------------------------------------
START TRANSACTION;
USE `seniorteste`;
INSERT INTO `seniorteste`.`tbl_usuario` (`id_usuario`, `id_perfil`, `nome_usuario`, `email_usuario`, `senha_usuario`, `dt_criado_usuario`, `dt_excluido_usuario`) VALUES (1, 2, 'Almoxarife', 'almoxarife@senior.com.br', '1234', DEFAULT, NULL);
INSERT INTO `seniorteste`.`tbl_usuario` (`id_usuario`, `id_perfil`, `nome_usuario`, `email_usuario`, `senha_usuario`, `dt_criado_usuario`, `dt_excluido_usuario`) VALUES (2, 1, 'Administração', 'administracao@senior.com.br', '1234', DEFAULT, NULL);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
