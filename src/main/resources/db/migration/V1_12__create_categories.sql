CREATE TABLE categories
(
    id                BIGSERIAL primary key,
    category_group_id BIGINT REFERENCES category_groups (id) NOT NULL DEFAULT 1,
    name              VARCHAR(128)                           NOT NULL
);

INSERT INTO categories(category_group_id, name)
VALUES (1, 'Простыни'),
       (1, 'Пледики'),
       (2, 'Пеленальные доски'),
       (2, 'Пеленальные матрасики'),
       (3, 'Куклы'),
       (3, 'Кукольные домики с мебелью'),
       (4, 'Машинки и мотоциклы'),
       (4, 'Железные дороги');