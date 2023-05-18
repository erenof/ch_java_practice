CREATE TABLE customer(
                       customer_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(75) NOT NULL,
                       email VARCHAR(75) NOT NULL,
                       address VARCHAR(75) NOT NULL,
                       dni INTEGER UNIQUE NOT NULL
);

CREATE TABLE product(
                        product_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                        product_name VARCHAR(150),
                        product_description VARCHAR(150),
                        price INTEGER,
                        stock INTEGER
);