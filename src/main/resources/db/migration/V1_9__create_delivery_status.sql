CREATE TABLE delivery_status
(
    id          BIGSERIAL PRIMARY KEY,
    status_name VARCHAR(128) NOT NULL
);
INSERT INTO delivery_status(status_name)

VALUES ('CREATED'),
       ('DELIVERY'),
       ('COMPLETED');
