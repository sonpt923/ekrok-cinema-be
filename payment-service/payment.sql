-- 1. Bảng payment_method
CREATE TABLE payment_method
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    code       VARCHAR(50)  NOT NULL UNIQUE, -- e.g. 'VNPAY', 'MOMO', 'STRIPE'
    name       VARCHAR(100) NOT NULL,        -- human-readable
    config     JSON,                         -- cấu hình (API key, secret…)
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 2. Bảng payment (giao dịch chính)
-- 'PENDING','PROCESSING','SUCCESS','FAILED','REFUNDED'
CREATE TABLE payment
(
    id              CHAR(36) PRIMARY KEY,              -- UUID
    user_id         BIGINT         NOT NULL,           -- FK sang user-service (không enforce FK trên DB)
    amount          DECIMAL(14, 2) NOT NULL,
    currency        CHAR(3)        NOT NULL,
    status          INT            NOT NULL,
    method_id       BIGINT         NOT NULL,           -- FK → payment_method.id
    attempt_count   INT            NOT NULL DEFAULT 0, -- số lần retry
    last_error_code VARCHAR(50),                       -- lỗi cuối (nếu có)
    created_at      DATETIME                DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX           idx_status (status),
    INDEX           idx_user (user_id),
    CONSTRAINT fk_payment_method FOREIGN KEY (method_id)
        REFERENCES payment_method (id)
);

-- 3. Bảng transaction_log (ghi lại mọi bước)
-- 'CREATED','REQUEST_SENT','CALLBACK_RECEIVED','STATUS_UPDATED','RETRY','ERROR'
CREATE TABLE transaction_log
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    payment_id CHAR(36) NOT NULL, -- FK → payment.id
    event_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    event_type INT NOT NULL,
    detail     JSON,              -- chi tiết payload, error message…
    INDEX      idx_payment_event (payment_id, event_type),
    CONSTRAINT fk_log_payment FOREIGN KEY (payment_id)
        REFERENCES payment (id)
);

-- 4. Bảng refund (hoàn tiền)
-- 'REQUESTED','PROCESSING','SUCCESS','FAILED'
CREATE TABLE refund
(
    id         CHAR(36) PRIMARY KEY,    -- UUID
    payment_id CHAR(36)       NOT NULL, -- FK → payment.id
    amount     DECIMAL(14, 2) NOT NULL,
    status     INT            NOT NULL,
    reason     VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_refund_payment FOREIGN KEY (payment_id)
        REFERENCES payment (id)
);
