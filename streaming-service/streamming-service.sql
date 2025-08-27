CREATE SCHEMA `streamming-service`;

USE `streamming-service`

CREATE TABLE stream_session
(
    id              BIGINT PRIMARY KEY,
    user_id         BIGINT      NOT NULL,
    movie_id        BIGINT      NOT NULL,
    device_id       BIGINT      NOT NULL,
    initial_quality VARCHAR(20),
    started_at      TIMESTAMPTZ NOT NULL,
    ended_at        TIMESTAMPTZ,
    status          SMALLINT    NOT NULL,
    cdn_url         TEXT,
    created_at      TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at      TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_session_user ON stream_session (user_id);
CREATE INDEX idx_session_movie ON stream_session (movie_id);
CREATE INDEX idx_session_status ON stream_session (status);
CREATE INDEX idx_session_started ON stream_session (started_at);

-- 2) drm_license (multi-DRM / multi-issue per session)
CREATE TABLE drm_license
(
    id            BIGINT PRIMARY KEY,
    session_id    BIGINT       NOT NULL REFERENCES stream_session (id) ON DELETE CASCADE,
    drm_type      SMALLINT     NOT NULL,
    key_id        VARCHAR(100) NOT NULL,
    license_token TEXT         NOT NULL,
    status        SMALLINT     NOT NULL,
    issued_at     TIMESTAMPTZ  NOT NULL,
    expires_at    TIMESTAMPTZ
);
CREATE INDEX idx_drm_session ON drm_license (session_id);
CREATE INDEX idx_drm_key ON drm_license (key_id);


CREATE TABLE device_info
(
    id                 BIGINT PRIMARY KEY,
    user_id            BIGINT       NOT NULL,
    device_fingerprint VARCHAR(255) NOT NULL,
    device_type        SMALLINT     NOT NULL,
    os                 VARCHAR(50),
    app_version        VARCHAR(50),
    browser            VARCHAR(50),
    ip_address         INET,
    is_blocked         BOOLEAN      NOT NULL DEFAULT false,
    last_used          TIMESTAMPTZ,
    created_at         TIMESTAMPTZ  NOT NULL DEFAULT now(),
    updated_at         TIMESTAMPTZ  NOT NULL DEFAULT now(),
    UNIQUE (user_id, device_fingerprint)
);
CREATE INDEX idx_device_user ON device_info (user_id);
CREATE INDEX idx_device_last_used ON device_info (last_used);


CREATE TABLE stream_chunk_log
(
    event_date      Date,
    event_time      DateTime64(3, 'UTC'),
    session_id      UInt64,
    chunk_index     UInt32,
    bitrate_kbps    UInt32,
    latency_ms      UInt32,
    download_status LowCardinality(String),
    retry_count     UInt8,
    cdn_edge        LowCardinality(String),
    region          LowCardinality(String)
) ENGINE = MergeTree
PARTITION BY toYYYYMM(event_date)
ORDER BY (session_id, event_time);

CREATE TABLE bandwidth_stat
(
    event_date              Date,
    event_time              DateTime64(3, 'UTC'),
    session_id              UInt64,
    measured_bandwidth_kbps UInt32,
    chosen_repr             LowCardinality(String),
    buffer_level_s          UInt16,
    latency_ms              UInt32
) ENGINE = MergeTree
PARTITION BY toYYYYMM(event_date)
ORDER BY (session_id, event_time);
