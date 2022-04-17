CREATE TABLE IF NOT EXISTS book (
    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    author              varchar(255) NOT NULL,
    price               float8 NOT NULL,
    title               varchar(255) NOT NULL
    );