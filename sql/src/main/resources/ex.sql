create TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100)
);

create TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    amount DOUBLE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

insert into `customers` (`customer_id`, `customer_name`) VALUES
(1, 'Adam'),
(2, 'Andy'),
(3, 'Joe'),
(4, 'Sandy');

insert into `orders` (`order_id`, `customer_id`, `amount`) VALUES
(1, 1, 19.99),
(2, 1, 35.15),
(3, 3, 17.56),
(4, 4, 12.34);

select * from customers join orders;

select * from customers join orders
where customers.customer_id = orders.customer_id;

select * from customers join orders
where customers.customer_id = orders.customer_id
and orders.amount > 15;

# left outer join
select * from customers left outer join orders
using (customer_id);

# right outer join
select * from customers right outer join orders
using (customer_id);