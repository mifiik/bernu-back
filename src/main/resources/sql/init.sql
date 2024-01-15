CREATE TABLE customers
(
    id                 BIGSERIAL PRIMARY KEY,
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

ALTER SEQUENCE customers_id_seq RESTART WITH 100;

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

CREATE TABLE products
(
    id                BIGSERIAL PRIMARY KEY,
    primary_price     NUMERIC      NOT NULL,
    current_price     NUMERIC      NOT NULL,
    discount          NUMERIC      NOT NULL,
    new_product       BOOLEAN,
    image_url         VARCHAR(128) NOT NULL,
    description       VARCHAR(128) NOT NULL,
    min_delivery_days NUMERIC      NOT NULL,
    max_delivery_days NUMERIC      NOT NULL,
    rating            NUMERIC      NOT NULL,
    review_count      NUMERIC      NOT NULL
);

ALTER SEQUENCE products_id_seq RESTART WITH 300;

INSERT INTO products(id, primary_price, current_price,
                     discount, new_product, image_url, description,
                     min_delivery_days, max_delivery_days, rating, review_count)
VALUES (202, 100, 999, 5, true, 'image_url_1', 'description_1', 1, 10, 4.5, 1),
       (203, 200, 555, 4, false, 'image_url_2', 'description_2', 5, 20, 3.2, 3),
       (204, 300, 777, 3, true, 'image_url_3', 'description_3', 2, 7, 1.7, 4),
       (205, 400, 888, 6, false, 'image_url_4', 'description_4', 3, 9, 2.8, 10),
       (206, 500, 999, 10, true, 'image_url_5', 'description_5', 7, 12, 3.2, 7),
       (207, 600, 333, 8, false, 'image_url_6', 'description_6', 10, 30, 4.9, 9);

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
