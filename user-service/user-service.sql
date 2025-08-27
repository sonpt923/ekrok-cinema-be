CREATE SCHEMA `user-service`;

CREATE TABLE `user-service`.`new_table`
(
    `id`         BIGINT       NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(45)  NOT NULL,
    `full_name`  VARCHAR(145) NOT NULL,
    `birth_day`  DATE         NOT NULL,
    `created_by` VARCHAR(45)  NOT NULL,
    `created_at` DATETIME     NOT NULL,
    `updated_by` VARCHAR(45) NULL,
    `updated_at` DATETIME NULL,
    `deleted_at` DATETIME NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);


CREATE TABLE `user-service`.`group`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `parent_id`   BIGINT      NOT NULL,
    `level`       BIGINT      NOT NULL,
    `code`        VARCHAR(45) NOT NULL,
    `name`        VARCHAR(45) NOT NULL,
    `description` VARCHAR(45) NULL,
    `status`      INT NULL,
    `created_by`  VARCHAR(45) NULL,
    `created_at`  TIMESTAMP NULL,
    `updated_by`  VARCHAR(45) NULL,
    `updated_at`  TIMESTAMP NULL,
    `is_deleted`  TIMESTAMP NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE,
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
);
