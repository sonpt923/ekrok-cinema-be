CREATE SCHEMA `user-service`;

USE
`user-service`;

CREATE TABLE `user-service`.`user`
(
    `id`         BIGINT      NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(45) NOT NULL,
    `last_name`  VARCHAR(45) NOT NULL,
    `first_name` VARCHAR(45) NOT NULL,
    `birth_day`  TIMESTAMP   NOT NULL,
    `created_by` VARCHAR(45) NOT NULL,
    `created_at` TIMESTAMP   NOT NULL,
    `updated_by` VARCHAR(45) NULL,
    `updated_at` TIMESTAMP NULL,
    `deleted_at` TIMESTAMP NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);


CREATE TABLE `user-service`.`ap_domain`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT,
    `type`        VARCHAR(45)  NOT NULL,
    `code`        VARCHAR(45)  NOT NULL,
    `name`        VARCHAR(45)  NOT NULL,
    `status`      INT          NOT NULL,
    `value`       VARCHAR(45)  NOT NULL,
    `parent_id`   BIGINT NULL,
    `updated_at`  TIMESTAMP NULL,
    `updated_by`  VARCHAR(45) NULL,
    `created_at`  TIMESTAMP    NOT NULL,
    `created_by`  VARCHAR(45)  NOT NULL,
    `description` VARCHAR(145) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);

CREATE TABLE `user-service`.`group`
(
    `id`         BIGINT      NOT NULL AUTO_INCREMENT,
    `code`       VARCHAR(45) NOT NULL,
    `name`       VARCHAR(45) NOT NULL,
    `status`     INT         NOT NULL,
    `updated_at` TIMESTAMP NULL,
    `updated_by` VARCHAR(45) NULL,
    `created_at` TIMESTAMP   NOT NULL,
    `created_by` VARCHAR(45) NOT NULL,
    `deleted_at` TIMESTAMP   NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);
CREATE TABLE group_user
(
    `id`         BIGINT       NOT NULL AUTO_INCREMENT,
    `user_group` BIGINT       NOT NULL,
    `user`       BIGINT       NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `created_by` VARCHAR(255) NOT NULL,
    `updated_at` TIMESTAMP    NOT NULL,
    `updated_by` VARCHAR(45),
    `deleted_at` TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);