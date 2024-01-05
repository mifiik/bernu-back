CREATE TABLE customer
(
    id    NUMERIC PRIMARY KEY,
    email VARCHAR(124) NOT NULL
);

CREATE SEQUENCE customer_sequence START WITH 100 INCREMENT BY 1;
SELECT NEXTVAL('customer_sequence');

INSERT INTO customer (id, email)
VALUES (01, 'test1@mail.ru'),
       (02, 'test2@mail.de'),
       (03, 'test3@mail.nl'),
       (04, 'test4@mail.ru'),
       (05, 'test5@mail.de');


CREATE TABLE delivery
(
    id          NUMERIC NOT NULL PRIMARY KEY,
    order_id    NUMERIC NOT NULL,
    customer_id NUMERIC NOT NULL,
    address     VARCHAR(255)
);

CREATE SEQUENCE delivery_sequence START WITH 100 INCREMENT BY 1;
SELECT NEXTVAL('delivery_sequence');

INSERT INTO delivery (id, order_id, customer_id, address)
VALUES (01, 12345, 67890, 'Штефан  чел маре 1'),
       (02, 54321, 09876, 'Штефан  чел маре 1'),
       (03, 5426, 09874, 'Shtefan cel mare 2'),
       (04, 54321, 09876, 'Штефан  чел маре 5'),
       (05, 54321, 09876, 'Штефан  чел маре 5');



CREATE TABLE orders
(
    id         NUMERIC PRIMARY KEY,
    product_id NUMERIC NOT NULL,
    client_id  NUMERIC NOT NULL,
    price      NUMERIC NOT NULL
);

CREATE SEQUENCE order_sequence START WITH 100 INCREMENT BY 1;
SELECT NEXTVAL('order_sequence');

INSERT INTO orders(id, product_id, client_id, price)
VALUES (101, 300, 101, 1000),
       (201, 400, 101, 2000),
       (301, 500, 202, 3000),
       (401, 600, 505, 4000),
       (501, 700, 505, 5000);



CREATE TABLE product
(
    id       NUMERIC,
    name     VARCHAR(128),
    price    NUMERIC,
    discount NUMERIC
);

CREATE SEQUENCE product_sequence START WITH 100 INCREMENT BY 1;
SELECT NEXTVAL('product_sequence');

INSERT INTO product(id, name, price, discount)
VALUES (202, 'Samsung', 200, 20),
       (203, 'Volvo', 1000.0, 20),
       (204, 'Apple', 10000.0, 80),
       (205, 'BMW', 2000.0, 80),
       (206, 'Nokia', 3000.0, 30);
