CREATE TABLE order_status
(
    id          BIGSERIAL PRIMARY KEY,
    status_name VARCHAR(128) NOT NULL
);

INSERT INTO order_status(status_name)
VALUES ('CREATED'),
       ('COMPLETED'),
       ('IN PROGRESS');