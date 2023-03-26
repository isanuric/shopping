INSERT INTO public.users (email, password) VALUES
('user1@example.com', 'password1'),
('user2@example.com', 'password2'),
('user3@example.com', 'password3'),
('user4@example.com', 'password4'),
('user5@example.com', 'password5');

INSERT INTO public.products (name, description, price, stock)
VALUES
('Tomaten', 'Frische Tomaten aus der Region', 1.99, 50),
('Gurken', 'Knackige Gurken, ideal als Snack', 0.99, 30),
('Karotten', 'Süße Karotten mit viel Vitamin A', 1.49, 40),
('Rote Beete', 'Gesunde Rote Beete für den Salat', 2.29, 20),
('Kartoffeln', 'Frische Kartoffeln aus dem Acker', 0.79, 80),
('Zucchini', 'Zarte Zucchini für die leichte Küche', 1.79, 25),
('Brokkoli', 'Gesunder Brokkoli für die gesunde Ernährung', 2.49, 15),
('Blumenkohl', 'Fruchtiger Blumenkohl, ideal für Aufläufe', 1.99, 20),
('Spinat', 'Frischer Spinat für die grüne Küche', 2.99, 10),
('Champignons', 'Leckere Champignons für die Pfanne', 2.49, 30);

INSERT INTO public.orders (order_date, user_id) VALUES
('2023-03-25 10:00:00', 1),
('2023-03-26 11:00:00', 1),
('2023-03-27 12:00:00', 2);

INSERT INTO public.order_items (quantity, product_id, order_id) VALUES
(2, 1, 1),
(3, 1, 2),
(1, 1, 3);
