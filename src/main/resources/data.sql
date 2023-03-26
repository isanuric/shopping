INSERT INTO users (email, password) VALUES
('max@example.com', 'password123'),
('maria@example.com', 'password456'),
('peter@example.com', 'password789'),
('julia@example.com', 'password010'),
('alex@example.com', 'password011');

INSERT INTO products (name, price, order_date, user_id) VALUES
('Karotten', 1.99, NOW(), 1),
('Tomaten', 2.49, NOW(), 1),
('Gurken', 1.79, NOW(), 2),
('Zucchini', 3.29, NOW(), 2),
('Brokkoli', 2.99, NOW(), 3),
('Blumenkohl', 2.69, NOW(), 3),
('Spinat', 1.99, NOW(), 4),
('Kürbis', 2.99, NOW(), 4),
('Spargel', 4.99, NOW(), 5),
('Lauch', 1.49, NOW(), 5);