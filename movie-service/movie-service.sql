CREATE SCHEMA `movie-service`;

CREATE TABLE `movie-service`.`cast`
(
    `id`           BIGINT       NOT NULL AUTO_INCREMENT,
    `code`         VARCHAR(45)  NOT NULL,
    `name`         VARCHAR(45)  NOT NULL,
    `image`        VARCHAR(145) NOT NULL,
    `gender`       INT          NOT NULL,
    `biography`    TEXT         NOT NULL,
    `birth_date`   DATE         NOT NULL,
    `status`       INT          NOT NULL,
    `created_time` TIMESTAMP    NOT NULL default NOW(),
    `created_by`   VARCHAR(45)  NOT NULL,
    `updated_time` TIMESTAMP NULL,
    `updated_by`   VARCHAR(45) NULL,
    `is_deleted`   BOOLEAN      NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE
);


CREATE TABLE `movie-service`.`genre`
(
    `id`           BIGINT      NOT NULL AUTO_INCREMENT,
    `code`         VARCHAR(45) NOT NULL,
    `name`         VARCHAR(45) NOT NULL,
    `created_time` TIMESTAMP   NOT NULL default NOW(),
    `created_by`   VARCHAR(45) NOT NULL,
    `updated_time` TIMESTAMP NULL,
    `updated_by`   VARCHAR(45) NULL,
    `is_deleted`   BOOLEAN     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE
);

CREATE TABLE `movie-service`.`movie`
(
    `id`              BIGINT       NOT NULL AUTO_INCREMENT,
    `code`            VARCHAR(45)  NOT NULL,
    `title`           VARCHAR(45)  NOT NULL,
    `poster`          VARCHAR(145) NOT NULL,
    `trailer`         VARCHAR(145) NOT NULL,
    `age_restriction` INT          NOT NULL,
    `duration`        INT          NOT NULL,
    `country`         VARCHAR(45)  NOT NULL,
    `language`        VARCHAR(45)  NOT NULL,
    `type`            VARCHAR(45)  NOT NULL,
    `status`          INT          NOT NULL,
    `release_date`    DATE         NOT NULL,
    `created_time`    TIMESTAMP    NOT NULL default NOW(),
    `created_by`      VARCHAR(45)  NOT NULL,
    `updated_time`    TIMESTAMP NULL,
    `updated_by`      VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);



CREATE TABLE `movie-service`.`movie_genre`
(
    `id`       BIGINT NOT NULL AUTO_INCREMENT,
    `id_movie` BIGINT NOT NULL,
    `id_genre` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX      `FK_MG_G_idx` (`id_genre` ASC) VISIBLE,
    INDEX      `FK_MG_M_idx` (`id_movie` ASC) VISIBLE,
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);

CREATE TABLE `movie-service`.`movie_role`
(
    `id`           BIGINT      NOT NULL AUTO_INCREMENT,
    `id_movie`     BIGINT      NOT NULL,
    `id_people`    BIGINT      NOT NULL,
    `role`         INT         NOT NULL,
    `created_time` TIMESTAMP   NOT NULL default NOW(),
    `created_by`   VARCHAR(45) NOT NULL,
    `updated_time` TIMESTAMP NULL,
    `updated_by`   VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX          `FK_MORO_MOVIE_idx` (`id_movie` ASC) VISIBLE,
    INDEX          `FK_MORO_PEOPLE_idx` (`id_people` ASC) VISIBLE
);

CREATE TABLE `movie-service`.`season`
(
    `id`            BIGINT      NOT NULL AUTO_INCREMENT,
    `movie_id`      BIGINT      NOT NULL,
    `season_number` BIGINT      NOT NULL,
    `description`   TEXT NULL,
    `release_date`  DATE        NOT NULL,
    `created_at`    TIMESTAMP   NOT NULL,
    `created_by`    VARCHAR(45) NOT NULL,
    `updated_at`    VARCHAR(45) NULL,
    `updated_by`    DATE NULL,
    `is_deleted`    TINYINT     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);


CREATE TABLE `movie-service`.`episode`
(
    `id`             BIGINT      NOT NULL AUTO_INCREMENT,
    `season_id`      BIGINT      NOT NULL,
    `episode_number` BIGINT      NOT NULL,
    `title`          VARCHAR(45) NOT NULL,
    `description`    TEXT        NOT NULL,
    `duration`       BIGINT      NOT NULL,
    `release_date`   DATE        NOT NULL,
    `created_by`     VARCHAR(45) NOT NULL,
    `created_at`     DATE        NOT NULL,
    `updated_at`     DATE        NOT NULL,
    `updated_by`     VARCHAR(45) NOT NULL,
    `is_deleted`     TINYINT     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);

CREATE TABLE `movie-service`.`role`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `code`        VARCHAR(45) NOT NULL,
    `name`        VARCHAR(45) NOT NULL,
    `description` TEXT        NOT NULL,
    `created_at`  DATE        NOT NULL,
    `updated_at`  VARCHAR(45) NULL,
    `created_by`  DATE        NOT NULL,
    `updated_by`  VARCHAR(45) NULL,
    `is_deleted`  TINYINT     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE
);


CREATE TABLE `movie-service`.`movie_role`
(
    `id`             BIGINT NOT NULL AUTO_INCREMENT,
    `cast_id`        BIGINT NOT NULL,
    `movie_id`       BIGINT NOT NULL,
    `role_id`        BIGINT NOT NULL,
    `character_name` VARCHAR(145) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);
