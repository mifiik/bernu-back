CREATE TABLE customers
(
    id    NUMERIC PRIMARY KEY,
    email VARCHAR(124) NOT NULL
);

CREATE SEQUENCE customers_sequence START WITH 100 INCREMENT BY 1;


INSERT INTO customers (id, email)
VALUES (01, 'test1@mail.ru'),
       (02, 'test2@mail.de'),
       (03, 'test3@mail.nl'),
       (04, 'test4@mail.ru'),
       (05, 'test5@mail.de');


CREATE TABLE products
(
    id               NUMERIC PRIMARY KEY,
    primary_price    NUMERIC       NOT NULL,
    current_price    NUMERIC       NOT NULL,
    is_new           BOOLEAN       NOT NULL,
    image_url        VARCHAR(1024) NOT NULL,
    description      VARCHAR(512)  NOT NULL,
    minDelivery_days NUMERIC       NOT NULL,
    maxDelivery_days NUMERIC       NOT NULL,
    rating           NUMERIC       NOT NULL,
    review_count     NUMERIC       NOT NULL
);

CREATE SEQUENCE products_sequence START WITH 100 INCREMENT BY 1;


INSERT INTO products(id, primary_price, current_price,
                     is_new, image_url, description, minDelivery_days,
                     maxDelivery_days, rating, review_count)
VALUES (202, 100, 1000, true, 'image_url_1', 'Description 1', 1, 1, 5.0, 10),
       (203, 200, 2000, false, 'image_url_2', 'Description 2', 1, 3, 4.2, 15),
       (204, 300, 3000, true, 'image_url_3', 'Description 3', 1, 5, 4.0, 20),
       (205, 400, 4000, false, 'image_url_4', 'Description 4', 1, 2, 3.5, 12),
       (206, 500, 5000, false, 'image_url_5', 'Description 5', 1, 7, 2.0, 18);



CREATE TABLE orders
(
    id          NUMERIC PRIMARY KEY,
    product_id  NUMERIC REFERENCES products (id),
    customer_id NUMERIC REFERENCES customers (id),
    price       NUMERIC(0, 200) NOT NULL
);

CREATE SEQUENCE orders_sequence START WITH 100 INCREMENT BY 1;


INSERT INTO orders(id, product_id, customer_id, price)
VALUES (101, 202, 01, 1000),
       (201, 203, 02, 2000),
       (301, 204, 03, 3000),
       (401, 205, 04, 4000),
       (501, 206, 05, 5000);


CREATE TABLE deliveries
(
    id          NUMERIC      NOT NULL PRIMARY KEY,
    order_id    NUMERIC REFERENCES orders (id),
    customer_id NUMERIC REFERENCES customers (id),
    address     VARCHAR(255) NOT NULL
);

CREATE SEQUENCE delivery_sequence START WITH 100 INCREMENT BY 1;


INSERT INTO deliveries (id, order_id, customer_id, address)
VALUES (01, 101, 01, 'Штефан  чел маре 1'),
       (02, 201, 02, 'Штефан  чел маре 1'),
       (03, 301, 03, 'Shtefan cel mare 2'),
       (04, 401, 04, 'Штефан  чел маре 5'),
       (05, 501, 05, 'Штефан  чел маре 5');







