CREATE TABLE category_groups
(
    id         BIGSERIAL PRIMARY KEY,
    catalog_id BIGINT REFERENCES catalogs (id) NOT NULL,
    name       VARCHAR(128)                    NOT NULL

);

INSERT INTO category_groups(catalog_id, name)
VALUES (1, 'Постельное белье и принадлежности'),
       (1, 'Все для пеленания'),
       (2, 'Куклы и аксессуары'),
       (2, ' Игрушечный транспорт');