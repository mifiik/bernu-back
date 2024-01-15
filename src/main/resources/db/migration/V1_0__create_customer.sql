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
