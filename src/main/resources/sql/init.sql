CREATE TABLE customers
(
    id                 NUMERIC PRIMARY KEY,
    image_url          VARCHAR(254) NOT NULL,
    law_entity         BOOLEAN      NOT NULL,
    email              VARCHAR(124) NOT NULL,
    phone_country_code NUMERIC      NOT NULL,
    phone_number       NUMERIC      NOT NULL,
    first_name         VARCHAR(128) NOT NULL,
    last_name          VARCHAR(128) NOT NULL,
    password           VARCHAR(256) NOT NULL,
    city               VARCHAR(124) NOT NULL,
    street             VARCHAR(124) NOT NULL,
    city_index         NUMERIC      NOT NULL
);

CREATE SEQUENCE customers_sequence START WITH 100 INCREMENT BY 1;


INSERT INTO customers (id, image_url, law_entity,
                       email, phone_country_code, phone_number,
                       first_name, last_name, password, city, street, city_index)
VALUES (01, 'image_url_1', true, 'test1@mail.ru', 373, 79652796,
        'Oleg', 'Bogdanov', 'as123456', 'Balti', 'Stefan cel Mare 12', 3100),
       (02, 'image_url_2', false, 'test2@mail.ru', 490, 79645777,
        'Albert', 'Muller', 'df456789', 'Dortmund', 'Oberst Strasse 10', 4500),
       (03, 'image_url_1', true, 'test1@mail.ru', 373, 79652796,
        'Oleg', 'Bogdanov', 'as123456', 'Balti', 'Stefan cel Mare 12', 3100),
       (04, 'image_url_1', true, 'test1@mail.ru', 373, 79652796,
        'Oleg', 'Bogdanov', 'as123456', 'Balti', 'Stefan cel Mare 12', 3100),
       (05, 'image_url_1', true, 'test1@mail.ru', 373, 79652796,
        'Oleg', 'Bogdanov', 'as123456', 'Balti', 'Stefan cel Mare 12', 3100);


CREATE TABLE product
(
    id       NUMERIC PRIMARY KEY,
    name     VARCHAR(128) NOT NULL,
    price    NUMERIC      NOT NULL,
    discount NUMERIC      NOT NULL
);

CREATE SEQUENCE product_sequence START WITH 100 INCREMENT BY 1;


INSERT INTO product(id, name, price, discount)
VALUES (202, 'Samsung', 200, 20),
       (203, 'Volvo', 1000.0, 20),
       (204, 'Apple', 10000.0, 80),
       (205, 'BMW', 2000.0, 80),
       (206, 'Nokia', 3000.0, 30);



CREATE TABLE orders
(
    id          NUMERIC PRIMARY KEY,
    product_id  NUMERIC REFERENCES product (id),
    customer_id NUMERIC REFERENCES customers (id),
    price       NUMERIC NOT NULL
);

CREATE SEQUENCE order_sequence START WITH 100 INCREMENT BY 1;


INSERT INTO orders(id, product_id, customer_id, price)
VALUES (101, 202, 01, 1000),
       (201, 203, 02, 2000),
       (301, 204, 03, 3000),
       (401, 205, 04, 4000),
       (501, 206, 05, 5000);


CREATE TABLE delivery
(
    id          NUMERIC      NOT NULL PRIMARY KEY,
    order_id    NUMERIC REFERENCES orders (id),
    customer_id NUMERIC REFERENCES customers (id),
    address     VARCHAR(255) NOT NULL
);

CREATE SEQUENCE delivery_sequence START WITH 100 INCREMENT BY 1;


INSERT INTO delivery (id, order_id, customer_id, address)
VALUES (01, 101, 01, 'Штефан  чел маре 1'),
       (02, 201, 02, 'Штефан  чел маре 1'),
       (03, 301, 03, 'Shtefan cel mare 2'),
       (04, 401, 04, 'Штефан  чел маре 5'),
       (05, 501, 05, 'Штефан  чел маре 5');







