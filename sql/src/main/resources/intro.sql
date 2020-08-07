# create a table
CREATE TABLE employees (
    id_employees INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    id_departments INT(6) UNSIGNED,
    FOREIGN KEY (id_departments)
        REFERENCES departments (id_departments)
);

# insert data 
INSERT INTO
employees
(first_name, last_name, id_departments)
VALUES
(' John',' Smith', 1),
(' John',' Cage', 2),
(' Jadine',' Mcclain', 3),
(' Ibraheem',' Mcfadden', 1),
(' Kade',' Christie', 2);

# select
SELECT 
    *
FROM
    employees;

# delete
DELETE FROM employees 
WHERE
    employees.id_employees = 4;
    
# delete table
DROP TABLE employees;