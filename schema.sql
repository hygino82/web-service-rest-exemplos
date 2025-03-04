CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO product(name, price) VALUES 
('TV', 900.45),
('Smartphone', 1500.00),
('Notebook', 3200.99),
('Mouse Gamer', 120.50),
('Teclado Mecânico', 350.00),
('Monitor 27"', 1299.99),
('Cadeira Gamer', 899.99),
('Headset', 250.75),
('Tablet', 1800.00),
('Impressora', 650.00);

