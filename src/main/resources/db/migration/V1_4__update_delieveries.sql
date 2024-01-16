ALTER TABLE deliveries
    ADD required_fields BOOLEAN,
    ADD city            VARCHAR(255) NOT NULL DEFAULT 'migrated',
    ADD street          VARCHAR(255) NOT NULL DEFAULT 'migrated',
    ADD postcode        NUMERIC      NOT NULL DEFAULT 1,
    ADD text_area       VARCHAR(255),
    ADD delivery_price  NUMERIC      NOT NULL DEFAULT 1,
    ADD discount        NUMERIC      NOT NULL DEFAULT 1,
    ADD total_amount    NUMERIC      NOT NULL DEFAULT 1;

ALTER TABLE deliveries
    DROP COLUMN customer_id,
    DROP COLUMN address;

UPDATE deliveries
SET required_fields = true
WHERE id IN (1, 3, 5);
UPDATE deliveries
SET required_fields = false
WHERE id IN (2, 4);

UPDATE deliveries
SET city = 'London'
WHERE id = 1;
UPDATE deliveries
SET city = 'Paris'
WHERE id = 2;
UPDATE deliveries
SET city = 'Berlin'
WHERE id = 3;
UPDATE deliveries
SET city = 'Prague'
WHERE id = 4;
UPDATE deliveries
SET city = 'Street Prague'
WHERE id = 5;

UPDATE deliveries
SET street = 'Brick Lane'
WHERE id = 1;
UPDATE deliveries
SET street = 'Champs-Élysées'
WHERE id = 2;
UPDATE deliveries
SET street = 'Unter den Linden'
WHERE id = 3;
UPDATE deliveries
SET street = 'Street Prague'
WHERE id = 4;
UPDATE deliveries
SET street = 'Alexander Strasse'
WHERE id = 5;

UPDATE deliveries
SET postcode = 3100
WHERE id = 1;
UPDATE deliveries
SET postcode = 4100
WHERE id = 2;
UPDATE deliveries
SET postcode = 5100
WHERE id = 3;
UPDATE deliveries
SET postcode = 6100
WHERE id = 4;
UPDATE deliveries
SET postcode = 7100
WHERE id = 5;

UPDATE deliveries
SET text_area = 'Lorem ipsum dolor sit amet';

UPDATE deliveries
SET delivery_price = 25
WHERE id = 1;
UPDATE deliveries
SET delivery_price = 32
WHERE id = 2;
UPDATE deliveries
SET delivery_price = 15
WHERE id = 3;
UPDATE deliveries
SET delivery_price = 60
WHERE id = 4;
UPDATE deliveries
SET delivery_price = 40
WHERE id = 5;

UPDATE deliveries
SET discount = 5
WHERE id = 1;
UPDATE deliveries
SET discount = 3
WHERE id = 2;
UPDATE deliveries
SET discount = 7
WHERE id = 3;
UPDATE deliveries
SET discount = 9
WHERE id = 4;
UPDATE deliveries
SET discount = 15
WHERE id = 5;

UPDATE deliveries
SET total_amount = 100
WHERE id = 1;
UPDATE deliveries
SET total_amount = 200
WHERE id = 2;
UPDATE deliveries
SET total_amount = 300
WHERE id = 3;
UPDATE deliveries
SET total_amount = 400
WHERE id = 4;
UPDATE deliveries
SET total_amount = 500
WHERE id = 5;
