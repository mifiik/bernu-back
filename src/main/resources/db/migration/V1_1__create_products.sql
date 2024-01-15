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
