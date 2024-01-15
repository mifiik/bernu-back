CREATE TABLE orders
(
    id          BIGSERIAL PRIMARY KEY,
    product_id  BIGINT REFERENCES products (id),
    customer_id BIGINT REFERENCES customers (id),
    price       NUMERIC NOT NULL
);

ALTER SEQUENCE orders_id_seq RESTART WITH 100;

INSERT INTO orders(id, product_id, customer_id, price)
VALUES (10, 202, 01, 1000),
       (20, 203, 02, 2000),
       (30, 204, 03, 3000),
       (40, 205, 04, 4000),
       (50, 206, 05, 5000);