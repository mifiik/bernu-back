CREATE TABLE IF NOT EXISTS customers
(
    id    BIGSERIAL PRIMARY KEY NOT NULL,
    email VARCHAR(256)          NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS customers_sequence START 101;

INSERT INTO customers(id, email)
VALUES (nextval('customers_sequence'), 'ivanov@mail.com'),
       (nextval('customers_sequence'), 'petrov@mail.com'),
       (nextval('customers_sequence'), 'sidorov@mail.com'),
       (nextval('customers_sequence'), 'pupkin@mail.com'),
       (nextval('customers_sequence'), 'mari_vana@mail.com');