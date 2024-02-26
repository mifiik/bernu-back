CREATE TABLE catalogs
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL
);

INSERT INTO catalogs(name)
VALUES ('Детская комната'),
       ('Игрушки и игры');