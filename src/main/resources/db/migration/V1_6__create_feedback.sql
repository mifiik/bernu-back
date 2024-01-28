CREATE TABLE feedbacks
(
    id            BIGSERIAL PRIMARY KEY,
    customer_id   BIGINT REFERENCES customers (id),
    product_id    BIGINT REFERENCES products (id),
    creation_dt   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    caption       VARCHAR(255) NOT NULL,
    feedback_text VARCHAR(255) NOT NULL,
    rating        NUMERIC      NOT NULL
);

INSERT INTO feedbacks(customer_id, product_id, caption, feedback_text, rating)
VALUES (01, 202, 'Great product!', 'I really loved this product. It exceeded my expectations.', 4),
       (02, 203, 'Not satisfied', 'The product did not meet my expectations. Disappointed.', 2),
       (03, 204, 'Excellent service', 'The customer service was exceptional. Quick and helpful.', 5),
       (04, 205, 'Average', 'The product was okay, but there is room for improvement.', 3);


