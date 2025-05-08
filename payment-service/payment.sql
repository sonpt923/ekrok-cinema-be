CREATE SCHEMA `payment-service`;

use
`payment-service`;

CREATE TABLE `payment-service`.`payment`
(
    `id`                     BIGINT NOT NULL AUTO_INCREMENT,
    `user_id`                BIGINT NULL,
    `subcription_id`         BIGINT NULL,
    `amount`                 DECIMAL NULL,
    `payment_method`         VARCHAR(45) NULL,
    `status`                 INT NULL COMMENT 'trạng thái của hệ thống nội bộ',
    `external_tx_id`         VARCHAR(145) NULL COMMENT 'mã giao dịch của bên thứ 3',
    `created_at`             TIMESTAMP NULL COMMENT 'thời gian tạo',
    `updated_at`             TIMESTAMP NULL COMMENT 'thời gian sửa lần cuối',
    `provider_status`        INT NULL COMMENT 'trạng thái trả về từ bên thứ 3',
    `provider_response_code` VARCHAR(145) NULL COMMENT 'code trả về của api bên thứ 3',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);

CREATE TABLE `payment-service`.`refunds`
(
    `id`            BIGINT       NOT NULL AUTO_INCREMENT,
    `payment_id`    BIGINT       NOT NULL,
    `refund_amount` DECIMAL      NOT NULL,
    `refund_reason` VARCHAR(200) NOT NULL,
    `status`        INT          NOT NULL,
    `created_at`    TIMESTAMP    NOT NULL,
    `updated_at`    TIMESTAMP NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);
