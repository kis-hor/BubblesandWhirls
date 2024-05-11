CREATE TABLE users(
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(40),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(255),
    phone_number VARCHAR(15), 
    password VARCHAR(100),
    role VARCHAR(20)
);