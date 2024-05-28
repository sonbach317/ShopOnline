CREATE DATABASE IF NOT EXISTS QLNS;
USE QLNS;

-- Create the admin table
CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    password VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    name VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    UNIQUE (username)
);

-- Create the boardnew table
CREATE TABLE boardnew (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) CHARACTER SET UTF8MB4 NOT NULL,
    content VARCHAR(4000) CHARACTER SET UTF8MB4 NOT NULL,
    image_link VARCHAR(4000) CHARACTER SET UTF8MB4 NOT NULL,
    author VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    created DATE NOT NULL
);

-- Create the catalog table
CREATE TABLE catalog (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    parent_id INT NULL
);

-- Create the product table
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    catalog_id INT NOT NULL,
    name VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    price VARCHAR(20) CHARACTER SET UTF8MB4 NOT NULL,
    status INT NOT NULL,
    description VARCHAR(4000) CHARACTER SET UTF8MB4 NOT NULL,
    content VARCHAR(4000) CHARACTER SET UTF8MB4 NOT NULL,
    discount INT NULL,
    image_link VARCHAR(4000) CHARACTER SET UTF8MB4 NOT NULL,
    created DATE NOT NULL,
    FOREIGN KEY (catalog_id) REFERENCES catalog(id) ON DELETE CASCADE
);

-- Create the transactions table
CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_session VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    user_name VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    user_mail VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    user_phone VARCHAR(20) CHARACTER SET UTF8MB4 NOT NULL,
    address VARCHAR(300) CHARACTER SET UTF8MB4 NOT NULL,
    message VARCHAR(4000) CHARACTER SET UTF8MB4 NOT NULL,
    amount VARCHAR(20) CHARACTER SET UTF8MB4 NOT NULL,
    payment VARCHAR(30) CHARACTER SET UTF8MB4 NOT NULL,
    status VARCHAR(30) CHARACTER SET UTF8MB4 NULL,
    created DATE NOT NULL
);

-- Create the ordered table
CREATE TABLE ordered (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    transaction_id INT NOT NULL,
    qty INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE,
    FOREIGN KEY (transaction_id) REFERENCES transactions(id) ON DELETE CASCADE
);

-- Create the review table
CREATE TABLE review (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    name VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    email VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    content VARCHAR(4000) CHARACTER SET UTF8MB4 NOT NULL,
    created DATE NULL,
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);

-- Create the users table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    email VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    phone VARCHAR(20) CHARACTER SET UTF8MB4 NOT NULL,
    username VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    password VARCHAR(50) CHARACTER SET UTF8MB4 NOT NULL,
    created DATE NOT NULL,
    UNIQUE (email),
    UNIQUE (username)
);

-- Insert data into the admin table
INSERT INTO admin (id, username, password, name) VALUES (1, 'admin', '123456', 'Thị Giang');

-- Insert data into the boardnew table
INSERT INTO boardnew (id, title, content, image_link, author, created) VALUES (5, 'Rau sạch', 'Rau rất sạch', '', 'Lan Ngọc', '2024-03-21');

-- Insert data into the catalog table
INSERT INTO catalog (id, name, parent_id) VALUES (1, 'Thịt', NULL);

-- Insert data into the product table
INSERT INTO product (id, catalog_id, name, price, status, description, content, discount, image_link, created) 
VALUES 
(1, 1, 'Thịt trâu gác bếp', '400.000', 1, 'Đây là thịt trâu', 'Món thịt này được chế biến từ bắp thịt không có gân và bỏ các thịt thừa bèo nhèo từ trâu, bò hoặc heo nuôi thả rông trên các vùng núi Tây Bắc. Thịt được lóc và thái dọc theo thớ thịt 20cm và dày 5cm thành các miếng hình con chì.', 0, 'thit_trau.jpg', '2020-05-22'),
(2, 1, 'Thịt Lợn gác bếp', '350.000', 1, 'Đây là thịt lợn', 'Món thịt này được chế biến từ bắp thịt không có gân và bỏ các thịt thừa bèo nhèo từ trâu, bò hoặc heo nuôi thả rông trên các vùng núi Tây Bắc. Thịt được lóc và thái dọc theo thớ thịt 20cm và dày 5cm thành các miếng hình con chì.', 0, 'thit_lon.jpg', '2020-05-22');

-- Insert data into the transactions table
INSERT INTO transactions (id, user_session, user_name, user_mail, user_phone, address, message, amount, payment, status, created) 
VALUES 
(1, 'sonbach', 'bach', 'bach10a1.hy@gmail.com', '0383919968', 'hy', 'ôk', '189.000', '0', 'Chưa thanh toán', '2024-03-14'),
(2, 'sonbach', 'dsa', 'i@gmail.com', '0123456789', 'áda', 'dsadsa', '75.200', '0', NULL, '2024-03-14'),
(3, 'sonbach', 'Kiet ngu', 'dsadasdads@gmail.com', '0123456745', 'Hà Nội', 'Giao rau tươi nhé', '112.100', '0', NULL, '2024-03-17'),
(4, 'sonbach', 'Bách', 'bach10a1.hy@gmail.com', '1231231231', 'Hà Nội', '', '12.600', '1', NULL, '2024-03-21'),
(5, 'sonbach2', 'Nguyễn Sơn Bách', 'bach@gmail.com', '0383919968', 'Hà nội', '', '180.000', '0', NULL, '2024-03-21');

-- Insert data into the users table
INSERT INTO users (id, name, email, phone, username, password, created) 
VALUES 
(1, 'sonbach', 'bach10a1.hy@gmail.com', '0383919968', 'sonbach', '123456789', '2024-03-14'),
(2, 'sonbach2', 'bach@gmail.com', '0383919968', 'sonbach2', '123456789', '2024-03-21');
