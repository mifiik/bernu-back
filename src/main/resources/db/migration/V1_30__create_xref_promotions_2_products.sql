CREATE TABLE xref_promotions_2_products
(
    id           BIGSERIAL PRIMARY KEY,
    promotion_id BIGINT REFERENCES promotions (id),
    product_id   BIGINT REFERENCES products (id)
);
INSERT INTO xref_promotions_2_products(promotion_id, product_id)
VALUES (1, 301),
       (2, 302),
       (3, 303),
       (4, 304),
       (4, 305);
