CREATE TABLE IF NOT EXISTS products
(
    id       BIGSERIAL PRIMARY KEY NOT NULL,
    name     VARCHAR(128)          NOT NULL,
    price    REAL                  NOT NULL,
    discount INT                   NOT NULL DEFAULT 0
);

CREATE SEQUENCE IF NOT EXISTS products_sequence START 101;

INSERT INTO products(id, name, price, discount)
VALUES (nextval('products_sequence'), 'Трусы', 100.00, 10),
       (nextval('products_sequence'), 'Носки', 200.00, 20),
       (nextval('products_sequence'), 'Майка', 300.00, 30),
       (nextval('products_sequence'), 'Каска', 400.00, 40),
       (nextval('products_sequence'), 'Пулемёт', 500.00, 50);