CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_employee`(
p_first_name VARCHAR(45),
p_last_name VARCHAR(45),
p_department_id INT)
BEGIN
    INSERT INTO employees
    (first_name , last_name , id_departments)
    VALUES
    (p_first_name , p_last_name , p_department_id);
END