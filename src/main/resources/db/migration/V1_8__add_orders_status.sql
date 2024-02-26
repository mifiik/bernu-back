ALTER
    TABLE orders
    ADD COLUMN status_id BIGINT REFERENCES order_status (id) NOT NULL DEFAULT 1;