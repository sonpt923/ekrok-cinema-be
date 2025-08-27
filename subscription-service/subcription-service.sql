CREATE SCHEMA `subcription-service`

CREATE TABLE `subcription-service`.`plan`
(
    `id`             BIGINT      NOT NULL AUTO_INCREMENT,
    `plan_parent_id` BIGINT NULL,
    `level`          INT NULL,
    `code`           VARCHAR(45) NOT NULL,
    `name`           VARCHAR(45) NULL,
    `description`    TEXT NULL,
    `price`          DECIMAL NULL,
    `currency`       VARCHAR(45) NULL,
    `duration`       BIGINT NULL,
    `max_device`     INT NULL,
    `quality`        VARCHAR(45) NULL,
    `resolution`     VARCHAR(45) NULL,
    `created_by`     VARCHAR(45) NOT NULL,
    `created_at`     VARCHAR(45) NOT NULL,
    `updated_by`     VARCHAR(45) NULL,
    `updated_at`     VARCHAR(45) NULL,
    `is_active`      BOOLEAN     NOT NULL,
    `is_deleted`     BOOLEAN     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE
);

CREATE TABLE `subcription-service`.`subcription`
(
    `id`                BIGINT      NOT NULL AUTO_INCREMENT,
    `user_id`           BIGINT      NOT NULL,
    `plan_id`           BIGINT      NOT NULL,
    `start_date`        VARCHAR(45) NOT NULL,
    `end_date`          VARCHAR(45) NOT NULL,
    `status`            INT         NOT NULL,
    `auto_renew`        TINYINT     NOT NULL,
    `next_billing_date` DATE NULL,
    `transaction_code`  VARCHAR(45) NOT NULL,
    `cancel_reason`     VARCHAR(45) NULL,
    `cancel_at`         TIMESTAMP   NOT NULL,
    `created_by`        VARCHAR(45) NOT NULL,
    `created_at`        TIMESTAMP NULL,
    `updated_by`        VARCHAR(45) NULL,
    `updated_at`        TIMESTAMP NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
) ENGINE = InnoDB
DEFAULT CHARACTER SET = cp1256;


CREATE TABLE `subcription-service`.`history`
(
    `id`             BIGINT      NOT NULL AUTO_INCREMENT,
    `subcription_id` BIGINT      NOT NULL,
    `action`         TEXT        NOT NULL,
    `actor`          VARCHAR(45) NOT NULL,
    `note`           VARCHAR(45) NOT NULL,
    `created_at`     TIMESTAMP   NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);
