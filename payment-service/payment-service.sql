
-- 1. payment_intent: tạo intent khi user bắt đầu checkout
CREATE TABLE payment_intent
(
    id                 UUID PRIMARY KEY,
    saga_id            UUID NULL,                                             -- correlation với Camunda / subscription saga
    order_id           VARCHAR(64) NULL,                                      -- orderId từ subscription-service (không bắt buộc)
    user_id            VARCHAR(64)              NOT NULL,
    subscription_id    VARCHAR(64) NULL,                                      -- nếu intent do renew sinh ra
    plan_id            VARCHAR(64) NULL,
    amount             BIGINT                   NOT NULL,
    currency           VARCHAR(8)               NOT NULL,
    provider           VARCHAR(30)              NOT NULL,
    provider_intent_id VARCHAR(128) NULL,
    client_secret      TEXT NULL,
    checkout_url       TEXT NULL,
    status             VARCHAR(30)              NOT NULL,
    metadata           TEXT                     NOT NULL,
    created_at         TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at         TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    UNIQUE (provider, provider_intent_id)
);

-- 2. payment: actual capture/settlement events (one payment per provider notification)
CREATE TABLE payment
(
    id                  UUID PRIMARY KEY                  DEFAULT gen_random_uuid(),
    intent_id           UUID                     NOT NULL REFERENCES payment_intent (id) ON DELETE CASCADE,
    provider_payment_id VARCHAR(128) NULL,                 -- provider payment identifier
    amount              BIGINT                   NOT NULL,
    currency            VARCHAR(8)               NOT NULL,
    status              VARCHAR(30)              NOT NULL, -- PENDING | SUCCEEDED | FAILED | REFUNDED | CHARGEBACK
    failure_code        VARCHAR(64) NULL,
    failure_message     TEXT NULL,
    raw_payload         JSONB NULL,                        -- raw webhook payload (encrypted if sensitive)
    created_at          TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at          TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    UNIQUE (provider_payment_id)
);


-- 3. refund: refund requests and statuses
CREATE TABLE refund
(
    id                 UUID PRIMARY KEY                  DEFAULT gen_random_uuid(),
    payment_id         UUID                     NOT NULL REFERENCES payment (id) ON DELETE CASCADE,
    provider_refund_id VARCHAR(128) NULL,
    amount             BIGINT                   NOT NULL,
    currency           VARCHAR(8)               NOT NULL,
    status             VARCHAR(30)              NOT NULL, -- PENDING | SUCCEEDED | FAILED
    reason             VARCHAR(128) NULL,
    raw_payload        JSONB NULL,
    created_at         TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at         TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    UNIQUE (provider_refund_id)
);


-- 4. idempotency_key: đảm bảo idempotency cho endpoint tạo intent / refund / confirm
CREATE TABLE idempotency_key
(
    key            VARCHAR(128) PRIMARY KEY,                    -- client-supplied X-Idempotency-Key (could be uuid)
    request_hash   VARCHAR(128)             NOT NULL,           -- hash of request payload
    created_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    status         SMALLINT                 NOT NULL DEFAULT 0, -- 0=PENDING,1=COMPLETED,2=FAILED
    response_code  INTEGER NULL,
    response_body  JSONB NULL,
    owner          VARCHAR(64) NULL,                            -- optional: which endpoint/operation
    last_access_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);


-- 5. outbox: pattern transactional outbox for reliable event publishing
CREATE TABLE outbox
(
    id             BIGSERIAL PRIMARY KEY,
    aggregate_type VARCHAR(64)              NOT NULL,
    aggregate_id   UUID                     NOT NULL,
    event_type     VARCHAR(128)             NOT NULL,
    payload        JSONB                    NOT NULL,
    created_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    published      BOOLEAN                  NOT NULL DEFAULT false,
    published_at   TIMESTAMP WITH TIME ZONE NULL
);

-- 6. ledger_entry: simple double-entry ledger to trace money flows
CREATE TABLE ledger_entry
(
    id         BIGSERIAL PRIMARY KEY,
    entry_uuid UUID                              DEFAULT gen_random_uuid() UNIQUE,
    entry_type VARCHAR(10)              NOT NULL, -- DEBIT | CREDIT
    account    VARCHAR(64)              NOT NULL, -- CASH, REVENUE, REFUND_LIAB, FEES ...
    amount     BIGINT                   NOT NULL,
    currency   VARCHAR(8)               NOT NULL,
    ref_type   VARCHAR(32)              NOT NULL, -- PAYMENT | REFUND
    ref_id     UUID                     NOT NULL, -- payment.id or refund.id
    metadata   JSONB                             DEFAULT '{}'::jsonb,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);


-- 7. webhook_delivery: track incoming webhook attempts & verification outcome
CREATE TABLE webhook_delivery
(
    id                BIGSERIAL PRIMARY KEY,
    provider          VARCHAR(32)              NOT NULL,
    provider_event_id VARCHAR(128) NULL,                                   -- id from provider for the webhook
    endpoint          VARCHAR(128)             NOT NULL,                   -- e.g., /webhooks/momo
    payload           JSONB                    NOT NULL,
    headers           JSONB NULL,
    verified          BOOLEAN                  NOT NULL DEFAULT false,
    verify_result     TEXT NULL,
    processing_status VARCHAR(30)              NOT NULL DEFAULT 'PENDING', -- PENDING | PROCESSING | PROCESSED | FAILED
    attempts          INT                      NOT NULL DEFAULT 0,
    last_attempt_at   TIMESTAMP WITH TIME ZONE NULL,
    created_at        TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);


-- 9. subscription_payment_lock: lightweight lock record to avoid double renew race
CREATE TABLE subscription_payment_lock
(
    subscription_id VARCHAR(64) PRIMARY KEY,
    locked_at       TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    owner           VARCHAR(64) NULL
);
