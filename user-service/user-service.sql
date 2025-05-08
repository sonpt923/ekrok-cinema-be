CREATE SCHEMA `user-service`;

USE
`user-service`;

CREATE TABLE `user-service`.`user`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `username`    VARCHAR(45) NOT NULL,
    `provider`    VARCHAR(45) NOT NULL,
    `provider_id` BIGINT      NOT NULL,
    `last_name`   VARCHAR(45) NOT NULL,
    `first_name`  VARCHAR(45) NOT NULL,
    `email`       VARCHAR(45) NOT NULL,
    `phone`       VARCHAR(45) NOT NULL,
    `status`      INT       DEFAULT 1,
    `birth_day`   TIMESTAMP   NOT NULL,
    `created_by`  VARCHAR(45) NOT NULL,
    `created_at`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_by`  VARCHAR(45) NULL,
    `updated_at`  TIMESTAMP NULL,
    `deleted_at`  TIMESTAMP NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
    UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);


CREATE TABLE `user-service`.`ap_domain`
(
    `id`               BIGINT      NOT NULL AUTO_INCREMENT,
    `type`             VARCHAR(45) NOT NULL,
    `code`             VARCHAR(45) NOT NULL,
    `name`             VARCHAR(45) NOT NULL,
    `description`      TEXT NULL,
    `status`           INT         NOT NULL,
    `value`            VARCHAR(45) NOT NULL,
    `domain_parent_id` BIGINT NULL,
    `created_by`       VARCHAR(45) NOT NULL,
    `created_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_by`       VARCHAR(45) NULL,
    `updated_at`       TIMESTAMP NULL,
    `deleted_at`       TIMESTAMP NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `type_UNIQUE` (`type` ASC) VISIBLE,
    UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE
);

CREATE TABLE `user-service`.`group`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `code`        VARCHAR(45) NOT NULL,
    `name`        VARCHAR(45) NOT NULL,
    `description` VARCHAR(45) NULL,
    `status`      INT         NOT NULL,
    `updated_at`  TIMESTAMP NULL,
    `updated_by`  VARCHAR(45) NULL,
    `created_at`  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_by`  VARCHAR(45) NOT NULL,
    `deleted_at`  TIMESTAMP   NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE,
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
);

CREATE TABLE `user-service`.`group_user`
(
    `id`         BIGINT       NOT NULL AUTO_INCREMENT,
    `group_id`   BIGINT       NOT NULL,
    `user_id`    BIGINT       NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `created_by` VARCHAR(245) NOT NULL,
    `updated_at` TIMESTAMP NULL,
    `updated_by` VARCHAR(45),
    `deleted_at` TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);


CREATE TABLE `user-service`.`role`
(
    `id`             BIGINT      NOT NULL AUTO_INCREMENT,
    `code`           VARCHAR(45) NOT NULL,
    `name`           VARCHAR(45) NOT NULL,
    `description`    VARCHAR(45) NULL,
    `parent_role_id` BIGINT      NOT NULL,
    `status`         INT         NOT NULL,
    `updated_at`     TIMESTAMP NULL,
    `updated_by`     VARCHAR(45) NULL,
    `created_at`     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `created_by`     VARCHAR(45) NOT NULL,
    `deleted_at`     TIMESTAMP NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE,
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
);

CREATE TABLE `user-service`.`group_role`
(
    `id`         BIGINT       NOT NULL AUTO_INCREMENT,
    `group_id`   BIGINT       NOT NULL,
    `role_id`    BIGINT       NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `created_by` VARCHAR(245) NOT NULL,
    `updated_at` TIMESTAMP NULL,
    `updated_by` VARCHAR(45),
    `deleted_at` TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);