CREATE TABLE IF NOT EXISTS orders
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    product_id BIGSERIAL             NOT NULL REFERENCES products (id),
    customer_id  BIGSERIAL             NOT NULL REFERENCES customers (id),
    price      BIGSERIAL             NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS orders_sequence START 101;

INSERT INTO orders(id, product_id, customerId, price)
VALUES (nextval('orders_sequence'), 101, 101, 100),
       (nextval('orders_sequence'), 102, 102, 200),
       (nextval('orders_sequence'), 103, 103, 300),
       (nextval('orders_sequence'), 104, 104, 400),
       (nextval('orders_sequence'), 105, 105, 500);

