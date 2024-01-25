CREATE TABLE customers
(
    id    NUMERIC PRIMARY KEY,
    email VARCHAR(124) NOT NULL
);

CREATE SEQUENCE customer_sequence START WITH 100 INCREMENT BY 1;

INSERT INTO customers (id, email)
VALUES (nextval('products_sequence'), test1@mail.ru),
       (nextval('products_sequence'), test2@mail.ru),
       (nextval('products_sequence'), test3@mail.ru),
       (nextval('products_sequence'), test4@mail.ru),
       (nextval('products_sequence'), test5@mail.ru);

CREATE TABLE products
(
    id       NUMERIC PRIMARY KEY,
    name     VARCHAR(128) NOT NULL,
    price    NUMERIC      NOT NULL,
    discount NUMERIC      NOT NULL
);

CREATE SEQUENCE products_sequense START WITH 100 INCREMENT BY 1;

INSERT INTO products(id, name, price, discount)
VALUES (nextval('products_sequence'), 'Сигареты', 100.00, 5),
       (nextval('products_sequence'), 'Электронные-Сигареты', 200.00, 10),
       (nextval('products_sequence'), 'Кальян', 3000.00, 20),
       (nextval('products_sequence'), 'Трубка', 1400.00, 25),
       (nextval('products_sequence'), 'Бонг', 2000.00, 30);

CREATE TABLE orders
(
    id          NUMERIC PRIMARY KEY,
    product_id  NUMERIC REFERENCES products (id),
    customer_id NUMERIC REFERENCES customers (id),
    price       NUMERIC NOT NULL
);

CREATE SEQUENCE order_sequence START WITH 100 INCREMENT BY 1;

INSERT INTO orders(id, product_id, customer_id, price)
VALUES (nextval('orders_sequence'), 101, 101, 1000),
       (nextval('orders_sequence'), 102, 102, 2000),
       (nextval('orders_sequence'), 103, 103, 3000),
       (nextval('orders_sequence'), 104, 104, 4000),
       (nextval('orders_sequence'), 105, 105, 5000);

CREATE TABLE delivery
(
    id          NUMERIC      NOT NULL PRIMARY KEY,
    order_id    NUMERIC REFERENCES orders (id),
    customer_id NUMERIC REFERENCES customers (id),
    address     VARCHAR(255) NOT NULL
);

CREATE SEQUENCE delivery_sequence START WITH 100 INCREMENT BY 1;

INSERT INTO delivery (id, order_id, customer_id, address)
VALUES (nextval('delivery_sequence'), 101, 101, 'Ленина 2'),
       (nextval('delivery_sequence'), 102, 102, 'Луговая 4'),
       (nextval('delivery_sequence'), 103, 103, 'Поликахана 3'),
       (nextval('delivery_sequence'), 104, 104, 'Струве 9'),
       (nextval('delivery_sequence'), 105, 105, 'Куликова 38');