ALTER
    TABLE deliveries
    ADD COLUMN status_id BIGINT NOT NULL DEFAULT 1 REFERENCES delivery_status (id);