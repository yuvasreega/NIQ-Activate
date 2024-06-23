CREATE TABLE product (
    product_id VARCHAR(255) PRIMARY KEY,
    category VARCHAR(255),
    brand VARCHAR(255)
);

CREATE TABLE shopper (
    shopper_id VARCHAR(255) PRIMARY KEY
);

CREATE TABLE shopper_product_list (
    id SERIAL PRIMARY KEY,
    product_id VARCHAR(255) NOT NULL,
    shopper_id VARCHAR(255) NOT NULL,
    relevancy_score DECIMAL(10, 2),
    FOREIGN KEY (product_id) REFERENCES product(product_id),
    FOREIGN KEY (shopper_id) REFERENCES shopper(shopper_id)
);

CREATE INDEX idx_category ON product(category);

CREATE INDEX idx_shopper_id ON shopper(shopper_id);

CREATE INDEX idx_shopper_product_list_shopper_product ON shopper_product_list(shopper_id, product_id);

CREATE SEQUENCE shopper_product_list_id_seq START 1;

