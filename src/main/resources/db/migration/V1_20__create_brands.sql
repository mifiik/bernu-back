CREATE TABLE brands
(
    id        BIGSERIAL PRIMARY KEY,
    image_url VARCHAR(254) NOT NULL,
    name      VARCHAR(254) NOT NULL
);

INSERT INTO brands(image_url, name)
VALUES ('image_url_1', 'Nike'),
       ('image_url_2', 'Etnilogy'),
       ('image_url_3', 'Lenium'),
       ('image_url_4', 'Adidas'),
       ('image_url_5', 'Adinol'),
       ('image_url_6', 'Beadi'),
       ('image_url_7', 'Nutrilon'),
       ('image_url_8', 'Nilenium'),
       ('image_url_9', 'Pukypu');



















