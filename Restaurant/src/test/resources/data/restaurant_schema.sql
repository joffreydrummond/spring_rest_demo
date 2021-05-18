DROP TABLE IF EXISTS `employees`;
DROP TABLE IF EXISTS `food_orders`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `foods`;

CREATE TABLE `foods` (
    food_id INT NOT NULL AUTO_INCREMENT primary key,
    food_name char(45) NOT NULL,
    food_type ENUM('ENTREE', 'APPETIZER', 'DESSERT', 'DRINK', 'ALCOHOL') NOT NULL,
    description VARCHAR(125) NOT NULL,
    is_gluten_free BOOLEAN NOT NULL,
    is_vegan BOOLEAN NOT NULL,
    price DECIMAL(4 , 2 ) NOT NULL
   );

CREATE TABLE `customers` (
	customer_id INT NOT NULL AUTO_INCREMENT primary key,
    first_name char(50) NOT NULL,
    last_name char(50) NOT NULL,
    address char(45) NOT NULL,
    phone char(20) NOT NULL,
    email char(50) NOT NULL
);

CREATE TABLE `orders` (
	order_id INT NOT NULL AUTO_INCREMENT primary key,
    price decimal(4,2) NOT NULL,
    order_date date NOT NULL,
    order_filled boolean NOT NULL,
    order_type enum('CARRYOUT', 'DELIVERY', 'CURBSIDE') NOT NULL,
    customer_id int not null,
   FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
 );

CREATE TABLE `food_orders` (
    food_orders_id int not null auto_increment primary key,
    order_id int not null,
    food_id int not null,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (food_id) REFERENCES foods(food_id)
);

CREATE TABLE `employees` (
	emp_id INT NOT NULL AUTO_INCREMENT primary key,
    emp_type enum ('MANAGER', 'STAFF') NOT NULL,
    order_id int not null,
    FOREIGN KEY (order_id) REFERENCES `orders`(order_id)
);
