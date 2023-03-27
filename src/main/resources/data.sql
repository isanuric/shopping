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


INSERT INTO products (name, price, order_date, user_id)
VALUES
('Tomato', 2.99, '2023-03-26 10:30:00', 1),
('Cucumber', 1.49, '2023-03-26 11:45:00', 1),
('Carrot', 0.89, '2023-03-26 13:20:00', 2),
('Lettuce', 1.99, '2023-03-26 14:00:00', 2),
('Broccoli', 2.49, '2023-03-26 15:30:00', 3),
('Spinach', 2.99, '2023-03-26 16:15:00', 3),
('Pepper', 1.79, '2023-03-26 17:00:00', 4),
('Eggplant', 2.49, '2023-03-26 18:30:00', 5),
('Zucchini', 1.99, '2023-03-26 19:45:00', 5),
('Green beans', 1.69, '2023-03-26 20:15:00', 5);