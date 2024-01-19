ALTER TABLE orders
    DROP COLUMN product_id;

CREATE TABLE xref_order_2_products
(
    id         BIGSERIAL PRIMARY KEY,
    order_id   BIGINT REFERENCES orders (id),
    product_id BIGINT REFERENCES products (id)
);

INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (10, 202);
INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (10, 203);
INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (10, 204);
INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (10, 205);

INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (20, 202);

INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (30, 203);
INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (30, 204);

INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (40, 205);
INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (40, 204);
INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (40, 203);
INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (40, 202);

INSERT INTO xref_order_2_products (order_id, product_id)
VALUES (40, 207);



