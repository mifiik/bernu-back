CREATE TABLE deliveries
(
    id          BIGSERIAL PRIMARY KEY,
    order_id    BIGINT REFERENCES orders (id),
    customer_id BIGINT REFERENCES customers (id),
    address     VARCHAR(255) NOT NULL
);

ALTER SEQUENCE deliveries_id_seq RESTART WITH 100;

INSERT INTO deliveries (id, order_id, customer_id, address)
VALUES (01, 10, 01, 'Штефан  чел маре 1'),
       (02, 20, 02, 'Штефан  чел маре 1'),
       (03, 30, 03, 'Shtefan cel mare 2'),
       (04, 40, 04, 'Штефан  чел маре 5'),
       (05, 50, 05, 'Штефан  чел маре 5');
