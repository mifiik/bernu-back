CREATE TABLE promotions
(
    id                    BIGSERIAL PRIMARY KEY,
    image_url             VARCHAR(254)  NOT NULL,
    promotion_name        VARCHAR(128)  NOT NULL,
    promotion_description VARCHAR(1024) NOT NULL,
    is_promotion_actual   BOOLEAN       NOT NULL
);

INSERT INTO promotions(image_url, promotion_name, promotion_description, is_promotion_actual)
VALUES ('image_url_1', 'promotion_name_1', 'description_1', true),
       ('image_url_2', 'promotion_name_2', 'description_2', false),
       ('image_url_3', 'promotion_name_3', 'description_3', true),
       ('image_url_4', 'promotion_name_4', 'description_4', false),
       ('image_url_5', 'promotion_name_5', 'description_5', true);
