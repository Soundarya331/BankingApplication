

-- CREATE product

CREATE TABLE product (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(15),
    product_desc VARCHAR(100),
    price NUMERIC(7,2),
    product_category VARCHAR(50)
);

--insertion 
INSERT INTO product (product_id, product_name, product_desc, price, product_category)
VALUES
(1, 'Monitor', 'Best monitor', 1250.99, 'Electronics'),
(2, 'Keyboard', 'Best keyboard', 350.99, 'Electronics'),
(3, 'Paper', 'Best paper', 125.99, 'Stationery'),
(4, 'Mouse', 'Wireless mouse', 499.99, 'Electronics'),
(5, 'Notebook', 'Hardcover notebook', 89.99, 'Stationery');



-- Count products in each category
SELECT product_category, COUNT(*) AS number_of_products
FROM product
GROUP BY product_category;

-- Categories having more than 2 products (ascending order)
SELECT product_category, COUNT(*) AS number_of_products
FROM product
GROUP BY product_category
HAVING COUNT(*) > 2
ORDER BY number_of_products ;

-- Second highest price product
SELECT *
FROM product
WHERE price = (
    SELECT MAX(price)
    FROM product
    WHERE price < (SELECT MAX(price) FROM product)
);

-- Reduce Electronics price by 10%
UPDATE product
SET price = price * 0.90
WHERE product_category = 'Electronics';

-- Delete products below overall average price
DELETE FROM product
WHERE price < (SELECT AVG(price) FROM product);

-- Delete products below category average
DELETE FROM product p1
WHERE p1.price < (
    SELECT AVG(price)
    FROM product p2
    WHERE p1.product_category = p2.product_category
);

-- View category averages
SELECT product_category, AVG(price)
FROM product
GROUP BY product_category;


-- CREATE orders

CREATE TABLE orders (
    o_id SERIAL PRIMARY KEY,
    order_date DATE,
    order_type VARCHAR(25),
    product_id INT REFERENCES product(product_id) ON DELETE CASCADE
);


-- insertions

INSERT INTO orders (order_date, order_type, product_id)
VALUES
('2026-02-17', 'New', 1),
('2026-02-18', 'Repeat', 2),
('2026-02-19', 'New', 3),
('2026-02-20', 'Repeat', 1),
('2026-02-21', 'New', 2);



-- Most ordered product
SELECT *
FROM product
WHERE product_id = (
    SELECT product_id
    FROM orders
    GROUP BY product_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
);

-- Delete product (CASCADE deletes related orders)
DELETE FROM product
WHERE product_id = 1;
