CREATE TABLE IF NOT EXISTS delivery
(
    id          BIGSERIAL PRIMARY KEY NOT NULL,
    order_id    BIGSERIAL             NOT NULL REFERENCES orders (id),
    customer_id BIGSERIAL             NOT NULL REFERENCES customers (id),
    address     VARCHAR(256)          NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS delivery_sequence START 101;

INSERT INTO delivery(id, order_id, customer_id, address)
VALUES (nextval('delivery_sequence'), 101, 101, 'Рябиновая'),
       (nextval('delivery_sequence'), 102, 102, 'Малиновая'),
       (nextval('delivery_sequence'), 103, 103, 'Клубничная'),
       (nextval('delivery_sequence'), 104, 104, 'Земляничная'),
       (nextval('delivery_sequence'), 105, 105, 'Виноградная');